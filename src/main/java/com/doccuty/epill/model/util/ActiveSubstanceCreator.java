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

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.model.ActiveSubstance;
import de.uniks.networkparser.IdMap;

import com.doccuty.epill.model.SubstanceGroup;

public class ActiveSubstanceCreator implements SendableEntityCreatorNoIndex
{
   private final String[] properties = new String[]
   {
      ActiveSubstance.PROPERTY_ID,
      ActiveSubstance.PROPERTY_NAME,
      //ActiveSubstance.PROPERTY_DRUG,
      ActiveSubstance.PROPERTY_SUBSTANCEGROUP
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new ActiveSubstance();
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

      if (ActiveSubstance.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((ActiveSubstance) target).getId();
      }

      if (ActiveSubstance.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         return ((ActiveSubstance) target).getName();
      }

      if (ActiveSubstance.PROPERTY_DRUG.equalsIgnoreCase(attribute))
      {
         return ((ActiveSubstance) target).getDrug();
      }

      if (ActiveSubstance.PROPERTY_SUBSTANCEGROUP.equalsIgnoreCase(attribute))
      {
         return ((ActiveSubstance) target).getSubstanceGroup();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (ActiveSubstance.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         ((ActiveSubstance) target).setName((String) value);
         return true;
      }

      if (ActiveSubstance.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((ActiveSubstance) target).setId(Integer.parseInt(value.toString()));
         return true;
      }

      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (ActiveSubstance.PROPERTY_DRUG.equalsIgnoreCase(attrName))
      {
         ((ActiveSubstance) target).withDrug((Drug) value);
         return true;
      }
      
      if ((ActiveSubstance.PROPERTY_DRUG + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((ActiveSubstance) target).withoutDrug((Drug) value);
         return true;
      }

      if (ActiveSubstance.PROPERTY_SUBSTANCEGROUP.equalsIgnoreCase(attrName))
      {
         ((ActiveSubstance) target).setSubstanceGroup((SubstanceGroup) value);
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
      ((ActiveSubstance) entity).removeYou();
   }
}
