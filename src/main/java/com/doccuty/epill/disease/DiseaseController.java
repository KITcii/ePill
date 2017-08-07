package com.doccuty.epill.disease;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.model.util.DiseaseCreator;
import com.doccuty.epill.model.util.DiseaseSet;
import com.doccuty.epill.model.util.DrugCreator;
import com.doccuty.epill.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import de.uniks.networkparser.Deep;
import de.uniks.networkparser.Filter;
import de.uniks.networkparser.IdMap;
import de.uniks.networkparser.json.JsonArray;
import de.uniks.networkparser.json.JsonObject;

/**
 * HTTP endpoint for a post-related HTTP requests.
 */
@RestController
public class DiseaseController {
	
    @Autowired
    private DiseaseService service;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/disease/all/")
    public ResponseEntity<JsonObject> getAllDiseases() {

        DiseaseSet set = service.getAllDiseases();

        IdMap map = DiseaseCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(2)));

    	JsonObject json = new JsonObject();
    	JsonArray diseaseArray = new JsonArray();
    	
    	for(Disease disease : set) {
    		diseaseArray.add(map.toJsonObject(disease));
    	}
    	
		json.add("value", diseaseArray);
		
		
		return new ResponseEntity<>(json, HttpStatus.OK);
    }
    
    @RequestMapping(value={"/disease/{id}/"}, method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getDiseaseById(@PathVariable(value = "id") int id) {

        Disease disease = service.getDiseaseById(id);

        IdMap map = DiseaseCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(2)));

    	JsonObject json = new JsonObject();
    	json.add("value", map.toJsonObject(disease));
    	
		return new ResponseEntity<>(json, HttpStatus.OK);
    }
    

    @RequestMapping(value = "/disease/save/")
    public ResponseEntity<Object> addDisease(@RequestParam("name") String name) {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
    	Disease disease = new Disease();
    	disease.setName(name);
    	
    	service.addDisease(disease);
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}
