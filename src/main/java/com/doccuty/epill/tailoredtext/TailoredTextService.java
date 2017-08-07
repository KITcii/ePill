package com.doccuty.epill.tailoredtext;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doccuty.epill.disease.Disease;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.model.DrugFeature;
import com.doccuty.epill.packagingsection.PackagingSection;
import com.doccuty.epill.user.User;

@Service
public class TailoredTextService {

	private static final Logger logger = LoggerFactory.getLogger(TailoredTextService.class);
	
	@Autowired
	TailoredTextRepository repository;
	

	public Drug tailorDrugToUser(Drug drug, User user) {
		
		drug = this.tailorDrugFeatures(drug, user);
		
		drug = this.tailorDiseases(drug, user);
		
		
		// load tailored summary
		TailoredText summary = this.getTailoredSummaryByDrugAndUser(drug, user);

		if(summary != null) {
			drug.setTailoredSummary(summary.getText());
		}
		
		this.replaceSections(drug, user);
		
		return drug;
	}
	
	
	
	/**
	 * Get the minimum version of drug summary. This one is thought be displayed in detail view
	 * @param drug
	 * @param user
	 * @return
	 */
	
	public TailoredText getTailoredSummaryByDrugAndUser(Drug drug, User user) {
	
		List<TailoredText> list = repository.findByDrugAndTopicIsNullAndIsMinimum(drug, false);
		
		return findTailoredSummaryForUser(list, user);
	}
	
	
	
	/**
	 * Get the minimum version of drug summary. This one is thought be displayed in listings.
	 * If no minimum summary is available, regular summary is used.
	 * @param drug
	 * @param user
	 * @return
	 */
	
	public TailoredText getTailoredMinimumSummaryByDrugAndUser(Drug drug, User user) {
	
		List<TailoredText> list = repository.findByDrugAndTopicIsNullAndIsMinimum(drug, true);
	
		if(list.size() == 0) {
			return getTailoredSummaryByDrugAndUser(drug, user);
		}
		
		return findTailoredSummaryForUser(list, user);
	}

	
	/**
	 * Replace original packaging sections of the drug with tailored ones if available
	 * @param drug
	 * @param user
	 * @return
	 */
	
	public Drug replaceSections(Drug drug, User user) {

		for(PackagingSection section : drug.getPackagingSection()) {
			List<TailoredText> list = repository.findByDrugAndTopic(drug, section.getTopic());
			
			TailoredText summary = findTailoredSummaryForUser(list, user);
			
			if(summary != null) {
				section.withText(summary.getText()).setIsTailored(true);
			}
		}
		
		return drug;
	}
	
	
	/**
	 * Select all available tailored summaries for given drug, packaging section
	 * and select with repect to user characteristics
	 * @param drug
	 * @param section
	 * @param user
	 * @return
	 */
	
	public PackagingSection findTailoredPackagingSummary(Drug drug, PackagingSection section, User user) {
	
		List<TailoredText> list = repository.findByDrugAndTopic(drug, section.getTopic());
		
		TailoredText summary = findTailoredSummaryForUser(list, user);
		
		if(summary != null) {
			section.setText(summary.getText());
			section.setIsTailored(true);
		}
		
		return section;
	}
	
	
	/**
	 * Find and return first summary of a list that matches user characteristics
	 * A match is given if a text fits users' age and gender
	 * @param list
	 * @param user
	 * @return
	 */
	
	public TailoredText findTailoredSummaryForUser(List<TailoredText> list, User user) {
		
		if(user == null)
			return null;
		
		TailoredText summary = null;
		
		float delta = -1;
		
		
		// find section with minimal deviation between
		// section requirements and user characteristics
		for(TailoredText s : list) {
			float deltaTemp = calculateDelta(s, user);
			
			if(deltaTemp >= 0 && (deltaTemp < delta || delta == -1)) {
				summary = s;
				summary.personalize(user);
					
				delta = deltaTemp;
			}
		}
		
		return summary;
	}
	
	
	/**
	 * calculate deviation between section requirements for tailoring
	 * and user characteristics
	 * @param text
	 * @param user
	 * @return
	 */
    
    private float calculateDelta(TailoredText text, User user) {
    	
    		float delta = 0;
    		
    		// measure deviation from age
    		if(user.getAge() != 0 && text.getMinAge() <= user.getAge() && text.getMaxAge() >= user.getAge()) {
    			
    			// user's age is in range of target age and closer to max age
    			delta = text.getMaxAge() - text.getMinAge();
    		
    		} else if (user.getAge() != 0 && text.getMinAge() <= user.getAge() && text.getMaxAge() == 0) {
    			// user's age is in range of section (infinite max age)
    			delta = 200;
    		} else if(user.getAge() == 0) {
    			// no limitation for age can be measured, because user
    			// did not enter her date of birth
    			
    			if(text.getMaxAge() > 0) {
    				delta = text.getMaxAge();
    			} else if(text.getMinAge() > 0) {
    				delta = text.getMinAge();
    			} else {
    				delta = 200;
    			}
    			
    		} else {
    			// text does not fit user's age and can not be used
    			return -1;
    		}
    		
    		
    		// measure deviation from gender
    		
    		if(text.getGender() != null && user.getGender() == null) {
			// user did not enter her gender
			// gender cannot be used as requirement
			delta = delta * 3;
			
		} else if(text.getGender() == null) {
			// no gender requirements for text
			
			delta += 100;
			
		} else if(text.getGender() != null && user.getGender() != null && text.getGender().getId() != user.getGender().getId()) {
			// user's gender does not match tailoring requirements
			return -1;
		}
    		
    		return delta;
    }
	
	/**
	 * Remove diseases that are irrelevant for current user
	 * @param drug
	 * @param user
	 * @return
	 */
	
	private Drug tailorDiseases(Drug drug, User user) {
		
		if(user == null) {
			return drug;
		}
		
		Iterator<Disease> diseases = drug.getDisease().iterator();
		while (diseases.hasNext()) {
			Disease disease = diseases.next();
	
			if(disease.getGender().size() > 0 && user.getGender() != null && !disease.getGender().contains(user.getGender())) {
	    				
	    			logger.info("Removed irrelevant disease. feature={} gender={}", disease.getName(), user.getGender());
	
	    			diseases.remove();
	    		}
		}
		
		return drug;
	}
	

	/**
	 * Remove drug features that are irrelevant for current user
	 * @param drug
	 * @param user
	 * @return
	 */
	
    private Drug tailorDrugFeatures(Drug drug, User user) {
		// tailor drug features
		
    		if(user == null) {
    			return drug;
    		}
    	
		Iterator<DrugFeature> features = drug.getDrugFeature().iterator();
		while (features.hasNext()) {
			DrugFeature feature = features.next();

			if(user.getAge() != 0 && (user.getAge() < feature.getMinAge()
				|| feature.getMaxAge() != 0 && user.getAge() > feature.getMaxAge())
	    			|| (feature.getGender().size() > 0 && user.getGender() != null && !feature.getGender().contains(user.getGender()))) {
	    				
	    			logger.info("Removed irrelevant drug feature. feature={} gender={}", feature.getDrugFeature(), user.getGender());
	
	    			features.remove();
	    		}
		}
		
		return drug;
	}
}
