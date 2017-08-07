package com.doccuty.epill.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

	private static final Logger LOG = LoggerFactory.getLogger(ImageService.class);
	

	@Autowired
	ImageRepository repository;

	
	public Image findImageByDrugId(long iddrug) {

		Image image = repository.findByDrugId(iddrug);
		
		if(image == null) {
			image = repository.findOne(1L);
		}
		
		return image;
	}

}
