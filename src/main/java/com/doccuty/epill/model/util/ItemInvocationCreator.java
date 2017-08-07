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

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.iteminvocation.ItemInvocation;
import com.doccuty.epill.packagingsection.PackagingSection;

import de.uniks.networkparser.IdMap;

import java.util.Date;

import com.doccuty.epill.user.User;

public class ItemInvocationCreator implements SendableEntityCreatorNoIndex
{
   private final String[] properties = new String[]
   {
      ItemInvocation.PROPERTY_ID,
      ItemInvocation.PROPERTY_TIMESTAMP,
      ItemInvocation.PROPERTY_DRUG,
      ItemInvocation.PROPERTY_PACKAGINGSECTION,
      ItemInvocation.PROPERTY_USER,
      ItemInvocation.PROPERTY_COUNTER
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new ItemInvocation();
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

      if (ItemInvocation.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((ItemInvocation) target).getId();
      }

      if (ItemInvocation.PROPERTY_TIMESTAMP.equalsIgnoreCase(attribute))
      {
         return ((ItemInvocation) target).getTimestamp();
      }

      if (ItemInvocation.PROPERTY_DRUG.equalsIgnoreCase(attribute))
      {
         return ((ItemInvocation) target).getDrug();
      }

      if (ItemInvocation.PROPERTY_PACKAGINGSECTION.equalsIgnoreCase(attribute))
      {
         return ((ItemInvocation) target).getPackagingSection();
      }

      if (ItemInvocation.PROPERTY_USER.equalsIgnoreCase(attribute))
      {
         return ((ItemInvocation) target).getUser();
      }
      
      if(ItemInvocation.PROPERTY_COUNTER.equalsIgnoreCase(attribute)) {
    	  	return ((ItemInvocation) target).getCounter();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (ItemInvocation.PROPERTY_TIMESTAMP.equalsIgnoreCase(attrName))
      {
         ((ItemInvocation) target).setTimestamp((Date) value);
         return true;
      }

      if (ItemInvocation.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((ItemInvocation) target).setId(Long.parseLong(value.toString()));
         return true;
      }

      if (SendableEntityCreatorNoIndex.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (ItemInvocation.PROPERTY_DRUG.equalsIgnoreCase(attrName))
      {
         ((ItemInvocation) target).setDrug((Drug) value);
         return true;
      }

      if (ItemInvocation.PROPERTY_PACKAGINGSECTION.equalsIgnoreCase(attrName))
      {
         ((ItemInvocation) target).setPackagingSection((PackagingSection) value);
         return true;
      }

      if (ItemInvocation.PROPERTY_USER.equalsIgnoreCase(attrName))
      {
         ((ItemInvocation) target).setUser((User) value);
         return true;
      }
      
      if(ItemInvocation.PROPERTY_COUNTER.equalsIgnoreCase(attrName)) {
        ((ItemInvocation) target).setCounter((Integer) value);
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
      ((ItemInvocation) entity).removeYou();
   }
}
