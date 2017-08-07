package com.doccuty.epill.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doccuty.epill.model.Country;
import com.doccuty.epill.model.util.CountryCreator;
import com.doccuty.epill.model.util.UserCreator;
import com.doccuty.epill.user.UserService;

import de.uniks.networkparser.Deep;
import de.uniks.networkparser.Filter;
import de.uniks.networkparser.IdMap;
import de.uniks.networkparser.json.JsonArray;
import de.uniks.networkparser.json.JsonObject;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService service;

    @Autowired
    private UserService userService;

    /*
     * get country profiles of all countries
     */
    
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getAllUsers() {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
    	IdMap map = CountryCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(2)));
    	
    	List<Country> set = service.getAll();
    	
    	JsonObject json = new JsonObject();
    	JsonArray countryArray = new JsonArray();

    	for(Country country : set) {
    		countryArray.add(map.toJsonObject(country));
    	}
    	
		json.add("value", countryArray);
			
		return new ResponseEntity<>(json, HttpStatus.OK);
    }
    
    /*
     * get a complete country profile by id
     */
    
    @RequestMapping(value={"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getUserById(@PathVariable(value = "id") int id) {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
    	IdMap map = UserCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(1)));
    	
        Country country = service.getById(id);
    	
    	JsonObject json = new JsonObject();

		json.add("value", map.toJsonObject(country));
		
		return new ResponseEntity<>(json, HttpStatus.OK);
    }
    
    /*
     * save or update a complete country profile
     */
    
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody Country country) {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
    	service.save(country);

		return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     * update all parameters from settings section including
     * preferredFontSize, preferredDrugFeatures, preferredPackagingTopics,
     * levelOfDetail
     */
    
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public ResponseEntity<JsonObject> updateUserData(@RequestBody Country country) {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        service.update(country);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     * physically delete country by id
     */
    
    @RequestMapping(value={"/delete/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") int id) {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        service.delete(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
