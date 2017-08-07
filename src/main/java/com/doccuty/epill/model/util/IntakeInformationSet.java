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
import com.doccuty.epill.model.IntakeInformation;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import com.doccuty.epill.model.util.PharmaceuticalFormSet;
import com.doccuty.epill.model.PharmaceuticalForm;

public class IntakeInformationSet extends HashSet<IntakeInformation>
{
	protected Class<?> getTypClass() {
		return IntakeInformation.class;
	}

   public IntakeInformationSet()
   {
      // empty
   }

   public IntakeInformationSet(IntakeInformation... objects)
   {
      for (IntakeInformation obj : objects)
      {
         this.add(obj);
      }
   }

   public IntakeInformationSet(Collection<IntakeInformation> objects)
   {
      this.addAll(objects);
   }

   public static final IntakeInformationSet EMPTY_SET = new IntakeInformationSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.IntakeInformation";
   }


   @SuppressWarnings("unchecked")
   public IntakeInformationSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<IntakeInformation>)value);
      }
      else if (value != null)
      {
         this.add((IntakeInformation) value);
      }
      
      return this;
   }
   
   public IntakeInformationSet without(IntakeInformation value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of IntakeInformation objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (IntakeInformation obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of IntakeInformation objects and collect those IntakeInformation objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of IntakeInformation objects that match the parameter
    */
   public IntakeInformationSet filterId(int value)
   {
      IntakeInformationSet result = new IntakeInformationSet();
      
      for (IntakeInformation obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of IntakeInformation objects and collect those IntakeInformation objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of IntakeInformation objects that match the parameter
    */
   public IntakeInformationSet filterId(int lower, int upper)
   {
      IntakeInformationSet result = new IntakeInformationSet();
      
      for (IntakeInformation obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of IntakeInformation objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of IntakeInformation objects now with new attribute values.
    */
   public IntakeInformationSet withId(int value)
   {
      for (IntakeInformation obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of IntakeInformation objects and collect a list of the amount attribute values. 
    * 
    * @return List of String objects reachable via amount attribute
    */
   public ObjectSet getAmount()
   {
      ObjectSet result = new ObjectSet();
      
      for (IntakeInformation obj : this)
      {
         result.add(obj.getAmount());
      }
      
      return result;
   }


   /**
    * Loop through the current set of IntakeInformation objects and collect those IntakeInformation objects where the amount attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of IntakeInformation objects that match the parameter
    */
   public IntakeInformationSet filterAmount(String value)
   {
      IntakeInformationSet result = new IntakeInformationSet();
      
      for (IntakeInformation obj : this)
      {
         if (value.equals(obj.getAmount()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of IntakeInformation objects and collect those IntakeInformation objects where the amount attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of IntakeInformation objects that match the parameter
    */
   public IntakeInformationSet filterAmount(String lower, String upper)
   {
      IntakeInformationSet result = new IntakeInformationSet();
      
      for (IntakeInformation obj : this)
      {
         if (lower.compareTo(obj.getAmount()) <= 0 && obj.getAmount().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of IntakeInformation objects and assign value to the amount attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of IntakeInformation objects now with new attribute values.
    */
   public IntakeInformationSet withAmount(String value)
   {
      for (IntakeInformation obj : this)
      {
         obj.setAmount(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of IntakeInformation objects and collect a list of the unit attribute values. 
    * 
    * @return List of String objects reachable via unit attribute
    */
   public ObjectSet getUnit()
   {
      ObjectSet result = new ObjectSet();
      
      for (IntakeInformation obj : this)
      {
         result.add(obj.getUnit());
      }
      
      return result;
   }


   /**
    * Loop through the current set of IntakeInformation objects and collect those IntakeInformation objects where the unit attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of IntakeInformation objects that match the parameter
    */
   public IntakeInformationSet filterUnit(String value)
   {
      IntakeInformationSet result = new IntakeInformationSet();
      
      for (IntakeInformation obj : this)
      {
         if (value.equals(obj.getUnit()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of IntakeInformation objects and collect those IntakeInformation objects where the unit attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of IntakeInformation objects that match the parameter
    */
   public IntakeInformationSet filterUnit(String lower, String upper)
   {
      IntakeInformationSet result = new IntakeInformationSet();
      
      for (IntakeInformation obj : this)
      {
         if (lower.compareTo(obj.getUnit()) <= 0 && obj.getUnit().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of IntakeInformation objects and assign value to the unit attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of IntakeInformation objects now with new attribute values.
    */
   public IntakeInformationSet withUnit(String value)
   {
      for (IntakeInformation obj : this)
      {
         obj.setUnit(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of IntakeInformation objects and collect a set of the PharmaceuticalForm objects reached via pharmaceuticalForm. 
    * 
    * @return Set of PharmaceuticalForm objects reachable via pharmaceuticalForm
    */
   public PharmaceuticalFormSet getPharmaceuticalForm()
   {
      PharmaceuticalFormSet result = new PharmaceuticalFormSet();
      
      for (IntakeInformation obj : this)
      {
         result.with(obj.getPharmaceuticalForm());
      }
      
      return result;
   }

   /**
    * Loop through the current set of IntakeInformation objects and collect all contained objects with reference pharmaceuticalForm pointing to the object passed as parameter. 
    * 
    * @param value The object required as pharmaceuticalForm neighbor of the collected results. 
    * 
    * @return Set of PharmaceuticalForm objects referring to value via pharmaceuticalForm
    */
   public IntakeInformationSet filterPharmaceuticalForm(Object value)
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
      
      IntakeInformationSet answer = new IntakeInformationSet();
      
      for (IntakeInformation obj : this)
      {
         if (neighbors.contains(obj.getPharmaceuticalForm()) || (neighbors.isEmpty() && obj.getPharmaceuticalForm() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the IntakeInformation object passed as parameter to the PharmaceuticalForm attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their PharmaceuticalForm attributes.
    */
   public IntakeInformationSet withPharmaceuticalForm(PharmaceuticalForm value)
   {
      for (IntakeInformation obj : this)
      {
         obj.withPharmaceuticalForm(value);
      }
      
      return this;
   }

}
