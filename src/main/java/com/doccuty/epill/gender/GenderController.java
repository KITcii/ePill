package com.doccuty.epill.gender;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doccuty.epill.model.util.GenderCreator;
import com.doccuty.epill.user.UserService;

import de.uniks.networkparser.Deep;
import de.uniks.networkparser.Filter;
import de.uniks.networkparser.IdMap;
import de.uniks.networkparser.json.JsonArray;
import de.uniks.networkparser.json.JsonObject;

@RestController
@RequestMapping("/gender")
public class GenderController {

    @Autowired
    private UserService userService;

    @Autowired
    private GenderService service;

    /**
     * get user profiles of all users
     */
    
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getAllGender() {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
    	IdMap map = GenderCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(2)));
    	
    	List<Gender> set = service.getAllGender();
    	
    	JsonObject json = new JsonObject();
    	JsonArray genderArray = new JsonArray();

    	for(Gender gender : set) {
    		genderArray.add(map.toJsonObject(gender));
    	}
    	
		json.add("value", genderArray);
			
		return new ResponseEntity<>(json, HttpStatus.OK);
    }
    
    /**
     * get a complete user profile by id
     */
    
    @RequestMapping(value={"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getUserById(@PathVariable(value = "id") int id) {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
    	IdMap map = GenderCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(5)));
    	
        Gender gender = service.getGenderById(id);
    	
    	JsonObject json = new JsonObject();
		json.add("value", map.toJsonObject(gender));

		return new ResponseEntity<>(json, HttpStatus.OK);
    }
    
    /**
     * save or update a complete user profile
     * @param user
     * @return
     */
    
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody Gender gender) {
		
    	service.saveGender(gender);

		return new ResponseEntity<>(HttpStatus.OK);
    }
    
    /**
     * update all parameters from settings section including
     * @param user
     * @return
     */
    
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public ResponseEntity<JsonObject> updateUserSettings(@RequestBody Gender gender) {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        gender = service.saveGender(gender);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
