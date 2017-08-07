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

import com.doccuty.epill.model.Question;
import de.uniks.networkparser.IdMap;

public class QuestionCreator implements SendableEntityCreator
{
   private final String[] properties = new String[]
   {
	  Question.PROPERTY_ID,
	  Question.PROPERTY_QUESTION,
	  Question.PROPERTY_ADDRESS
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Question();
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

      if (Question.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((Question) target).getId();
      }

      if (Question.PROPERTY_QUESTION.equalsIgnoreCase(attribute))
      {
         return ((Question) target).getQuestion();
      }

      if (Question.PROPERTY_ADDRESS.equalsIgnoreCase(attribute))
      {
         return ((Question) target).getAddress();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (Question.PROPERTY_QUESTION.equalsIgnoreCase(attrName))
      {
         ((Question) target).setQuestion((String) value);
         return true;
      }

      if (Question.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((Question) target).setId(Integer.parseInt(value.toString()));
         return true;
      }
      
      if (Question.PROPERTY_ADDRESS.equalsIgnoreCase(attrName))
      {
         ((Question) target).setAddress((String) value);
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
      ((Question) entity).removeYou();
   }
}
