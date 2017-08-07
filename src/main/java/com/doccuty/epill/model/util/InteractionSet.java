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
import com.doccuty.epill.model.Interaction;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import com.doccuty.epill.model.util.DrugSet;

import java.util.Collections;

public class InteractionSet extends HashSet<Interaction>
{
	protected Class<?> getTypClass() {
		return Interaction.class;
	}

   public InteractionSet()
   {
      // empty
   }

   public InteractionSet(Interaction... objects)
   {
      for (Interaction obj : objects)
      {
         this.add(obj);
      }
   }

   public InteractionSet(Collection<Interaction> objects)
   {
      this.addAll(objects);
   }

   public static final InteractionSet EMPTY_SET = new InteractionSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.Interaction";
   }


   @SuppressWarnings("unchecked")
   public InteractionSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Interaction>)value);
      }
      else if (value != null)
      {
         this.add((Interaction) value);
      }
      
      return this;
   }
   
   public InteractionSet without(Interaction value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of Interaction objects and collect a list of the id attribute values. 
    * 
    * @return List of int objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (Interaction obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Interaction objects and collect those Interaction objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Interaction objects that match the parameter
    */
   public InteractionSet filterId(int value)
   {
      InteractionSet result = new InteractionSet();
      
      for (Interaction obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Interaction objects and collect those Interaction objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Interaction objects that match the parameter
    */
   public InteractionSet filterId(int lower, int upper)
   {
      InteractionSet result = new InteractionSet();
      
      for (Interaction obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Interaction objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Interaction objects now with new attribute values.
    */
   public InteractionSet withId(int value)
   {
      for (Interaction obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of Interaction objects and collect a list of the interaction attribute values. 
    * 
    * @return List of String objects reachable via interaction attribute
    */
   public ObjectSet getInteraction()
   {
      ObjectSet result = new ObjectSet();
      
      for (Interaction obj : this)
      {
         result.add(obj.getInteraction());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Interaction objects and collect those Interaction objects where the interaction attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Interaction objects that match the parameter
    */
   public InteractionSet filterInteraction(String value)
   {
      InteractionSet result = new InteractionSet();
      
      for (Interaction obj : this)
      {
         if (value.equals(obj.getInteraction()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Interaction objects and collect those Interaction objects where the interaction attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Interaction objects that match the parameter
    */
   public InteractionSet filterInteraction(String lower, String upper)
   {
      InteractionSet result = new InteractionSet();
      
      for (Interaction obj : this)
      {
         if (lower.compareTo(obj.getInteraction()) <= 0 && obj.getInteraction().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Interaction objects and assign value to the interaction attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Interaction objects now with new attribute values.
    */
   public InteractionSet withInteraction(String value)
   {
      for (Interaction obj : this)
      {
         obj.setInteraction(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Interaction objects and collect a set of the Drug objects reached via drug. 
    * 
    * @return Set of Drug objects reachable via drug
    */
   public DrugSet getDrug()
   {
      DrugSet result = new DrugSet();
      
      for (Interaction obj : this)
      {
         result.with(obj.getDrug());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Interaction objects and collect all contained objects with reference drug pointing to the object passed as parameter. 
    * 
    * @param value The object required as drug neighbor of the collected results. 
    * 
    * @return Set of Drug objects referring to value via drug
    */
   public InteractionSet filterDrug(Object value)
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
      
      InteractionSet answer = new InteractionSet();
      
      for (Interaction obj : this)
      {
         if (neighbors.contains(obj.getDrug()) || (neighbors.isEmpty() && obj.getDrug() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Interaction object passed as parameter to the Drug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Drug attributes.
    */
   public InteractionSet withDrug(Drug value)
   {
      for (Interaction obj : this)
      {
         obj.withDrug(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Interaction objects and collect a set of the Drug objects reached via interactionDrug. 
    * 
    * @return Set of Drug objects reachable via interactionDrug
    */
   public DrugSet getInteractionDrug()
   {
      DrugSet result = new DrugSet();
      
      for (Interaction obj : this)
      {
         result.with(obj.getInteractionDrug());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Interaction objects and collect all contained objects with reference interactionDrug pointing to the object passed as parameter. 
    * 
    * @param value The object required as interactionDrug neighbor of the collected results. 
    * 
    * @return Set of Drug objects referring to value via interactionDrug
    */
   public InteractionSet filterInteractionDrug(Object value)
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
      
      InteractionSet answer = new InteractionSet();
      
      for (Interaction obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getInteractionDrug()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Interaction object passed as parameter to the InteractionDrug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their InteractionDrug attributes.
    */
   public InteractionSet withInteractionDrug(Drug value)
   {
      for (Interaction obj : this)
      {
         obj.withInteractionDrug(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Interaction object passed as parameter from the InteractionDrug attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public InteractionSet withoutInteractionDrug(Drug value)
   {
      for (Interaction obj : this)
      {
         obj.withoutInteractionDrug(value);
      }
      
      return this;
   }

}
