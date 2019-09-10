package com.doccuty.epill.userdrugplan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.model.Interaction;
import com.doccuty.epill.user.User;

public class UserDrugPlanCalculator {
        private static final Logger LOG = LoggerFactory.getLogger(UserDrugPlanCalculator.class);

        private final User user;
        private final List<Drug> userDrugsTaking;

        public UserDrugPlanCalculator(User user, List<Drug> userDrugsTaking) {
                this.user = user;
                this.userDrugsTaking = userDrugsTaking;
        }

        public List<UserDrugPlan> calculatePlanForDay(Date day) {
                LOG.info("calculate plan for day {}", day);
                List<UserDrugPlan> userDrugPlanForDay = new ArrayList<>();
                LOG.info("breakfast={}, lunch={}, dinner={}", this.user.getBreakfastTime(), this.user.getLunchTime(),
                                this.user.getDinnerTime());
                for (final Drug drug : userDrugsTaking) {
                        LOG.info("drug taking {}, ", drug.getName());
                        userDrugPlanForDay.addAll(createDefaultUserDrugPlanItems(drug, user, day));
                }

                userDrugPlanForDay = getSortedUserDrugPlanByDatetimeIntakePlanned(userDrugPlanForDay);

                userDrugPlanForDay = adjustUserDrugPlanByInteractions(userDrugPlanForDay);

                return userDrugPlanForDay;
        }

        private List<UserDrugPlan> adjustUserDrugPlanByInteractions(List<UserDrugPlan> userDrugPlanForDay) {
                final StringBuilder interactionText = new StringBuilder();
                for (int i = 0; i < userDrugPlanForDay.size() - 1; i++) {
                        // check interactions between medicaments
                        // if interaction:
                        final Drug drug = userDrugPlanForDay.get(i).getDrug();
                        for (final Interaction interaction : drug.getInteraction()) {
                                final Drug drugCompare = userDrugPlanForDay.get(i + 1).getDrug();
                                if (interaction.getInteractionDrug().contains(drugCompare)) {
                                        interactionText.append("<p>" + drug.getName() + "</p> - " + drugCompare.getName() + ": "
                                                        + interaction.getInteraction() + "</p>");
                                }
                        }
                        if (checkInteraction(userDrugPlanForDay.get(i), userDrugPlanForDay.get(i + 1))) {
                                adjustDateTimeIntakePlanned(userDrugPlanForDay.get(i + 1));
                        }
                }

                return getSortedUserDrugPlanByDatetimeIntakePlanned(userDrugPlanForDay);
        }

        /**
         * add n hours ...
         *
         * @param userDrugPlanItemToAdjust
         */
        private void adjustDateTimeIntakePlanned(UserDrugPlan userDrugPlanItemToAdjust) {
                userDrugPlanItemToAdjust
                                .setDateTimePlanned(addHoursToJavaUtilDate(userDrugPlanItemToAdjust.getDatetimeIntakePlanned(), 2));
        }

        private boolean checkInteraction(UserDrugPlan userDrugPlanItem, UserDrugPlan userDrugPlanItem2) {
                // TODO: constructor with interactions
                return false;
        }

        public Date addHoursToJavaUtilDate(Date date, int hours) {
                final Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR_OF_DAY, hours);
                return calendar.getTime();
        }

        private List<UserDrugPlan> createDefaultUserDrugPlanItems(Drug drug, User user, Date day) {
                final List<UserDrugPlan> userDrugPlanForDay = new ArrayList<>();
                LOG.info("create default plan for day={} user={} drug={}", day, user.getUsername(), drug.getName());
                if (drug.getCountPerDay() == 1) {
                        userDrugPlanForDay.add(createDefaultUserDrugPlanItem(drug, user, day, this.user.getBreakfastTime()));
                } else if (drug.getCountPerDay() == 2) {
                        userDrugPlanForDay.add(createDefaultUserDrugPlanItem(drug, user, day, this.user.getBreakfastTime()));
                        userDrugPlanForDay.add(createDefaultUserDrugPlanItem(drug, user, day, this.user.getDinnerTime()));
                } else if (drug.getCountPerDay() == 3) {
                        userDrugPlanForDay.add(createDefaultUserDrugPlanItem(drug, user, day, this.user.getBreakfastTime()));
                        userDrugPlanForDay.add(createDefaultUserDrugPlanItem(drug, user, day, this.user.getLunchTime()));
                        userDrugPlanForDay.add(createDefaultUserDrugPlanItem(drug, user, day, this.user.getDinnerTime()));
                } else if (drug.getCountPerDay() > 3) {
                        LOG.warn("not supported for more than 3 intake times per day");
                }
                LOG.info("created {} items day={} user={} drug={}", userDrugPlanForDay.size(), day, user.getUsername(),
                                drug.getName());
                return userDrugPlanForDay;
        }

        private UserDrugPlan createDefaultUserDrugPlanItem(Drug drug, User user, Date day, int hourOfDay) {
                final UserDrugPlan item = new UserDrugPlan();
                item.setDateTimePlanned(getDate(day, hourOfDay));
                LOG.info("planned time {} for drug {} ", item.getDatetimeIntakePlanned(), drug.getName());
                item.setUser(user);
                item.setDrug(drug);
                return item;
        }

        private Date getDate(Date day, int hourOfDay) {
                final Calendar cal = Calendar.getInstance();
                cal.setTime(day);
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                cal.set(Calendar.MINUTE, 0);
                return cal.getTime();
        }

        private List<UserDrugPlan> getSortedUserDrugPlanByDatetimeIntakePlanned(List<UserDrugPlan> userDrugPlanForDay) {
                userDrugPlanForDay.sort(Comparator.comparing(o -> o.getDatetimeIntakePlanned()));
                return userDrugPlanForDay;
        }

}

