package com.doccuty.epill.drug;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doccuty.epill.model.PharmaceuticalForm;

public interface PharmaceuticalFormRepository extends JpaRepository<PharmaceuticalForm, Integer> {

	@Query("SELECT pF FROM PharmaceuticalForm pF WHERE pF.name LIKE :value")
	List<PharmaceuticalForm> findByName(@Param(value = "value") String value);
}
