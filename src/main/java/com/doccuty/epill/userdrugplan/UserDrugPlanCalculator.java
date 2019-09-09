package com.doccuty.epill.userdrugplan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doccuty.epill.drug.Drug;
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
		final List<UserDrugPlan> userDrugPlanForDay = new ArrayList<>();
		LOG.info("breakfast={}, lunch={}, dinner={}", this.user.getBreakfastTime(), this.user.getLunchTime(),
				this.user.getDinnerTime());
		for (final Drug drug : userDrugsTaking) {
			LOG.info("drug taking {}, ", drug.getName());
			userDrugPlanForDay.addAll(createDefaultUserDrugPlanItems(drug, user, day));
		}
		return userDrugPlanForDay;
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

}