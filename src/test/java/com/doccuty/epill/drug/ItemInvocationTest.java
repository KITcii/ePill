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
import com.doccuty.epill.iteminvocation.ItemInvocation;
import com.doccuty.epill.model.util.DrugCreator;
import com.doccuty.epill.model.util.ProductGroupCreator;
import com.doccuty.epill.user.UserService;

import de.uniks.networkparser.Deep;
import de.uniks.networkparser.Filter;
import de.uniks.networkparser.IdMap;
import de.uniks.networkparser.json.JsonObject;

import javax.transaction.Transactional;

import java.util.List;
import static org.junit.Assert.*;

// Use Spring's testing support in JUnit
@RunWith(SpringRunner.class)
// Enable Spring features, e.g. loading of application-properties, etc.
@SpringBootTest
public class ItemInvocationTest {
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


    
    /**
     * Test that adding a new user leads to an id (and the post is thus persisted).
     */
    @Test
    @Transactional
    public void testUserDrugTaking() {

    		List<ItemInvocation> invocations = drugService.getClicksByUserId();
    		
    		LOG.info("Current size of invocations is {}", invocations.size());
    		
	    	assertEquals("1 different medications invoced by current user", 0, invocations.size());
	    	
	}
    
    /**
     * Test that getting a drug and serializing works
     */
    @Test
    @Transactional
    public void testGetDrugById() {

		Drug drug1 = drugService.findDrugById(2);
		Drug drug2 = drugService.findDrugById(4);

		assertNotNull("No drug1 found.", drug1);
		assertNotNull("No drug2 found.", drug2);
	    	
		
		/*
		 *  only works with deep filter of <= 2 for iddrug = 1 (4 is needed)
		 *  works with iddrug = 4
		 */
		
		IdMap map = DrugCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(4)));

		JsonObject json = map.toJsonObject(drug1);
		JsonObject json2 = map.toJsonObject(drug2);
		
		LOG.info("json={}", json);
		LOG.info("json2={}", json2);
		

		if(drug1.getProductGroup() != null) {
			//LOG.info("\nproduct group = {}\njson={}", drug1.getProductGroup(), json.get("productGroup").toString());
		}

		if(drug1.getIndicationGroup() != null) {
			//LOG.info("\nindication group = {}\njson={}", drug1.getIndicationGroup(), json.get("indicationGroup").toString());
		}
		
		assertNotNull("No product group found.", json.get("productGroup"));
		assertNotNull("No indication group found.", json.get("indicationGroup"));
	}
    
    
    /**
     * Test that getting a drug's product group and serializing works
     */
    @Test
    @Transactional
    public void testGetDrugByIdAndSerializeProductGroup() {

    		Drug drug = drugService.findDrugById(1);
    		
	    	assertNotNull("No drug found.", drug);
	    	
		IdMap map = ProductGroupCreator.createIdMap("");
		
		map.withFilter(Filter.regard(Deep.create(4)));
		
		JsonObject json = map.toJsonObject(drug.getProductGroup());

		if(drug.getProductGroup() != null) {
			LOG.info("\nproduct group = {}\njson={}", drug.getProductGroup(), json.toString());
		}

		assertNotNull("No product group found.", json);
	}
    
    
    /**
     * Test that getting a drug's indication group and serializing works
     */
    @Test
    @Transactional
    public void testGetDrugByIdAndSerializeIndicationGroup() {

    		Drug drug = drugService.findDrugById(1);
    		
	    	assertNotNull("No drug found.", drug);
	    	
		IdMap map = ProductGroupCreator.createIdMap("");
		
		map.withFilter(Filter.regard(Deep.create(4)));
		
		JsonObject json = map.toJsonObject(drug.getIndicationGroup());

		if(drug.getIndicationGroup() != null) {
			LOG.info("\nproduct group = {}\njson={}", drug.getIndicationGroup(), json.toString());
		}

		assertNotNull("No indication group found.", json);
	}
}
