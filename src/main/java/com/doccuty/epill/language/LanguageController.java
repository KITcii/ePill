package com.doccuty.epill.language;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doccuty.epill.model.util.UserCreator;
import com.doccuty.epill.user.UserService;

import de.uniks.networkparser.Deep;
import de.uniks.networkparser.Filter;
import de.uniks.networkparser.IdMap;
import de.uniks.networkparser.json.JsonArray;
import de.uniks.networkparser.json.JsonObject;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageService service;

    @Autowired
    private UserService userService;

    /**
     * get languages
     */
    
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getAllUsers() {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
    	IdMap map = UserCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(2)));
    	
    	List<Language> set = service.findAll();
    	
    	JsonObject json = new JsonObject();
    	JsonArray userArray = new JsonArray();

    	for(Language language : set) {
    		userArray.add(map.toJsonObject(language));
    	}
    	
		json.add("value", userArray);
			
		return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
