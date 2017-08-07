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
import com.doccuty.epill.model.ProductGroup;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import com.doccuty.epill.model.util.DrugSet;

public class ProductGroupSet extends HashSet<ProductGroup>
{
	protected Class<?> getTypClass() {
		return ProductGroup.class;
	}

   public ProductGroupSet()
   {
      // empty
   }

   public ProductGroupSet(ProductGroup... objects)
   {
      for (ProductGroup obj : objects)
      {
         this.add(obj);
      }
   }

   public ProductGroupSet(Collection<ProductGroup> objects)
   {
      this.addAll(objects);
   }

   public static final ProductGroupSet EMPTY_SET = new ProductGroupSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.ProductGroup";
   }


   @SuppressWarnings("unchecked")
   public ProductGroupSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<ProductGroup>)value);
      }
      else if (value != null)
      {
         this.add((ProductGroup) value);
      }
      
      return this;
   }
   
   public ProductGroupSet without(ProductGroup value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of ProductGroup objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (ProductGroup obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ProductGroup objects and collect those ProductGroup objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ProductGroup objects that match the parameter
    */
   public ProductGroupSet filterId(int value)
   {
      ProductGroupSet result = new ProductGroupSet();
      
      for (ProductGroup obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ProductGroup objects and collect those ProductGroup objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ProductGroup objects that match the parameter
    */
   public ProductGroupSet filterId(int lower, int upper)
   {
      ProductGroupSet result = new ProductGroupSet();
      
      for (ProductGroup obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ProductGroup objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ProductGroup objects now with new attribute values.
    */
   public ProductGroupSet withId(int value)
   {
      for (ProductGroup obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of ProductGroup objects and collect a list of the name attribute values. 
    * 
    * @return List of String objects reachable via name attribute
    */
   public ObjectSet getName()
   {
      ObjectSet result = new ObjectSet();
      
      for (ProductGroup obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ProductGroup objects and collect those ProductGroup objects where the name attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ProductGroup objects that match the parameter
    */
   public ProductGroupSet filterName(String value)
   {
      ProductGroupSet result = new ProductGroupSet();
      
      for (ProductGroup obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ProductGroup objects and collect those ProductGroup objects where the name attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ProductGroup objects that match the parameter
    */
   public ProductGroupSet filterName(String lower, String upper)
   {
      ProductGroupSet result = new ProductGroupSet();
      
      for (ProductGroup obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ProductGroup objects and assign value to the name attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ProductGroup objects now with new attribute values.
    */
   public ProductGroupSet withName(String value)
   {
      for (ProductGroup obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ProductGroup objects and collect a set of the Drug objects reached via drug. 
    * 
    * @return Set of Drug objects reachable via drug
    */
   public DrugSet getDrug()
   {
      DrugSet result = new DrugSet();
      
      for (ProductGroup obj : this)
      {
         result.with(obj.getDrug());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ProductGroup objects and collect all contained objects with reference drug pointing to the object passed as parameter. 
    * 
    * @param value The object required as drug neighbor of the collected results. 
    * 
    * @return Set of Drug objects referring to value via drug
    */
   public ProductGroupSet filterDrug(Object value)
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
      
      ProductGroupSet answer = new ProductGroupSet();
      
      for (ProductGroup obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getDrug()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ProductGroup object passed as parameter to the Drug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Drug attributes.
    */
   public ProductGroupSet withDrug(Drug value)
   {
      for (ProductGroup obj : this)
      {
         obj.withDrug(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the ProductGroup object passed as parameter from the Drug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public ProductGroupSet withoutDrug(Drug value)
   {
      for (ProductGroup obj : this)
      {
         obj.withoutDrug(value);
      }
      
      return this;
   }

}
