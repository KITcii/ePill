package com.doccuty.epill.packagingsection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doccuty.epill.model.util.PackagingSectionCreator;
import com.doccuty.epill.user.UserService;

import de.uniks.networkparser.Deep;
import de.uniks.networkparser.Filter;
import de.uniks.networkparser.IdMap;
import de.uniks.networkparser.json.JsonArray;
import de.uniks.networkparser.json.JsonObject;

@RestController
@RequestMapping("/packagingSection")
public class PackagingSectionController {

    @Autowired
    private UserService userService;

    @Autowired
    private PackagingSectionService service;

    /**
     * get user profiles of all users
     */
    
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getAllPackagingSection() {
    		// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        IdMap map = PackagingSectionCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(2)));
	    	
	    	List<PackagingSection> set = service.getAllPackagingSections();
	    	
	    	JsonObject json = new JsonObject();
	    	JsonArray sectionArray = new JsonArray();
	
	    	for(PackagingSection section : set) {
	    		sectionArray.add(map.toJsonObject(section));
	    	}
    	
		json.add("value", sectionArray);
			
		return new ResponseEntity<>(json, HttpStatus.OK);
    }
    
    /**
     * get a packaging section by id
     */
    
    @RequestMapping(value={"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getPackagingSectionById(@PathVariable(value = "id") int id) {
    		// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        PackagingSection section = service.getPackagingSectionById(id);
        
    		IdMap map = PackagingSectionCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(2)));
    	
    	
    		JsonObject json = new JsonObject();
		json.add("value", map.toJsonObject(section));

		return new ResponseEntity<>(json, HttpStatus.OK);
    }
    
    
    /**
     * get original packaging section by topicId and drugId
     */
    
    @RequestMapping(value={"/{topicId}/{drugId}"}, method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getPackagingSectionByTopicAndDrug(@PathVariable(value = "topicId") long topicId, @PathVariable(value = "drugId") long drugId) {
    		// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        PackagingSection section = service.getPackagingSectionByTopicAndDrug(topicId, drugId);
        
    		IdMap map = PackagingSectionCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(2)));
    	

		JsonObject json = map.toJsonObject(section);

		return new ResponseEntity<>(json, HttpStatus.OK);
    }
    
    
    /**
     * get tailored packaging section by topicId and drugId
     */
    
    @RequestMapping(value={"tailored/{topicId}/{drugId}"}, method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getTailoredPackagingSectionByTopicAndDrug(@PathVariable(value = "topicId") int topicId, @PathVariable(value = "drugId") long drugId) {
    		// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        PackagingSection section = service.getTailoredPackagingSection(topicId, drugId);
        
    		IdMap map = PackagingSectionCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(2)));
    	
    	
    		JsonObject json = map.toJsonObject(section);

		return new ResponseEntity<>(json, HttpStatus.OK);
    }
 
}
