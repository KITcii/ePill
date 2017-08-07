package com.doccuty.epill.gender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.doccuty.epill.authentication.AuthenticationService;
import com.doccuty.epill.country.CountryRepository;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.drug.DrugRepository;
import com.doccuty.epill.gender.GenderRepository;
import com.doccuty.epill.iteminvocation.ItemInvocation;
import com.doccuty.epill.language.Language;
import com.doccuty.epill.language.LanguageRepository;
import com.doccuty.epill.model.Country;
import com.doccuty.epill.model.DrugFeature;
import com.doccuty.epill.model.PackagingTopic;
import com.doccuty.epill.user.SimpleUser;
import com.doccuty.epill.user.User;

import java.util.List;

import java.security.SecureRandom;

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
		return repository.save(gender);
	}

	public Gender getGenderById(int id) {
		return repository.findOne(id);
	}
}
