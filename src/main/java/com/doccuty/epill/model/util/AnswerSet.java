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

import java.util.HashSet;
import com.doccuty.epill.model.Answer;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import com.doccuty.epill.model.Question;

public class AnswerSet extends HashSet<Answer>
{
	protected Class<?> getTypClass() {
		return Answer.class;
	}

   public AnswerSet()
   {
      // empty
   }

   public AnswerSet(Answer... objects)
   {
      for (Answer obj : objects)
      {
         this.add(obj);
      }
   }

   public AnswerSet(Collection<Answer> objects)
   {
      this.addAll(objects);
   }

   public static final AnswerSet EMPTY_SET = new AnswerSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.Answer";
   }


   @SuppressWarnings("unchecked")
   public AnswerSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Answer>)value);
      }
      else if (value != null)
      {
         this.add((Answer) value);
      }
      
      return this;
   }
   
   public AnswerSet without(Answer value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of Answer objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (Answer obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Answer objects and collect those Answer objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Answer objects that match the parameter
    */
   public AnswerSet filterId(int value)
   {
      AnswerSet result = new AnswerSet();
      
      for (Answer obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Answer objects and collect those Answer objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Answer objects that match the parameter
    */
   public AnswerSet filterId(int lower, int upper)
   {
      AnswerSet result = new AnswerSet();
      
      for (Answer obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Answer objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Answer objects now with new attribute values.
    */
   public AnswerSet withId(int value)
   {
      for (Answer obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of Answer objects and collect a list of the country attribute values. 
    * 
    * @return List of String objects reachable via country attribute
    */
   public ObjectSet getAnswer()
   {
      ObjectSet result = new ObjectSet();
      
      for (Answer obj : this)
      {
         result.add(obj.getAnswer());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Answer objects and collect those Answer objects where the country attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Answer objects that match the parameter
    */
   public AnswerSet filterAnswer(String value)
   {
      AnswerSet result = new AnswerSet();
      
      for (Answer obj : this)
      {
         if (value.equals(obj.getAnswer()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Answer objects and collect those Answer objects where the country attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Answer objects that match the parameter
    */
   public AnswerSet filterAnswer(int lower, int upper)
   {
      AnswerSet result = new AnswerSet();
      
      for (Answer obj : this)
      {
         if (lower <= obj.getAnswer() && obj.getAnswer() >= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Answer objects and assign value to the country attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Answer objects now with new attribute values.
    */
   public AnswerSet withAnswer(int value)
   {
      for (Answer obj : this)
      {
         obj.setAnswer(value);
      }
      
      return this;
   }


   /**
    * Loop through current set of ModelType objects and attach the Answer object passed as parameter to the Question attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Question attributes.
    */
   public AnswerSet withQuestion(Question value)
   {
      for (Answer obj : this)
      {
         obj.withQuestion(value);
      }
      
      return this;
   }

}
