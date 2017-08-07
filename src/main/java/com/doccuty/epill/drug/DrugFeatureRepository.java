package com.doccuty.epill.drug;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doccuty.epill.model.DrugFeature;

public interface DrugFeatureRepository extends JpaRepository<DrugFeature, Long> {

	@Query("SELECT feature FROM DrugFeature feature ORDER BY feature.drugFeature")
	List<DrugFeature> findAllOrderByName();
	
	@Query("SELECT feature FROM DrugFeature feature WHERE feature.drugFeature = :value")
	List<DrugFeature> findByName(@Param(value = "value") String value);

	@Query("SELECT NEW DrugFeature(feature.id, feature.drugFeature) FROM DrugFeature feature ORDER BY feature.drugFeature")
	List<DrugFeature> findAllSimple();
}
