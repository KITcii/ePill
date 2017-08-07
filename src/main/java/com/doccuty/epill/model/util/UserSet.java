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
import java.util.Date;

import com.doccuty.epill.model.util.PackagingTopicSet;
import com.doccuty.epill.model.PackagingTopic;
import com.doccuty.epill.model.util.CountrySet;
import com.doccuty.epill.disease.Disease;
import com.doccuty.epill.gender.Gender;
import com.doccuty.epill.iteminvocation.ItemInvocation;
import com.doccuty.epill.language.Language;
import com.doccuty.epill.model.Country;
import com.doccuty.epill.model.util.LanguageSet;
import com.doccuty.epill.model.util.GenderSet;
import com.doccuty.epill.model.util.ItemInvocationSet;
import com.doccuty.epill.model.util.UserQuerySet;
import com.doccuty.epill.user.User;
import com.doccuty.epill.model.UserQuery;
import com.doccuty.epill.model.util.DiseaseSet;

public class UserSet extends HashSet<User>
{
	protected Class<?> getTypClass() {
		return User.class;
	}

   public UserSet()
   {
      // empty
   }

   public UserSet(User... objects)
   {
      for (User obj : objects)
      {
         this.add(obj);
      }
   }

   public UserSet(Collection<User> objects)
   {
      this.addAll(objects);
   }

