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
import com.doccuty.epill.model.Packaging;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;

public class PackagingSet extends HashSet<Packaging>
{
	protected Class<?> getTypClass() {
		return Packaging.class;
	}

   public PackagingSet()
   {
      // empty
   }

   public PackagingSet(Packaging... objects)
   {
      for (Packaging obj : objects)
      {
         this.add(obj);
      }
   }

   public PackagingSet(Collection<Packaging> objects)
   {
      this.addAll(objects);
   }

   public static final PackagingSet EMPTY_SET = new PackagingSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.Tag";
   }


   @SuppressWarnings("unchecked")
   public PackagingSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Packaging>)value);
      }
      else if (value != null)
      {
         this.add((Packaging) value);
      }
      
      return this;
   }
   
   public PackagingSet without(Packaging value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of Tag objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (Packaging obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Tag objects and collect those Tag objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Tag objects that match the parameter
    */
   public PackagingSet filterId(int value)
   {
      PackagingSet result = new PackagingSet();
      
      for (Packaging obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Tag objects and collect those Tag objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Tag objects that match the parameter
    */
   public PackagingSet filterId(int lower, int upper)
   {
      PackagingSet result = new PackagingSet();
      
      for (Packaging obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Tag objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Tag objects now with new attribute values.
    */
   public PackagingSet withId(int value)
   {
      for (Packaging obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of Tag objects and collect a list of the name attribute values. 
    * 
    * @return List of String objects reachable via name attribute
    */
   public ObjectSet getName()
   {
      ObjectSet result = new ObjectSet();
      
      for (Packaging obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Tag objects and collect those Tag objects where the name attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Tag objects that match the parameter
    */
   public PackagingSet filterName(String value)
   {
      PackagingSet result = new PackagingSet();
      
      for (Packaging obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Tag objects and collect those Tag objects where the name attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Tag objects that match the parameter
    */
   public PackagingSet filternName(String lower, String upper)
   {
      PackagingSet result = new PackagingSet();
      
      for (Packaging obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Tag objects and assign value to the name attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Tag objects now with new attribute values.
    */
   public PackagingSet withName(String value)
   {
      for (Packaging obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }

   
   
   /**
    * Loop through the current set of Packaging objects and collect a list of the drug attribute values. 
    * 
    * @return List of Drug objects reachable via name attribute
    */
   public ObjectSet getDrug()
   {
      ObjectSet result = new ObjectSet();
      
      for (Packaging obj : this)
      {
         result.add(obj.getDrug());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Packaging objects and collect those Packaging objects where the drug attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Packaging objects that match the parameter
    */
   public PackagingSet filterDrug(Drug value)
   {
      PackagingSet result = new PackagingSet();
      
      for (Packaging obj : this)
      {
         if (value.equals(obj.getDrug()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Packaging objects and assign value to the drug attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Packaging objects now with new attribute values.
    */
   public PackagingSet withDrug(Drug value)
   {
      for (Packaging obj : this)
      {
         obj.setDrug(value);
      }
      
      return this;
   }

}
