package com.doccuty.epill.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/image")
public class ImageController {
	
    @Autowired
    private ImageService service;

    
    /**
     * get respective image for drug
     * @param id
     * @return
     */
    
    @RequestMapping(value={"drug/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<byte[]> findImageByDrugId(@PathVariable(value = "id") long id) {
	
	    	Image image = service.findImageByDrugId(id);
	
	    	byte[] img = null;
	    	
	    	if(image != null) {
	    		img = image.getImage();
	    		
	    		MediaType mT = null;
	    		
	    		switch(image.getFiletype()) {
	    			default:
	    				mT = MediaType.IMAGE_JPEG;
	    				break;
	    		}

	    		if(img != null)
	    			return ResponseEntity.ok().contentLength(img.length).contentType(mT).body(img);
	    	}
	    	
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
}
