package com.doccuty.epill.userdrugplan;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.user.User;

/**
 * implementing logic for calculating user drug plan depending on user settings, taken drugs and interactions 
 * 
 * @author cs
 *
 */
public class UserDrugPlanCalculator {

	private static final Logger LOG = LoggerFactory.getLogger(UserDrugPlanCalculator.class);
	private User user;

	public UserDrugPlanCalculator(User user) {
		this.user = user;
	}
	
	public boolean calculatePlanForDay(Date date) {
		LOG.info("calculating plan for day {}", date);
		
		for (Drug drug : user.getTakingDrug()) {
			LOG.info("drug taking: {}, count per day = {}, empty={}, full={}", drug.getName(), drug.getCountPerDay(), 
					drug.getTakeOnEmptyStomach(), drug.getTakeOnFullStomach());
		}
		
		return true;
	}
}
