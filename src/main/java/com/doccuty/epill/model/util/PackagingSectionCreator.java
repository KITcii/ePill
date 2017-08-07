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
import de.uniks.networkparser.IdMap;
import com.doccuty.epill.model.PackagingTopic;
import com.doccuty.epill.packagingsection.PackagingSection;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.iteminvocation.ItemInvocation;

public class PackagingSectionCreator implements SendableEntityCreatorNoIndex
{
   private final String[] properties = new String[]
   {
      PackagingSection.PROPERTY_ID,
      PackagingSection.PROPERTY_TOPIC,
      PackagingSection.PROPERTY_TEXT,
      //PackagingSection.PROPERTY_DRUG,
      //PackagingSection.PROPERTY_CLICKS,
      PackagingSection.PROPERTY_ISTAILORED
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new PackagingSection();
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

      if (PackagingSection.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((PackagingSection) target).getId();
      }

      if (PackagingSection.PROPERTY_ISTAILORED.equalsIgnoreCase(attribute))
      {
         return ((PackagingSection) target).getIsTailored();
      }

      if (PackagingSection.PROPERTY_TOPIC.equalsIgnoreCase(attribute))
      {
         return ((PackagingSection) target).getTopic();
      }

      if (PackagingSection.PROPERTY_TEXT.equalsIgnoreCase(attribute))
      {
         return ((PackagingSection) target).getText();
      }

      if (PackagingSection.PROPERTY_DRUG.equalsIgnoreCase(attribute))
      {
         return ((PackagingSection) target).getDrug();
      }

      if (PackagingSection.PROPERTY_CLICKS.equalsIgnoreCase(attribute))
      {
         return ((PackagingSection) target).getClicks();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {

      if (PackagingSection.PROPERTY_TEXT.equalsIgnoreCase(attrName))
      {
         ((PackagingSection) target).setText((String) value);
         return true;
      }

      if (PackagingSection.PROPERTY_TOPIC.equalsIgnoreCase(attrName))
      {
         ((PackagingSection) target).setTopic((PackagingTopic) value);
         return true;
      }

      if (PackagingSection.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((PackagingSection) target).setId(Integer.parseInt(value.toString()));
         return true;
      }

      if (PackagingSection.PROPERTY_ISTAILORED.equalsIgnoreCase(attrName))
      {
         ((PackagingSection) target).setIsTailored((boolean) value);
         return true;
      }

      if (SendableEntityCreatorNoIndex.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (PackagingSection.PROPERTY_DRUG.equalsIgnoreCase(attrName))
      {
         ((PackagingSection) target).setDrug((Drug) value);
         return true;
      }

      if (PackagingSection.PROPERTY_CLICKS.equalsIgnoreCase(attrName))
      {
         ((PackagingSection) target).withClicks((ItemInvocation) value);
         return true;
      }
      
      if ((PackagingSection.PROPERTY_CLICKS + SendableEntityCreatorNoIndex.REMOVE).equalsIgnoreCase(attrName))
      {
         ((PackagingSection) target).withoutClicks((ItemInvocation) value);
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
      ((PackagingSection) entity).removeYou();
   }
}
