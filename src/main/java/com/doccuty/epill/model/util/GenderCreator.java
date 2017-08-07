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

import com.doccuty.epill.gender.Gender;
import com.doccuty.epill.user.User;

import de.uniks.networkparser.IdMap;

public class GenderCreator implements SendableEntityCreatorNoIndex
{
   private final String[] properties = new String[]
   {
      Gender.PROPERTY_ID,
      Gender.PROPERTY_GENDER
      //Gender.PROPERTY_USER
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Gender();
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

      if (Gender.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((Gender) target).getId();
      }

      if (Gender.PROPERTY_GENDER.equalsIgnoreCase(attribute))
      {
         return ((Gender) target).getGender();
      }

      if (Gender.PROPERTY_USER.equalsIgnoreCase(attribute))
      {
         return ((Gender) target).getUser();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (Gender.PROPERTY_GENDER.equalsIgnoreCase(attrName))
      {
         ((Gender) target).setGender((String) value);
         return true;
      }

      if (Gender.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((Gender) target).setId(Integer.parseInt(value.toString()));
         return true;
      }

      if (SendableEntityCreatorNoIndex.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (Gender.PROPERTY_USER.equalsIgnoreCase(attrName))
      {
         ((Gender) target).withUser((User) value);
         return true;
      }
      
      if ((Gender.PROPERTY_USER + SendableEntityCreatorNoIndex.REMOVE).equalsIgnoreCase(attrName))
      {
         ((Gender) target).withoutUser((User) value);
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
      ((Gender) entity).removeYou();
   }
}
