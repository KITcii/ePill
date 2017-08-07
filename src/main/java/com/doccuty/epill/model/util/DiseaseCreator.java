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

import de.uniks.networkparser.interfaces.SendableEntityCreatorNoIndex;

import com.doccuty.epill.disease.Disease;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.gender.Gender;

import de.uniks.networkparser.IdMap;

import com.doccuty.epill.user.User;

public class DiseaseCreator implements SendableEntityCreatorNoIndex
{
   private final String[] properties = new String[]
   {
      Disease.PROPERTY_ID,
      Disease.PROPERTY_NAME
      //Disease.PROPERTY_DRUG,
      //Disease.PROPERTY_USER,
      //Disease.PROPERTY_GENDER
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Disease();
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

      if (Disease.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((Disease) target).getId();
      }

      if (Disease.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         return ((Disease) target).getName();
      }

      if (Disease.PROPERTY_DRUG.equalsIgnoreCase(attribute))
      {
         return ((Disease) target).getDrug();
      }

      if (Disease.PROPERTY_USER.equalsIgnoreCase(attribute))
      {
         return ((Disease) target).getUser();
      }

      if (Disease.PROPERTY_GENDER.equalsIgnoreCase(attribute))
      {
         return ((Disease) target).getGender();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (Disease.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         ((Disease) target).setName((String) value);
         return true;
      }

      if (Disease.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((Disease) target).setId(Integer.parseInt(value.toString()));
         return true;
      }

      if (SendableEntityCreatorNoIndex.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (Disease.PROPERTY_DRUG.equalsIgnoreCase(attrName))
      {
         ((Disease) target).withDrug((Drug) value);
         return true;
      }
      
      if ((Disease.PROPERTY_DRUG + SendableEntityCreatorNoIndex.REMOVE).equalsIgnoreCase(attrName))
      {
         ((Disease) target).withoutDrug((Drug) value);
         return true;
      }

      if (Disease.PROPERTY_USER.equalsIgnoreCase(attrName))
      {
         ((Disease) target).withUser((User) value);
         return true;
      }
      
      if ((Disease.PROPERTY_USER + SendableEntityCreatorNoIndex.REMOVE).equalsIgnoreCase(attrName))
      {
         ((Disease) target).withoutUser((User) value);
         return true;
      }

      if (Disease.PROPERTY_GENDER.equalsIgnoreCase(attrName))
      {
         ((Disease) target).withGender((Gender) value);
         return true;
      }
      
      if ((Disease.PROPERTY_GENDER + SendableEntityCreatorNoIndex.REMOVE).equalsIgnoreCase(attrName))
      {
         ((Disease) target).withoutGender((Gender) value);
         return true;
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
      ((Disease) entity).removeYou();
   }
}
