/*
   Copyright (c) 2017 mac
   
   Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
   and associated documentation files (the "Software"), to deal in the Software without restriction, 
   including without limitation the rights to use, copy, modify, merge, publish, distribute, 
   sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
   furnished to do so, subject to the following conditions: 
   
   The above copyright notice and this permission notice shall be included in all copies or 
   substantial portions of the Software. 
   
   The Software shall be used for Good, not Evil. 
   
   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
   BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
   NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
   DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
   
package com.doccuty.epill.model.util;

import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.interfaces.SendableEntityCreatorNoIndex;

import com.doccuty.epill.image.Image;

import de.uniks.networkparser.IdMap;

public class ImageCreator implements SendableEntityCreatorNoIndex
{
   private final String[] properties = new String[]
   {
	  Image.PROPERTY_ID,
	  Image.PROPERTY_FILENAME,
	  Image.PROPERTY_FILETYPE,
	  Image.PROPERTY_UPLOADEDATE
	  
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Image();
   }
   
   @Override
   public Object getValue(Object target, String attrName)
   {
      int pos = attrName.indexOf('.');
      String attribute = attrName;
      
      if (pos > 0)
      {
         attribute = attrName.substring(0, pos);
      }

      if (Image.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((Image) target).getId();
      }

      if (Image.PROPERTY_FILENAME.equalsIgnoreCase(attribute))
      {
         return ((Image) target).getFilename();
      }

      if (Image.PROPERTY_FILETYPE.equalsIgnoreCase(attribute))
      {
         return ((Image) target).getFiletype();
      }

      if (Image.PROPERTY_UPLOADEDATE.equalsIgnoreCase(attribute))
      {
         return ((Image) target).getUploadedAt();
      }

      if (Image.PROPERTY_IMAGE.equalsIgnoreCase(attribute))
      {
         return ((Image) target).getImage();
      }

      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (Image.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((Image) target).setId((long) value);
         return true;
      }
      
      if (Image.PROPERTY_FILENAME.equalsIgnoreCase(attrName))
      {
    	  ((Image) target).setFilename((String) value);
    	  return true;
      }

      if (Image.PROPERTY_FILETYPE.equalsIgnoreCase(attrName))
      {
         ((Image) target).setFiletype((String) value);
         return true;
      }

      if (Image.PROPERTY_UPLOADEDATE.equalsIgnoreCase(attrName))
      {
         ((Image) target).setFiletype(attrName);
         return true;
      }

      if (Image.PROPERTY_IMAGE.equalsIgnoreCase(attrName))
      {
         ((Image) target).setImage((byte[]) value);
         return true;
      }

      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }
      
      return false;
   }
   
   public static IdMap createIdMap(String sessionID)
   {
      return com.doccuty.epill.model.util.CreatorCreator.createIdMap(sessionID);
   }
   
   //==========================================================================
      public void removeObject(Object entity)
   {
      ((Image) entity).removeYou();
   }
}
