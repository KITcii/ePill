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
import com.doccuty.epill.model.util.UserSet;
import com.doccuty.epill.user.User;
import com.doccuty.epill.language.Language;

public class LanguageSet extends HashSet<Language>
{
	protected Class<?> getTypClass() {
		return Language.class;
	}

   public LanguageSet()
   {
      // empty
   }

   public LanguageSet(Language... objects)
   {
      for (Language obj : objects)
      {
         this.add(obj);
      }
   }

   public LanguageSet(Collection<Language> objects)
   {
      this.addAll(objects);
   }

   public static final LanguageSet EMPTY_SET = new LanguageSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.Language";
   }


   @SuppressWarnings("unchecked")
   public LanguageSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Language>)value);
      }
      else if (value != null)
      {
         this.add((Language) value);
      }
      
      return this;
   }
   
   public LanguageSet without(Language value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of Language objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (Language obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Language objects and collect those Language objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Language objects that match the parameter
    */
   public LanguageSet filterId(int value)
   {
      LanguageSet result = new LanguageSet();
      
      for (Language obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Language objects and collect those Language objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Language objects that match the parameter
    */
   public LanguageSet filterId(int lower, int upper)
   {
      LanguageSet result = new LanguageSet();
      
      for (Language obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Language objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Language objects now with new attribute values.
    */
   public LanguageSet withId(int value)
   {
      for (Language obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of Language objects and collect a list of the language attribute values. 
    * 
    * @return List of String objects reachable via language attribute
    */
   public ObjectSet getLanguage()
   {
      ObjectSet result = new ObjectSet();
      
      for (Language obj : this)
      {
         result.add(obj.getLanguage());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Language objects and collect those Language objects where the language attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Language objects that match the parameter
    */
   public LanguageSet filterLanguage(String value)
   {
      LanguageSet result = new LanguageSet();
      
      for (Language obj : this)
      {
         if (value.equals(obj.getLanguage()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Language objects and collect those Language objects where the language attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Language objects that match the parameter
    */
   public LanguageSet filterLanguage(String lower, String upper)
   {
      LanguageSet result = new LanguageSet();
      
      for (Language obj : this)
      {
         if (lower.compareTo(obj.getLanguage()) <= 0 && obj.getLanguage().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Language objects and assign value to the language attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Language objects now with new attribute values.
    */
   public LanguageSet withLanguage(String value)
   {
      for (Language obj : this)
      {
         obj.setLanguage(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Language objects and collect a set of the User objects reached via user. 
    * 
    * @return Set of User objects reachable via user
    */
   public UserSet getUser()
   {
      UserSet result = new UserSet();
      
      for (Language obj : this)
      {
         result.with(obj.getUser());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Language objects and collect all contained objects with reference user pointing to the object passed as parameter. 
    * 
    * @param value The object required as user neighbor of the collected results. 
    * 
    * @return Set of User objects referring to value via user
    */
   public LanguageSet filterUser(Object value)
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
      
      LanguageSet answer = new LanguageSet();
      
      for (Language obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getUser()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Language object passed as parameter to the User attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their User attributes.
    */
   public LanguageSet withUser(User value)
   {
      for (Language obj : this)
      {
         obj.withUser(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Language object passed as parameter from the User attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public LanguageSet withoutUser(User value)
   {
      for (Language obj : this)
      {
         obj.withoutUser(value);
      }
      
      return this;
   }

}
