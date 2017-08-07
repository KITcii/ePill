package com.doccuty.epill.image;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ImageRepository extends JpaRepository<Image, Long> {

	@Query("SELECT drug.image FROM Drug drug WHERE drug.id = :id)")
	Image findByDrugId(@Param(value = "id") long id);
}
