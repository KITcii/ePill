package com.doccuty.epill.packagingsection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.drug.DrugService;
import com.doccuty.epill.model.PackagingTopic;
import com.doccuty.epill.packaging.PackagingTopicRepository;
import com.doccuty.epill.tailoredtext.TailoredTextService;
import com.doccuty.epill.user.User;
import com.doccuty.epill.user.UserService;
import java.util.List;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PackagingSectionService {

    private static final Logger LOG = LoggerFactory.getLogger(PackagingSectionService.class);

    @Autowired
    PackagingSectionRepository repository;
    
    @Autowired
    PackagingTopicRepository topicRepository;

    @Autowired
    TailoredTextService serviceSummary;

    @Autowired
    DrugService drugService;

	@Autowired
	UserService userService;
	

	public List<PackagingSection> getAllPackagingSections() {
		return (List<PackagingSection>) repository.findAll();
	}

	public PackagingSection savePackagingSection(PackagingSection gender) {
		return repository.save(gender);
	}

	public PackagingSection getPackagingSectionById(long id) {
		return repository.findOne(id);
	}

	public PackagingSection getPackagingSectionByTopicAndDrug(long topicId, long drugId) {

		PackagingTopic topic = new PackagingTopic();
		topic.withId(topicId);
		
		Drug drug = new Drug();
		drug.withId(drugId);
		
		PackagingSection section = repository.findByTopicAndDrug(topic, drug);
		return section;
	}
	
	public PackagingSection getTailoredPackagingSection(long topicId, long drugId) {
		
		Drug drug = drugService.findDrugById(drugId);
		PackagingTopic topic = topicRepository.findOne(topicId);
		User user = userService.getCurrentUser();
		
		PackagingSection section = repository.findByTopicAndDrug(topic, drug);
		
		if(section == null)
			return null;
		
		PackagingSection tailoredSection = serviceSummary.findTailoredPackagingSummary(drug, section, user);
		
		if(tailoredSection == null)
			return section;
		
		return tailoredSection;
	}

}
