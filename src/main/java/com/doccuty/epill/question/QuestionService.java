package com.doccuty.epill.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doccuty.epill.model.Question;
import com.doccuty.epill.user.SimpleUser;
import com.doccuty.epill.user.User;

import java.util.List;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;


	public List<Question> getAllPackagingSections() {
		return questionRepository.findAll();
	}

	public Question saveQuestion(Question question) {

		return questionRepository.save(question);
	}

	public Question getQuestionById(long id) {
		Question question = questionRepository.findOne(id);
		return question;
	}

	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	public Question getNewQuestion(User user) {
		Question question = questionRepository.findOne((long) 1);
		return question;
	}
}
