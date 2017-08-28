package com.doccuty.epill.gender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doccuty.epill.authentication.AuthenticationService;
import com.doccuty.epill.gender.GenderRepository;
import java.util.List;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class GenderService {

    private static final Logger LOG = LoggerFactory.getLogger(GenderService.class);

	@Autowired
	GenderRepository repository;
	
	
	@Autowired
	AuthenticationService authenticationService;

	public List<Gender> getAllGender() {
		return (List<Gender>) repository.findAll();
	}

	
	public Gender saveGender(Gender gender) {
		LOG.info("Saved gender={}", gender);
		return repository.save(gender);
	}

	public Gender getGenderById(int id) {
		return repository.findOne(id);
	}
}
