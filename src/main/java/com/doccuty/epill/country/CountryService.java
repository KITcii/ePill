package com.doccuty.epill.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doccuty.epill.model.Country;


@Service
public class CountryService {

	@Autowired
	CountryRepository repository;


	public List<Country> getAll() {
		return repository.findAll();
	}

	public Country getById(int id) {
		return repository.findOne(id);
	}
	
	public void update(Country country) {
		repository.save(country);
	}

	public void delete(int id) {
		Country country = repository.findOne(id);
		repository.delete(country);
	}

	public void save(Country country) {
		repository.save(country);
	}
}
