package com.doccuty.epill.drug;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.doccuty.epill.drug.DrugService;
import com.doccuty.epill.packagingsection.PackagingSection;
import com.doccuty.epill.user.UserService;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

// Use Spring's testing support in JUnit
@RunWith(SpringRunner.class)
// Enable Spring features, e.g. loading of application-properties, etc.
@SpringBootTest
public class DrugTest {
    private static final Logger LOG = LoggerFactory.getLogger(DrugTest.class);

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

    /**
     * Test that getting a drug's indication group and serializing works
     */
    @Test
    @Transactional
    public void testGetDrugByIdAndSerializeIndicationGroup() {

    		Drug drug = drugService.findDrugById(1);
    		
    		
    		for(PackagingSection section : drug.getPackagingSection()) {
    			LOG.info("section id={} with text={}", section.getId(), section.getText());
    		}
    		
		assertTrue("Is best matching packaging section", drug.getPackagingSection().get(1).getText().equals("Niclas,<br />Hier steht eine andere Information für Männer bis 36 Jahren, die sich für dieses Medikament interessieren."));
	}
}
