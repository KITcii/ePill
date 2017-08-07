package com.doccuty.epill.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doccuty.epill.model.Question;
import com.doccuty.epill.model.util.QuestionCreator;
import com.doccuty.epill.model.util.UserCreator;
import com.doccuty.epill.packagingsection.PackagingSection;
import com.doccuty.epill.user.User;
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
public class QuestionController {

    @Autowired
    private QuestionService service;

    @Autowired
    private UserService userService;
    

    @RequestMapping("/question/all")
    public ResponseEntity<JsonObject> getAllQuestions() {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        IdMap map = QuestionCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(1)));
		
        List<Question> set = service.getAllQuestions();

		JsonObject json = new JsonObject();
    	JsonArray packagingSections = new JsonArray();

    	for(Question question : set) {
    		packagingSections.add(map.toJsonObject(question));
    	}
		
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
    
    @RequestMapping(value={"/question/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getQuestionById(@PathVariable(value = "id") int id) {

    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        IdMap map = QuestionCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(1)));
		
        Question question = service.getQuestionById(id);
    	

		JsonObject json = new JsonObject();
		json.add(map.toJsonObject(question));
    	
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
    

    @RequestMapping(value = "/question/save")
    public ResponseEntity<JsonObject> saveQuestion(@RequestBody Question question) {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        IdMap map = QuestionCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(1)));
		
    	question = service.saveQuestion(question);
    	
    	JsonObject json = new JsonObject();
    	json.add(map.toJsonObject(question));
		
    	return ResponseEntity.ok(json);
    }
    
    /*
     * get a new question for user which was not answered yet
     */
    
    @RequestMapping(value={"/question/new"}, method = RequestMethod.GET)
    public ResponseEntity<JsonObject> getNewQuestion() {
    	// A pragmatic approach to security which does not use much framework-specific magic. While other approaches
        // with annotations, etc. are possible they are much more complex while this is quite easy to understand and
        // extend.
        if (userService.isAnonymous()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
    	User user = userService.getUserById(userService.getCurrentUser().getId());
    	
    	Question question = service.getNewQuestion((User) user);
    	
        IdMap map = QuestionCreator.createIdMap("");
		map.withFilter(Filter.regard(Deep.create(1)));
		
    	JsonObject json = new JsonObject();
    	json.add("value", map.toJsonObject(question));
		
    	return new ResponseEntity<>(json,HttpStatus.OK);
    }
}
