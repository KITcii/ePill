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
import com.doccuty.epill.model.PharmaceuticalForm;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import com.doccuty.epill.model.util.DrugSet;
import com.doccuty.epill.model.util.IntakeInformationSet;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.model.IntakeInformation;

public class PharmaceuticalFormSet extends HashSet<PharmaceuticalForm>
{
	protected Class<?> getTypClass() {
		return PharmaceuticalForm.class;
	}

   public PharmaceuticalFormSet()
   {
      // empty
   }

   public PharmaceuticalFormSet(PharmaceuticalForm... objects)
   {
      for (PharmaceuticalForm obj : objects)
      {
         this.add(obj);
      }
   }

   public PharmaceuticalFormSet(Collection<PharmaceuticalForm> objects)
   {
      this.addAll(objects);
   }

   public static final PharmaceuticalFormSet EMPTY_SET = new PharmaceuticalFormSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.PharmaceuticalForm";
   }


   @SuppressWarnings("unchecked")
   public PharmaceuticalFormSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<PharmaceuticalForm>)value);
      }
      else if (value != null)
      {
         this.add((PharmaceuticalForm) value);
      }
      
      return this;
   }
   
   public PharmaceuticalFormSet without(PharmaceuticalForm value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of PharmaceuticalForm objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (PharmaceuticalForm obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of PharmaceuticalForm objects and collect those PharmaceuticalForm objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of PharmaceuticalForm objects that match the parameter
    */
   public PharmaceuticalFormSet filterId(int value)
   {
      PharmaceuticalFormSet result = new PharmaceuticalFormSet();
      
      for (PharmaceuticalForm obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PharmaceuticalForm objects and collect those PharmaceuticalForm objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of PharmaceuticalForm objects that match the parameter
    */
   public PharmaceuticalFormSet filterId(int lower, int upper)
   {
      PharmaceuticalFormSet result = new PharmaceuticalFormSet();
      
      for (PharmaceuticalForm obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PharmaceuticalForm objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of PharmaceuticalForm objects now with new attribute values.
    */
   public PharmaceuticalFormSet withId(int value)
   {
      for (PharmaceuticalForm obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of PharmaceuticalForm objects and collect a list of the name attribute values. 
    * 
    * @return List of String objects reachable via name attribute
    */
   public ObjectSet getName()
   {
      ObjectSet result = new ObjectSet();
      
      for (PharmaceuticalForm obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }


   /**
    * Loop through the current set of PharmaceuticalForm objects and collect those PharmaceuticalForm objects where the name attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of PharmaceuticalForm objects that match the parameter
    */
   public PharmaceuticalFormSet filterName(String value)
   {
      PharmaceuticalFormSet result = new PharmaceuticalFormSet();
      
      for (PharmaceuticalForm obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PharmaceuticalForm objects and collect those PharmaceuticalForm objects where the name attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of PharmaceuticalForm objects that match the parameter
    */
   public PharmaceuticalFormSet filterName(String lower, String upper)
   {
      PharmaceuticalFormSet result = new PharmaceuticalFormSet();
      
      for (PharmaceuticalForm obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PharmaceuticalForm objects and assign value to the name attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of PharmaceuticalForm objects now with new attribute values.
    */
   public PharmaceuticalFormSet withName(String value)
   {
      for (PharmaceuticalForm obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of PharmaceuticalForm objects and collect a set of the Drug objects reached via drug. 
    * 
    * @return Set of Drug objects reachable via drug
    */
   public DrugSet getDrug()
   {
      DrugSet result = new DrugSet();
      
      for (PharmaceuticalForm obj : this)
      {
         result.with(obj.getDrug());
      }
      
      return result;
   }

   /**
    * Loop through the current set of PharmaceuticalForm objects and collect all contained objects with reference drug pointing to the object passed as parameter. 
    * 
    * @param value The object required as drug neighbor of the collected results. 
    * 
    * @return Set of Drug objects referring to value via drug
    */
   public PharmaceuticalFormSet filterDrug(Object value)
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
      
      PharmaceuticalFormSet answer = new PharmaceuticalFormSet();
      
      for (PharmaceuticalForm obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getDrug()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the PharmaceuticalForm object passed as parameter to the Drug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Drug attributes.
    */
   public PharmaceuticalFormSet withDrug(Drug value)
   {
      for (PharmaceuticalForm obj : this)
      {
         obj.withDrug(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the PharmaceuticalForm object passed as parameter from the Drug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public PharmaceuticalFormSet withoutDrug(Drug value)
   {
      for (PharmaceuticalForm obj : this)
      {
         obj.withoutDrug(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of PharmaceuticalForm objects and collect a set of the IntakeInformation objects reached via intakeInformation. 
    * 
    * @return Set of IntakeInformation objects reachable via intakeInformation
    */
   public IntakeInformationSet getIntakeInformation()
   {
      IntakeInformationSet result = new IntakeInformationSet();
      
      for (PharmaceuticalForm obj : this)
      {
         result.with(obj.getIntakeInformation());
      }
      
      return result;
   }

   /**
    * Loop through the current set of PharmaceuticalForm objects and collect all contained objects with reference intakeInformation pointing to the object passed as parameter. 
    * 
    * @param value The object required as intakeInformation neighbor of the collected results. 
    * 
    * @return Set of IntakeInformation objects referring to value via intakeInformation
    */
   public PharmaceuticalFormSet filterIntakeInformation(Object value)
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
      
      PharmaceuticalFormSet answer = new PharmaceuticalFormSet();
      
      for (PharmaceuticalForm obj : this)
      {
         if (neighbors.contains(obj.getIntakeInformation()) || (neighbors.isEmpty() && obj.getIntakeInformation() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the PharmaceuticalForm object passed as parameter to the IntakeInformation attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their IntakeInformation attributes.
    */
   public PharmaceuticalFormSet withIntakeInformation(IntakeInformation value)
   {
      for (PharmaceuticalForm obj : this)
      {
         obj.withIntakeInformation(value);
      }
      
      return this;
   }

}
