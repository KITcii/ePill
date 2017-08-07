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
import com.doccuty.epill.model.PackagingTopic;
import de.uniks.networkparser.list.ObjectSet;
import com.doccuty.epill.model.util.DrugSet;

import java.util.Collections;
import com.doccuty.epill.model.util.ItemInvocationSet;
import com.doccuty.epill.packagingsection.PackagingSection;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.iteminvocation.ItemInvocation;

public class PackagingSectionSet extends HashSet<PackagingSection>
{
	protected Class<?> getTypClass() {
		return PackagingSection.class;
	}

   public PackagingSectionSet()
   {
      // empty
   }

   public PackagingSectionSet(PackagingSection... objects)
   {
      for (PackagingSection obj : objects)
      {
         this.add(obj);
      }
   }

   public PackagingSectionSet(Collection<PackagingSection> objects)
   {
      this.addAll(objects);
   }

   public static final PackagingSectionSet EMPTY_SET = new PackagingSectionSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.PackagingSection";
   }


   @SuppressWarnings("unchecked")
   public PackagingSectionSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<PackagingSection>)value);
      }
      else if (value != null)
      {
         this.add((PackagingSection) value);
      }
      
      return this;
   }
   
   public PackagingSectionSet without(PackagingSection value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of PackagingSection objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (PackagingSection obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of PackagingSection objects and collect those PackagingSection objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of PackagingSection objects that match the parameter
    */
   public PackagingSectionSet filterId(int value)
   {
      PackagingSectionSet result = new PackagingSectionSet();
      
      for (PackagingSection obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PackagingSection objects and collect those PackagingSection objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of PackagingSection objects that match the parameter
    */
   public PackagingSectionSet filterId(int lower, int upper)
   {
      PackagingSectionSet result = new PackagingSectionSet();
      
      for (PackagingSection obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PackagingSection objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of PackagingSection objects now with new attribute values.
    */
   public PackagingSectionSet withId(int value)
   {
      for (PackagingSection obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of PackagingSection objects and collect a list of the topic attribute values. 
    * 
    * @return List of com.doccuty.epill.model.PackagingTopic objects reachable via topic attribute
    */
   public PackagingTopicSet getTopic()
   {
      PackagingTopicSet result = new PackagingTopicSet();
      
      for (PackagingSection obj : this)
      {
         result.add(obj.getTopic());
      }
      
      return result;
   }


   /**
    * Loop through the current set of PackagingSection objects and collect those PackagingSection objects where the topic attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of PackagingSection objects that match the parameter
    */
   public PackagingSectionSet filterTopic(PackagingTopic value)
   {
      PackagingSectionSet result = new PackagingSectionSet();
      
      for (PackagingSection obj : this)
      {
         if (value == obj.getTopic())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PackagingSection objects and assign value to the topic attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of PackagingSection objects now with new attribute values.
    */
   public PackagingSectionSet withTopic(PackagingTopic value)
   {
      for (PackagingSection obj : this)
      {
         obj.setTopic(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of PackagingSection objects and collect a list of the text attribute values. 
    * 
    * @return List of String objects reachable via text attribute
    */
   public ObjectSet getText()
   {
      ObjectSet result = new ObjectSet();
      
      for (PackagingSection obj : this)
      {
         result.add(obj.getText());
      }
      
      return result;
   }


   /**
    * Loop through the current set of PackagingSection objects and collect those PackagingSection objects where the text attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of PackagingSection objects that match the parameter
    */
   public PackagingSectionSet filterText(String value)
   {
      PackagingSectionSet result = new PackagingSectionSet();
      
      for (PackagingSection obj : this)
      {
         if (value.equals(obj.getText()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PackagingSection objects and collect those PackagingSection objects where the text attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of PackagingSection objects that match the parameter
    */
   public PackagingSectionSet filterText(String lower, String upper)
   {
      PackagingSectionSet result = new PackagingSectionSet();
      
      for (PackagingSection obj : this)
      {
         if (lower.compareTo(obj.getText()) <= 0 && obj.getText().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PackagingSection objects and assign value to the text attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of PackagingSection objects now with new attribute values.
    */
   public PackagingSectionSet withText(String value)
   {
      for (PackagingSection obj : this)
      {
         obj.setText(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of PackagingSection objects and collect a set of the Drug objects reached via drug. 
    * 
    * @return Set of Drug objects reachable via drug
    */
   public DrugSet getDrug()
   {
      DrugSet result = new DrugSet();
      
      for (PackagingSection obj : this)
      {
         result.with(obj.getDrug());
      }
      
      return result;
   }

   /**
    * Loop through the current set of PackagingSection objects and collect all contained objects with reference drug pointing to the object passed as parameter. 
    * 
    * @param value The object required as drug neighbor of the collected results. 
    * 
    * @return Set of Drug objects referring to value via drug
    */
   public PackagingSectionSet filterDrug(Object value)
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
      
      PackagingSectionSet answer = new PackagingSectionSet();
      
      for (PackagingSection obj : this)
      {
         if (neighbors.contains(obj.getDrug()) || (neighbors.isEmpty() && obj.getDrug() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the PackagingSection object passed as parameter to the Drug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Drug attributes.
    */
   public PackagingSectionSet withDrug(Drug value)
   {
      for (PackagingSection obj : this)
      {
         obj.withDrug(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of PackagingSection objects and collect a set of the ItemInvocation objects reached via clicks. 
    * 
    * @return Set of ItemInvocation objects reachable via clicks
    */
   public ItemInvocationSet getClicks()
   {
      ItemInvocationSet result = new ItemInvocationSet();
      
      for (PackagingSection obj : this)
      {
         result.with(obj.getClicks());
      }
      
      return result;
   }

   /**
    * Loop through the current set of PackagingSection objects and collect all contained objects with reference clicks pointing to the object passed as parameter. 
    * 
    * @param value The object required as clicks neighbor of the collected results. 
    * 
    * @return Set of ItemInvocation objects referring to value via clicks
    */
   public PackagingSectionSet filterClicks(Object value)
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
      
      PackagingSectionSet answer = new PackagingSectionSet();
      
      for (PackagingSection obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getClicks()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the PackagingSection object passed as parameter to the Clicks attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Clicks attributes.
    */
   public PackagingSectionSet withClicks(ItemInvocation value)
   {
      for (PackagingSection obj : this)
      {
         obj.withClicks(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the PackagingSection object passed as parameter from the Clicks attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public PackagingSectionSet withoutClicks(ItemInvocation value)
   {
      for (PackagingSection obj : this)
      {
         obj.withoutClicks(value);
      }
      
      return this;
   }

}