   public static final UserSet EMPTY_SET = new UserSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.User";
   }


   @SuppressWarnings("unchecked")
   public UserSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<User>)value);
      }
      else if (value != null)
      {
         this.add((User) value);
      }
      
      return this;
   }
   
   public UserSet without(User value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of User objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (User obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterId(long value)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterId(int lower, int upper)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of User objects now with new attribute values.
    */
   public UserSet withId(int value)
   {
      for (User obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of User objects and collect a list of the firstname attribute values. 
    * 
    * @return List of String objects reachable via firstname attribute
    */
   public ObjectSet getFirstname()
   {
      ObjectSet result = new ObjectSet();
      
      for (User obj : this)
      {
         result.add(obj.getFirstname());
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the firstname attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterFirstname(String value)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (value.equals(obj.getFirstname()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the firstname attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterFirstname(String lower, String upper)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (lower.compareTo(obj.getFirstname()) <= 0 && obj.getFirstname().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and assign value to the firstname attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of User objects now with new attribute values.
    */
   public UserSet withFirstname(String value)
   {
      for (User obj : this)
      {
         obj.setFirstname(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of User objects and collect a list of the lastname attribute values. 
    * 
    * @return List of String objects reachable via lastname attribute
    */
   public ObjectSet getLastname()
   {
      ObjectSet result = new ObjectSet();
      
      for (User obj : this)
      {
         result.add(obj.getLastname());
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the lastname attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterLastname(String value)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (value.equals(obj.getLastname()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the lastname attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterLastname(String lower, String upper)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (lower.compareTo(obj.getLastname()) <= 0 && obj.getLastname().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and assign value to the lastname attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of User objects now with new attribute values.
    */
   public UserSet withLastname(String value)
   {
      for (User obj : this)
      {
         obj.setLastname(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of User objects and collect a list of the username attribute values. 
    * 
    * @return List of String objects reachable via username attribute
    */
   public ObjectSet getUsername()
   {
      ObjectSet result = new ObjectSet();
      
      for (User obj : this)
      {
         result.add(obj.getUsername());
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the username attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterUsername(String value)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (value.equals(obj.getUsername()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the username attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterUsername(String lower, String upper)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (lower.compareTo(obj.getUsername()) <= 0 && obj.getUsername().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and assign value to the username attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of User objects now with new attribute values.
    */
   public UserSet withUsername(String value)
   {
      for (User obj : this)
      {
         obj.setUsername(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of User objects and collect a list of the password attribute values. 
    * 
    * @return List of String objects reachable via password attribute
    */
   public ObjectSet getPassword()
   {
      ObjectSet result = new ObjectSet();
      
      for (User obj : this)
      {
         result.add(obj.getPassword());
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the password attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterPassword(String value)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (value.equals(obj.getPassword()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the password attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterPassword(String lower, String upper)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (lower.compareTo(obj.getPassword()) <= 0 && obj.getPassword().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and assign value to the password attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of User objects now with new attribute values.
    */
   public UserSet withPassword(String value)
   {
      for (User obj : this)
      {
         obj.setPassword(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of User objects and collect a list of the salt attribute values. 
    * 
    * @return List of String objects reachable via salt attribute
    */
   public ObjectSet getSalt()
   {
      ObjectSet result = new ObjectSet();
      
      for (User obj : this)
      {
         result.add(obj.getSalt());
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the salt attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterSalt(String value)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (value.equals(obj.getSalt()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the salt attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterSalt(String lower, String upper)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (lower.compareTo(obj.getSalt()) <= 0 && obj.getSalt().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and assign value to the salt attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of User objects now with new attribute values.
    */
   public UserSet withSalt(String value)
   {
      for (User obj : this)
      {
         obj.setSalt(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of User objects and collect a list of the email attribute values. 
    * 
    * @return List of String objects reachable via email attribute
    */
   public ObjectSet getEmail()
   {
      ObjectSet result = new ObjectSet();
      
      for (User obj : this)
      {
         result.add(obj.getEmail());
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the email attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterEmail(String value)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (value.equals(obj.getEmail()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the email attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterEmail(String lower, String upper)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (lower.compareTo(obj.getEmail()) <= 0 && obj.getEmail().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and assign value to the email attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of User objects now with new attribute values.
    */
   public UserSet withEmail(String value)
   {
      for (User obj : this)
      {
         obj.setEmail(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of User objects and collect a list of the dateOfBirth attribute values. 
    * 
    * @return List of java.util.Date objects reachable via dateOfBirth attribute
    */
   public ObjectSet getDateOfBirth()
   {
      ObjectSet result = new ObjectSet();
      
      for (User obj : this)
      {
         result.add(obj.getDateOfBirth());
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the dateOfBirth attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterDateOfBirth(Date value)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (value == obj.getDateOfBirth())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and assign value to the dateOfBirth attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of User objects now with new attribute values.
    */
   public UserSet withDateOfBirth(Date value)
   {
      for (User obj : this)
      {
         obj.setDateOfBirth(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of User objects and collect a list of the preferredFontSize attribute values. 
    * 
    * @return List of int objects reachable via preferredFontSize attribute
    */
   public NumberList getPreferredFontSize()
   {
      NumberList result = new NumberList();
      
      for (User obj : this)
      {
         result.add(obj.getPreferredFontSize());
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the preferredFontSize attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterPreferredFontSize(String value)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (value == obj.getPreferredFontSize())
         {
            result.add(obj);
         }
      }
      
      return result;
   }




   /**
    * Loop through the current set of User objects and assign value to the preferredFontSize attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of User objects now with new attribute values.
    */
   public UserSet withPreferredFontSize(String value)
   {
      for (User obj : this)
      {
         obj.setPreferredFontSize(value);
      }
      
      return this;
   }



   /**
    * Loop through the current set of User objects and collect a list of the dateOfBirth attribute values. 
    * 
    * @return List of java.util.Date objects reachable via dateOfBirth attribute
    */
   public ObjectSet getDateOfRegistration()
   {
      ObjectSet result = new ObjectSet();
      
      for (User obj : this)
      {
         result.add(obj.getDateOfRegistration());
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and collect those User objects where the dateOfRegistration attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of User objects that match the parameter
    */
   public UserSet filterDateOfRegistration(Date value)
   {
      UserSet result = new UserSet();
      
      for (User obj : this)
      {
         if (value == obj.getDateOfRegistration())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of User objects and assign value to the dateOfRegistration attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of User objects now with new attribute values.
    */
   public UserSet withDateOfRegistration(Date value)
   {
      for (User obj : this)
      {
         obj.setDateOfRegistration(value);
      }
      
      return this;
   }


   
   /**
    * Loop through the current set of User objects and collect a set of the PackagingTopic objects reached via preferredPackagingTopic. 
    * 
    * @return Set of PackagingTopic objects reachable via preferredPackagingTopic
    */
   public PackagingTopicSet getPreferredPackagingTopic()
   {
      PackagingTopicSet result = new PackagingTopicSet();
      
      for (User obj : this)
      {
         result.with(obj.getPreferredPackagingTopic());
      }
      
      return result;
   }

   /**
    * Loop through the current set of User objects and collect all contained objects with reference preferredPackagingTopic pointing to the object passed as parameter. 
    * 
    * @param value The object required as preferredPackagingTopic neighbor of the collected results. 
    * 
    * @return Set of PackagingTopic objects referring to value via preferredPackagingTopic
    */
   public UserSet filterPreferredPackagingTopic(Object value)
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
      
      UserSet answer = new UserSet();
      
      for (User obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getPreferredPackagingTopic()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the User object passed as parameter to the PreferredPackagingTopic attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their PreferredPackagingTopic attributes.
    */
   public UserSet withPreferredPackagingTopic(PackagingTopic value)
   {
      for (User obj : this)
      {
         obj.withPreferredPackagingTopic(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the User object passed as parameter from the PreferredPackagingTopic attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public UserSet withoutPreferredPackagingTopic(PackagingTopic value)
   {
      for (User obj : this)
      {
         obj.withoutPreferredPackagingTopic(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of User objects and collect a set of the Country objects reached via country. 
    * 
    * @return Set of Country objects reachable via country
    */
   public CountrySet getCountry()
   {
      CountrySet result = new CountrySet();
      
      for (User obj : this)
      {
         result.with(obj.getCountry());
      }
      
      return result;
   }

   /**
    * Loop through the current set of User objects and collect all contained objects with reference country pointing to the object passed as parameter. 
    * 
    * @param value The object required as country neighbor of the collected results. 
    * 
    * @return Set of Country objects referring to value via country
    */
   public UserSet filterCountry(Object value)
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
      
      UserSet answer = new UserSet();
      
      for (User obj : this)
      {
         if (neighbors.contains(obj.getCountry()) || (neighbors.isEmpty() && obj.getCountry() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the User object passed as parameter to the Country attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Country attributes.
    */
   public UserSet withCountry(Country value)
   {
      for (User obj : this)
      {
         obj.withCountry(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of User objects and collect a set of the Language objects reached via language. 
    * 
    * @return Set of Language objects reachable via language
    */
   public LanguageSet getLanguage()
   {
      LanguageSet result = new LanguageSet();
      
      for (User obj : this)
      {
         result.with(obj.getLanguage());
      }
      
      return result;
   }

   /**
    * Loop through the current set of User objects and collect all contained objects with reference language pointing to the object passed as parameter. 
    * 
    * @param value The object required as language neighbor of the collected results. 
    * 
    * @return Set of Language objects referring to value via language
    */
   public UserSet filterLanguage(Object value)
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
      
      UserSet answer = new UserSet();
      
      for (User obj : this)
      {
         if (neighbors.contains(obj.getLanguage()) || (neighbors.isEmpty() && obj.getLanguage() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the User object passed as parameter to the Language attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Language attributes.
    */
   public UserSet withLanguage(Language value)
   {
      for (User obj : this)
      {
         obj.withLanguage(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of User objects and collect a set of the Gender objects reached via gender. 
    * 
    * @return Set of Gender objects reachable via gender
    */
   public GenderSet getGender()
   {
      GenderSet result = new GenderSet();
      
      for (User obj : this)
      {
         result.with(obj.getGender());
      }
      
      return result;
   }

   /**
    * Loop through the current set of User objects and collect all contained objects with reference gender pointing to the object passed as parameter. 
    * 
    * @param value The object required as gender neighbor of the collected results. 
    * 
    * @return Set of Gender objects referring to value via gender
    */
   public UserSet filterGender(Object value)
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
      
      UserSet answer = new UserSet();
      
      for (User obj : this)
      {
         if (neighbors.contains(obj.getGender()) || (neighbors.isEmpty() && obj.getGender() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the User object passed as parameter to the Gender attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Gender attributes.
    */
   public UserSet withGender(Gender value)
   {
      for (User obj : this)
      {
         obj.withGender(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of User objects and collect a set of the ItemInvocation objects reached via clicks. 
    * 
    * @return Set of ItemInvocation objects reachable via clicks
    */
   public ItemInvocationSet getClicks()
   {
      ItemInvocationSet result = new ItemInvocationSet();
      
      for (User obj : this)
      {
         result.with(obj.getClicks());
      }
      
      return result;
   }

   /**
    * Loop through the current set of User objects and collect all contained objects with reference clicks pointing to the object passed as parameter. 
    * 
    * @param value The object required as clicks neighbor of the collected results. 
    * 
    * @return Set of ItemInvocation objects referring to value via clicks
    */
   public UserSet filterClicks(Object value)
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
      
      UserSet answer = new UserSet();
      
      for (User obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getClicks()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the User object passed as parameter to the Clicks attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Clicks attributes.
    */
   public UserSet withClicks(ItemInvocation value)
   {
      for (User obj : this)
      {
         obj.withClicks(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the User object passed as parameter from the Clicks attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public UserSet withoutClicks(ItemInvocation value)
   {
      for (User obj : this)
      {
         obj.withoutClicks(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of User objects and collect a set of the UserQuery objects reached via query. 
    * 
    * @return Set of UserQuery objects reachable via query
    */
   public UserQuerySet getQuery()
   {
      UserQuerySet result = new UserQuerySet();
      
      for (User obj : this)
      {
         result.with(obj.getQuery());
      }
      
      return result;
   }

   /**
    * Loop through the current set of User objects and collect all contained objects with reference query pointing to the object passed as parameter. 
    * 
    * @param value The object required as query neighbor of the collected results. 
    * 
    * @return Set of UserQuery objects referring to value via query
    */
   public UserSet filterQuery(Object value)
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
      
      UserSet answer = new UserSet();
      
      for (User obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getQuery()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the User object passed as parameter to the Query attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Query attributes.
    */
   public UserSet withQuery(UserQuery value)
   {
      for (User obj : this)
      {
         obj.withQuery(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the User object passed as parameter from the Query attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public UserSet withoutQuery(UserQuery value)
   {
      for (User obj : this)
      {
         obj.withoutQuery(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of User objects and collect a set of the Disease objects reached via disease. 
    * 
    * @return Set of Disease objects reachable via disease
    */
   public DiseaseSet getDisease()
   {
      DiseaseSet result = new DiseaseSet();
      
      for (User obj : this)
      {
         result.with(obj.getDisease());
      }
      
      return result;
   }

   /**
    * Loop through the current set of User objects and collect all contained objects with reference disease pointing to the object passed as parameter. 
    * 
    * @param value The object required as disease neighbor of the collected results. 
    * 
    * @return Set of Disease objects referring to value via disease
    */
   public UserSet filterDisease(Object value)
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
      
      UserSet answer = new UserSet();
      
      for (User obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getDisease()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the User object passed as parameter to the Disease attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Disease attributes.
    */
   public UserSet withDisease(Disease value)
   {
      for (User obj : this)
      {
         obj.withDisease(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the User object passed as parameter from the Disease attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public UserSet withoutDisease(Disease value)
   {
      for (User obj : this)
      {
         obj.withoutDisease(value);
      }
      
      return this;
   }

}
