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

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.iteminvocation.ItemInvocation;

import java.util.Collection;
import java.util.Date;

import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import com.doccuty.epill.model.util.DrugSet;
import com.doccuty.epill.model.util.PackagingSectionSet;
import com.doccuty.epill.model.util.UserSet;
import com.doccuty.epill.packagingsection.PackagingSection;
import com.doccuty.epill.user.User;

public class ItemInvocationSet extends HashSet<ItemInvocation>
{
	protected Class<?> getTypClass() {
		return ItemInvocation.class;
	}

   public ItemInvocationSet()
   {
      // empty
   }

   public ItemInvocationSet(ItemInvocation... objects)
   {
      for (ItemInvocation obj : objects)
      {
         this.add(obj);
      }
   }

   public ItemInvocationSet(Collection<ItemInvocation> objects)
   {
      this.addAll(objects);
   }

   public static final ItemInvocationSet EMPTY_SET = new ItemInvocationSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.ItemInvocation";
   }


   @SuppressWarnings("unchecked")
   public ItemInvocationSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<ItemInvocation>)value);
      }
      else if (value != null)
      {
         this.add((ItemInvocation) value);
      }
      
      return this;
   }
   
   public ItemInvocationSet without(ItemInvocation value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of ItemInvocation objects and collect a list of the id attribute values. 
    * 
    * @return List of double objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (ItemInvocation obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ItemInvocation objects and collect those ItemInvocation objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ItemInvocation objects that match the parameter
    */
   public ItemInvocationSet filterId(double value)
   {
      ItemInvocationSet result = new ItemInvocationSet();
      
      for (ItemInvocation obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ItemInvocation objects and collect those ItemInvocation objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ItemInvocation objects that match the parameter
    */
   public ItemInvocationSet filterId(double lower, double upper)
   {
      ItemInvocationSet result = new ItemInvocationSet();
      
      for (ItemInvocation obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ItemInvocation objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ItemInvocation objects now with new attribute values.
    */
   public ItemInvocationSet withId(long value)
   {
      for (ItemInvocation obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of ItemInvocation objects and collect a list of the timestamp attribute values. 
    * 
    * @return List of java.util.Date objects reachable via timestamp attribute
    */
   public ObjectSet getTimestamp()
   {
      ObjectSet result = new ObjectSet();
      
      for (ItemInvocation obj : this)
      {
         result.add(obj.getTimestamp());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ItemInvocation objects and collect those ItemInvocation objects where the timestamp attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ItemInvocation objects that match the parameter
    */
   public ItemInvocationSet filterTimestamp(Date value)
   {
      ItemInvocationSet result = new ItemInvocationSet();
      
      for (ItemInvocation obj : this)
      {
         if (value == obj.getTimestamp())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ItemInvocation objects and assign value to the timestamp attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ItemInvocation objects now with new attribute values.
    */
   public ItemInvocationSet withTimestamp(Date value)
   {
      for (ItemInvocation obj : this)
      {
         obj.setTimestamp(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ItemInvocation objects and collect a set of the Drug objects reached via drug. 
    * 
    * @return Set of Drug objects reachable via drug
    */
   public DrugSet getDrug()
   {
      DrugSet result = new DrugSet();
      
      for (ItemInvocation obj : this)
      {
         result.with(obj.getDrug());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ItemInvocation objects and collect all contained objects with reference drug pointing to the object passed as parameter. 
    * 
    * @param value The object required as drug neighbor of the collected results. 
    * 
    * @return Set of Drug objects referring to value via drug
    */
   public ItemInvocationSet filterDrug(Object value)
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
      
      ItemInvocationSet answer = new ItemInvocationSet();
      
      for (ItemInvocation obj : this)
      {
         if (neighbors.contains(obj.getDrug()) || (neighbors.isEmpty() && obj.getDrug() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ItemInvocation object passed as parameter to the Drug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Drug attributes.
    */
   public ItemInvocationSet withDrug(Drug value)
   {
      for (ItemInvocation obj : this)
      {
         obj.withDrug(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ItemInvocation objects and collect a set of the PackagingSection objects reached via packagingSection. 
    * 
    * @return Set of PackagingSection objects reachable via packagingSection
    */
   public PackagingSectionSet getPackagingSection()
   {
      PackagingSectionSet result = new PackagingSectionSet();
      
      for (ItemInvocation obj : this)
      {
         result.with(obj.getPackagingSection());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ItemInvocation objects and collect all contained objects with reference packagingSection pointing to the object passed as parameter. 
    * 
    * @param value The object required as packagingSection neighbor of the collected results. 
    * 
    * @return Set of PackagingSection objects referring to value via packagingSection
    */
   public ItemInvocationSet filterPackagingSection(Object value)
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
      
      ItemInvocationSet answer = new ItemInvocationSet();
      
      for (ItemInvocation obj : this)
      {
         if (neighbors.contains(obj.getPackagingSection()) || (neighbors.isEmpty() && obj.getPackagingSection() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ItemInvocation object passed as parameter to the PackagingSection attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their PackagingSection attributes.
    */
   public ItemInvocationSet withPackagingSection(PackagingSection value)
   {
      for (ItemInvocation obj : this)
      {
         obj.withPackagingSection(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ItemInvocation objects and collect a set of the User objects reached via user. 
    * 
    * @return Set of User objects reachable via user
    */
   public UserSet getUser()
   {
      UserSet result = new UserSet();
      
      for (ItemInvocation obj : this)
      {
         result.with(obj.getUser());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ItemInvocation objects and collect all contained objects with reference user pointing to the object passed as parameter. 
    * 
    * @param value The object required as user neighbor of the collected results. 
    * 
    * @return Set of User objects referring to value via user
    */
   public ItemInvocationSet filterUser(Object value)
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
      
      ItemInvocationSet answer = new ItemInvocationSet();
      
      for (ItemInvocation obj : this)
      {
         if (neighbors.contains(obj.getUser()) || (neighbors.isEmpty() && obj.getUser() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ItemInvocation object passed as parameter to the User attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their User attributes.
    */
   public ItemInvocationSet withUser(User value)
   {
      for (ItemInvocation obj : this)
      {
         obj.withUser(value);
      }
      
      return this;
   }

}
