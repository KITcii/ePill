package com.doccuty.epill.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doccuty.epill.model.util.DiseaseSet;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class DiseaseService {

	@Autowired
    DiseaseRepository repository;
	
    public DiseaseSet getAllDiseases() {
        return (DiseaseSet) repository.findAll();
    }


	public Disease getDiseaseById(long id) {
		return repository.findOne(id);
	}

    public void addDisease(Disease disease) {
    	repository.save(disease);
    }

}
