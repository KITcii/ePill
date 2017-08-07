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
import com.doccuty.epill.model.DrugFeature;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import com.doccuty.epill.model.util.DrugSet;

public class DrugFeatureSet extends HashSet<DrugFeature>
{
	protected Class<?> getTypClass() {
		return DrugFeature.class;
	}

   public DrugFeatureSet()
   {
      // empty
   }

   public DrugFeatureSet(DrugFeature... objects)
   {
      for (DrugFeature obj : objects)
      {
         this.add(obj);
      }
   }

   public DrugFeatureSet(Collection<DrugFeature> objects)
   {
      this.addAll(objects);
   }

   public static final DrugFeatureSet EMPTY_SET = new DrugFeatureSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.DrugFeature";
   }


   @SuppressWarnings("unchecked")
   public DrugFeatureSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<DrugFeature>)value);
      }
      else if (value != null)
      {
         this.add((DrugFeature) value);
      }
      
      return this;
   }
   
   public DrugFeatureSet without(DrugFeature value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of DrugFeature objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (DrugFeature obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of DrugFeature objects and collect those DrugFeature objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of DrugFeature objects that match the parameter
    */
   public DrugFeatureSet filterId(int value)
   {
      DrugFeatureSet result = new DrugFeatureSet();
      
      for (DrugFeature obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of DrugFeature objects and collect those DrugFeature objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of DrugFeature objects that match the parameter
    */
   public DrugFeatureSet filterId(int lower, int upper)
   {
      DrugFeatureSet result = new DrugFeatureSet();
      
      for (DrugFeature obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of DrugFeature objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of DrugFeature objects now with new attribute values.
    */
   public DrugFeatureSet withId(int value)
   {
      for (DrugFeature obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of DrugFeature objects and collect a list of the country attribute values. 
    * 
    * @return List of String objects reachable via country attribute
    */
   public ObjectSet getDrugFeature()
   {
      ObjectSet result = new ObjectSet();
      
      for (DrugFeature obj : this)
      {
         result.add(obj.getDrugFeature());
      }
      
      return result;
   }


   /**
    * Loop through the current set of DrugFeature objects and collect those DrugFeature objects where the country attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of DrugFeature objects that match the parameter
    */
   public DrugFeatureSet filterDrugFeature(String value)
   {
      DrugFeatureSet result = new DrugFeatureSet();
      
      for (DrugFeature obj : this)
      {
         if (value.equals(obj.getDrugFeature()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of DrugFeature objects and collect those DrugFeature objects where the country attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of DrugFeature objects that match the parameter
    */
   public DrugFeatureSet filterDrugFeature(String lower, String upper)
   {
      DrugFeatureSet result = new DrugFeatureSet();
      
      for (DrugFeature obj : this)
      {
         if (lower.compareTo(obj.getDrugFeature()) <= 0 && obj.getDrugFeature().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of DrugFeature objects and assign value to the country attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of DrugFeature objects now with new attribute values.
    */
   public DrugFeatureSet withDrugFeature(String value)
   {
      for (DrugFeature obj : this)
      {
         obj.setDrugFeature(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of DrugFeature objects and collect a set of the Drug objects reached via user. 
    * 
    * @return Set of Drug objects reachable via user
    */
   public DrugSet getDrug()
   {
      DrugSet result = new DrugSet();
      
      for (DrugFeature obj : this)
      {
         result.with(obj.getDrug());
      }
      
      return result;
   }

   /**
    * Loop through the current set of DrugFeature objects and collect all contained objects with reference user pointing to the object passed as parameter. 
    * 
    * @param value The object required as user neighbor of the collected results. 
    * 
    * @return Set of Drug objects referring to value via user
    */
   public DrugFeatureSet filterDrug(Object value)
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
      
      DrugFeatureSet answer = new DrugFeatureSet();
      
      for (DrugFeature obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getDrug()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the DrugFeature object passed as parameter to the Drug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Drug attributes.
    */
   public DrugFeatureSet withDrug(Drug value)
   {
      for (DrugFeature obj : this)
      {
         obj.withDrug(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the DrugFeature object passed as parameter from the Drug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public DrugFeatureSet withoutDrug(Drug value)
   {
      for (DrugFeature obj : this)
      {
         obj.withoutDrug(value);
      }
      
      return this;
   }

}
