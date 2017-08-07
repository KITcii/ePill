package com.doccuty.epill.packagingsection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.model.PackagingTopic;

@Repository
public interface PackagingSectionRepository extends JpaRepository<PackagingSection, Long> {

	PackagingSection findByTopicAndDrug(PackagingTopic topic, Drug drug);

}
