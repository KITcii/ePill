package com.doccuty.epill.language;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handle all CRUD operations for languages.
 */
@Service
public class LanguageService {

    private static final Logger LOG = LoggerFactory.getLogger(LanguageService.class);

	@Autowired
	LanguageRepository repository;
	
	public List<Language> findAll() {
		return (List<Language>) repository.findAll();
	}
}
