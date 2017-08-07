package com.doccuty.epill.autocomplete;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doccuty.epill.disease.Disease;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.drug.DrugService;
import com.doccuty.epill.model.util.DiseaseCreator;
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
public class AutoCompleteController {

    @Autowired
    private DrugService service;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/autocomplete/search/", method = RequestMethod.POST)
    public ResponseEntity<JsonObject> getAllUsers(@RequestParam String exp, @RequestParam int iduser) {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        List<Drug> list = service.findAllDrugs();
        IdMap map = DiseaseCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(1)));

    	JsonObject json = new JsonObject();
    	JsonArray drugArray = new JsonArray();
    	
    	for(Drug drug : list) {
    		drugArray.add(map.toJsonObject(drug));
    	}
    	
		json.add("value", drugArray);
		
		return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
