package com.doccuty.epill.tailoredtext;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.model.PackagingTopic;

public interface TailoredTextRepository extends JpaRepository<TailoredText,Long> {

	List<TailoredText> findByDrugAndTopicIsNullAndIsMinimum(Drug drug, boolean isMinimum);
	
	List<TailoredText> findByDrugAndTopic(Drug drug, PackagingTopic topic);
}
