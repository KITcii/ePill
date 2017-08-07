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
import com.doccuty.epill.model.ActiveSubstance;

import java.awt.List;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import com.doccuty.epill.model.util.DrugSet;
import com.doccuty.epill.model.util.SubstanceGroupSet;
import com.doccuty.epill.model.SubstanceGroup;

public class ActiveSubstanceSet extends HashSet<ActiveSubstance>
{
	protected Class<?> getTypClass() {
		return ActiveSubstance.class;
	}

   public ActiveSubstanceSet()
   {
      // empty
   }

   public ActiveSubstanceSet(ActiveSubstance... objects)
   {
      for (ActiveSubstance obj : objects)
      {
         this.add(obj);
      }
   }

   public ActiveSubstanceSet(Collection<ActiveSubstance> objects)
   {
      this.addAll(objects);
   }

   public static final ActiveSubstanceSet EMPTY_SET = new ActiveSubstanceSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.ActiveSubstance";
   }


   @SuppressWarnings("unchecked")
   public ActiveSubstanceSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<ActiveSubstance>)value);
      }
      else if (value != null)
      {
         this.add((ActiveSubstance) value);
      }
      
      return this;
   }
   
   public ActiveSubstanceSet without(ActiveSubstance value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of ActiveSubstance objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (ActiveSubstance obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ActiveSubstance objects and collect those ActiveSubstance objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ActiveSubstance objects that match the parameter
    */
   public ActiveSubstanceSet filterId(int value)
   {
      ActiveSubstanceSet result = new ActiveSubstanceSet();
      
      for (ActiveSubstance obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ActiveSubstance objects and collect those ActiveSubstance objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ActiveSubstance objects that match the parameter
    */
   public ActiveSubstanceSet filterId(int lower, int upper)
   {
      ActiveSubstanceSet result = new ActiveSubstanceSet();
      
      for (ActiveSubstance obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ActiveSubstance objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ActiveSubstance objects now with new attribute values.
    */
   public ActiveSubstanceSet withId(int value)
   {
      for (ActiveSubstance obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of ActiveSubstance objects and collect a list of the name attribute values. 
    * 
    * @return List of String objects reachable via name attribute
    */
   public ObjectSet getName()
   {
      ObjectSet result = new ObjectSet();
      
      for (ActiveSubstance obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ActiveSubstance objects and collect those ActiveSubstance objects where the name attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ActiveSubstance objects that match the parameter
    */
   public ActiveSubstanceSet filterName(String value)
   {
      ActiveSubstanceSet result = new ActiveSubstanceSet();
      
      for (ActiveSubstance obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ActiveSubstance objects and collect those ActiveSubstance objects where the name attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ActiveSubstance objects that match the parameter
    */
   public ActiveSubstanceSet filterName(String lower, String upper)
   {
      ActiveSubstanceSet result = new ActiveSubstanceSet();
      
      for (ActiveSubstance obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ActiveSubstance objects and assign value to the name attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ActiveSubstance objects now with new attribute values.
    */
   public ActiveSubstanceSet withName(String value)
   {
      for (ActiveSubstance obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ActiveSubstance objects and collect a set of the Drug objects reached via drug. 
    * 
    * @return Set of Drug objects reachable via drug
    */
   public DrugSet getDrug()
   {
      DrugSet result = new DrugSet();
      
      for (ActiveSubstance obj : this)
      {
         result.with(obj.getDrug());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ActiveSubstance objects and collect all contained objects with reference drug pointing to the object passed as parameter. 
    * 
    * @param value The object required as drug neighbor of the collected results. 
    * 
    * @return Set of Drug objects referring to value via drug
    */
   public ActiveSubstanceSet filterDrug(Object value)
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
      
      ActiveSubstanceSet answer = new ActiveSubstanceSet();
      
      for (ActiveSubstance obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getDrug()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ActiveSubstance object passed as parameter to the Drug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Drug attributes.
    */
   public ActiveSubstanceSet withDrug(Drug value)
   {
      for (ActiveSubstance obj : this)
      {
         obj.withDrug(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the ActiveSubstance object passed as parameter from the Drug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public ActiveSubstanceSet withoutDrug(Drug value)
   {
      for (ActiveSubstance obj : this)
      {
         obj.withoutDrug(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ActiveSubstance objects and collect a set of the SubstanceGroup objects reached via substanceGroup. 
    * 
    * @return Set of SubstanceGroup objects reachable via substanceGroup
    */
   public SubstanceGroupSet getSubstanceGroup()
   {
      SubstanceGroupSet result = new SubstanceGroupSet();
      
      for (ActiveSubstance obj : this)
      {
         result.with(obj.getSubstanceGroup());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ActiveSubstance objects and collect all contained objects with reference substanceGroup pointing to the object passed as parameter. 
    * 
    * @param value The object required as substanceGroup neighbor of the collected results. 
    * 
    * @return Set of SubstanceGroup objects referring to value via substanceGroup
    */
   public ActiveSubstanceSet filterSubstanceGroup(Object value)
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
      
      ActiveSubstanceSet answer = new ActiveSubstanceSet();
      
      for (ActiveSubstance obj : this)
      {
         if (neighbors.contains(obj.getSubstanceGroup()) || (neighbors.isEmpty() && obj.getSubstanceGroup() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ActiveSubstance object passed as parameter to the SubstanceGroup attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their SubstanceGroup attributes.
    */
   public ActiveSubstanceSet withSubstanceGroup(SubstanceGroup value)
   {
      for (ActiveSubstance obj : this)
      {
         obj.withSubstanceGroup(value);
      }
      
      return this;
   }

}
