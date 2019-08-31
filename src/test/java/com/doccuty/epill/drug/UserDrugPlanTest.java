package com.doccuty.epill.drug;

import com.doccuty.epill.user.UserService;
import com.doccuty.epill.userdrugplan.UserDrugPlan;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// Use Spring's testing support in JUnit
@RunWith(SpringRunner.class)
// Enable Spring features, e.g. loading of application-properties, etc.
@SpringBootTest
public class UserDrugPlanTest {
    private static final Logger LOG = LoggerFactory.getLogger(ItemInvocationTest.class);

    @Autowired
    private DrugService drugService;

    @Autowired
    private UserService userService;


    @Before
    public void setup() {
        userService.setCurrentUser(1L, "n.kannengiesser@web.de");
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
    public void testGetUserDrugPlans() {

        List<UserDrugPlan> userDrugPlanList =  drugService.getUserDrugPlansByUserId();
        assertNotNull(userDrugPlanList);
        assertEquals(2, userDrugPlanList.size());
    }
}
