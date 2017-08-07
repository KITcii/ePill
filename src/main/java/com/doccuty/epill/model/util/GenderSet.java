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
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;

import com.doccuty.epill.gender.Gender;
import com.doccuty.epill.model.util.UserSet;
import com.doccuty.epill.user.User;

public class GenderSet extends HashSet<Gender>
{
	protected Class<?> getTypClass() {
		return Gender.class;
	}

   public GenderSet()
   {
      // empty
   }

   public GenderSet(Gender... objects)
   {
      for (Gender obj : objects)
      {
         this.add(obj);
      }
   }

   public GenderSet(Collection<Gender> objects)
   {
      this.addAll(objects);
   }

   public static final GenderSet EMPTY_SET = new GenderSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.Gender";
   }


   @SuppressWarnings("unchecked")
   public GenderSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Gender>)value);
      }
      else if (value != null)
      {
         this.add((Gender) value);
      }
      
      return this;
   }
   
   public GenderSet without(Gender value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of Gender objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (Gender obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Gender objects and collect those Gender objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Gender objects that match the parameter
    */
   public GenderSet filterId(int value)
   {
      GenderSet result = new GenderSet();
      
      for (Gender obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Gender objects and collect those Gender objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Gender objects that match the parameter
    */
   public GenderSet filterId(int lower, int upper)
   {
      GenderSet result = new GenderSet();
      
      for (Gender obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Gender objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Gender objects now with new attribute values.
    */
   public GenderSet withId(int value)
   {
      for (Gender obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of Gender objects and collect a list of the gender attribute values. 
    * 
    * @return List of String objects reachable via gender attribute
    */
   public ObjectSet getGender()
   {
      ObjectSet result = new ObjectSet();
      
      for (Gender obj : this)
      {
         result.add(obj.getGender());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Gender objects and collect those Gender objects where the gender attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Gender objects that match the parameter
    */
   public GenderSet filterGender(String value)
   {
      GenderSet result = new GenderSet();
      
      for (Gender obj : this)
      {
         if (value.equals(obj.getGender()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Gender objects and collect those Gender objects where the gender attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Gender objects that match the parameter
    */
   public GenderSet filterGender(String lower, String upper)
   {
      GenderSet result = new GenderSet();
      
      for (Gender obj : this)
      {
         if (lower.compareTo(obj.getGender()) <= 0 && obj.getGender().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Gender objects and assign value to the gender attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Gender objects now with new attribute values.
    */
   public GenderSet withGender(String value)
   {
      for (Gender obj : this)
      {
         obj.setGender(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Gender objects and collect a set of the User objects reached via user. 
    * 
    * @return Set of User objects reachable via user
    */
   public UserSet getUser()
   {
      UserSet result = new UserSet();
      
      for (Gender obj : this)
      {
         result.with(obj.getUser());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Gender objects and collect all contained objects with reference user pointing to the object passed as parameter. 
    * 
    * @param value The object required as user neighbor of the collected results. 
    * 
    * @return Set of User objects referring to value via user
    */
   public GenderSet filterUser(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      GenderSet answer = new GenderSet();
      
      for (Gender obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getUser()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Gender object passed as parameter to the User attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their User attributes.
    */
   public GenderSet withUser(User value)
   {
      for (Gender obj : this)
      {
         obj.withUser(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Gender object passed as parameter from the User attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public GenderSet withoutUser(User value)
   {
      for (Gender obj : this)
      {
         obj.withoutUser(value);
      }
      
      return this;
   }

}
