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
import com.doccuty.epill.model.SubstanceGroup;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import com.doccuty.epill.model.util.ActiveSubstanceSet;
import com.doccuty.epill.model.ActiveSubstance;

public class SubstanceGroupSet extends HashSet<SubstanceGroup>
{
	protected Class<?> getTypClass() {
		return SubstanceGroup.class;
	}

   public SubstanceGroupSet()
   {
      // empty
   }

   public SubstanceGroupSet(SubstanceGroup... objects)
   {
      for (SubstanceGroup obj : objects)
      {
         this.add(obj);
      }
   }

   public SubstanceGroupSet(Collection<SubstanceGroup> objects)
   {
      this.addAll(objects);
   }

   public static final SubstanceGroupSet EMPTY_SET = new SubstanceGroupSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.SubstanceGroup";
   }


   @SuppressWarnings("unchecked")
   public SubstanceGroupSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<SubstanceGroup>)value);
      }
      else if (value != null)
      {
         this.add((SubstanceGroup) value);
      }
      
      return this;
   }
   
   public SubstanceGroupSet without(SubstanceGroup value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of SubstanceGroup objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (SubstanceGroup obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of SubstanceGroup objects and collect those SubstanceGroup objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of SubstanceGroup objects that match the parameter
    */
   public SubstanceGroupSet filterId(int value)
   {
      SubstanceGroupSet result = new SubstanceGroupSet();
      
      for (SubstanceGroup obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of SubstanceGroup objects and collect those SubstanceGroup objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of SubstanceGroup objects that match the parameter
    */
   public SubstanceGroupSet filterId(int lower, int upper)
   {
      SubstanceGroupSet result = new SubstanceGroupSet();
      
      for (SubstanceGroup obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of SubstanceGroup objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of SubstanceGroup objects now with new attribute values.
    */
   public SubstanceGroupSet withId(int value)
   {
      for (SubstanceGroup obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of SubstanceGroup objects and collect a list of the name attribute values. 
    * 
    * @return List of String objects reachable via name attribute
    */
   public ObjectSet getName()
   {
      ObjectSet result = new ObjectSet();
      
      for (SubstanceGroup obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }


   /**
    * Loop through the current set of SubstanceGroup objects and collect those SubstanceGroup objects where the name attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of SubstanceGroup objects that match the parameter
    */
   public SubstanceGroupSet filterName(String value)
   {
      SubstanceGroupSet result = new SubstanceGroupSet();
      
      for (SubstanceGroup obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of SubstanceGroup objects and collect those SubstanceGroup objects where the name attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of SubstanceGroup objects that match the parameter
    */
   public SubstanceGroupSet filterName(String lower, String upper)
   {
      SubstanceGroupSet result = new SubstanceGroupSet();
      
      for (SubstanceGroup obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of SubstanceGroup objects and assign value to the name attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of SubstanceGroup objects now with new attribute values.
    */
   public SubstanceGroupSet withName(String value)
   {
      for (SubstanceGroup obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of SubstanceGroup objects and collect a set of the ActiveSubstance objects reached via substance. 
    * 
    * @return Set of ActiveSubstance objects reachable via substance
    */
   public ActiveSubstanceSet getSubstance()
   {
      ActiveSubstanceSet result = new ActiveSubstanceSet();
      
      for (SubstanceGroup obj : this)
      {
         result.with(obj.getSubstance());
      }
      
      return result;
   }

   /**
    * Loop through the current set of SubstanceGroup objects and collect all contained objects with reference substance pointing to the object passed as parameter. 
    * 
    * @param value The object required as substance neighbor of the collected results. 
    * 
    * @return Set of ActiveSubstance objects referring to value via substance
    */
   public SubstanceGroupSet filterSubstance(Object value)
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
      
      SubstanceGroupSet answer = new SubstanceGroupSet();
      
      for (SubstanceGroup obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getSubstance()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the SubstanceGroup object passed as parameter to the Substance attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Substance attributes.
    */
   public SubstanceGroupSet withSubstance(ActiveSubstance value)
   {
      for (SubstanceGroup obj : this)
      {
         obj.withSubstance(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the SubstanceGroup object passed as parameter from the Substance attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public SubstanceGroupSet withoutSubstance(ActiveSubstance value)
   {
      for (SubstanceGroup obj : this)
      {
         obj.withoutSubstance(value);
      }
      
      return this;
   }

}
