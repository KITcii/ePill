package com.doccuty.epill.drug;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.doccuty.epill.user.User;
import com.doccuty.epill.user.UserService;
import com.doccuty.epill.userdrugplan.DateUtils;
import com.doccuty.epill.userdrugplan.UserDrugPlan;
import com.doccuty.epill.userdrugplan.UserDrugPlanCalculator;
import com.doccuty.epill.userdrugplan.UserDrugPlanRepository;;

// Use Spring's testing support in JUnit
@RunWith(SpringRunner.class)
// Enable Spring features, e.g. loading of application-properties, etc.
@SpringBootTest
public class UserDrugPlanCalculatorTest {
	private static final Logger LOG = LoggerFactory.getLogger(UserDrugPlanCalculatorTest.class);

	@Autowired
	private DrugService drugService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserDrugPlanRepository userDrugPlanRepository;

	@Before
	public void setup() {
		userService.setCurrentUser(2L, "cs@test.de");
	}

	/**
	 * Test that dependency injection works.
	 */
	@Test
	public void notNull() {
		assertNotNull("We should have an instance of drugService", drugService);
		assertNotNull("We should have an instance of userService", userService);
	}

	@Test
	@Transactional
	public void testCalculatePlan() {
		LOG.info("testing calculating plan");

		final Date testDay = new Date();
		final User currentUser = userService.findUserById(userService.getCurrentUser().getId());
		final UserDrugPlanCalculator calculator = new UserDrugPlanCalculator(currentUser,
				drugService.findUserDrugsTaking(currentUser));
		final List<UserDrugPlan> planForDay = calculator.calculatePlanForDay(testDay);
		assertTrue(planForDay.size() > 0);
		userDrugPlanRepository.deleteByUserBetweenDates(currentUser.getId(), DateUtils.asDateStartOfDay(testDay),
				DateUtils.asDateEndOfDay(testDay));
		userDrugPlanRepository.save(planForDay);
	}
}