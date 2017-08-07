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
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import com.doccuty.epill.model.util.PackagingSectionSet;
import com.doccuty.epill.model.util.ActiveSubstanceSet;
import com.doccuty.epill.disease.Disease;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.iteminvocation.ItemInvocation;
import com.doccuty.epill.model.ActiveSubstance;
import com.doccuty.epill.model.util.ProductGroupSet;
import com.doccuty.epill.packagingsection.PackagingSection;
import com.doccuty.epill.model.ProductGroup;
import com.doccuty.epill.model.util.IndicationGroupSet;
import com.doccuty.epill.model.IndicationGroup;
import com.doccuty.epill.model.util.PharmaceuticalFormSet;
import com.doccuty.epill.model.PharmaceuticalForm;
import com.doccuty.epill.model.util.AdverseEffectSet;
import com.doccuty.epill.model.AdverseEffect;
import com.doccuty.epill.model.util.InteractionSet;
import com.doccuty.epill.model.Interaction;
import com.doccuty.epill.model.util.ItemInvocationSet;
import com.doccuty.epill.model.util.DiseaseSet;

public class DrugSet extends HashSet<Drug>
{
	protected Class<?> getTypClass() {
		return Drug.class;
	}

   public DrugSet()
   {
      // empty
   }

   public DrugSet(Drug... objects)
   {
      for (Drug obj : objects)
      {
         this.add(obj);
      }
   }

   public DrugSet(Collection<Drug> objects)
   {
      this.addAll(objects);
   }

   public static final DrugSet EMPTY_SET = new DrugSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.Drug";
   }


   @SuppressWarnings("unchecked")
   public DrugSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Drug>)value);
      }
      else if (value != null)
      {
         this.add((Drug) value);
      }
      
      return this;
   }
   
   public DrugSet without(Drug value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of Drug objects and collect a list of the id attribute values. 
    * 
    * @return List of long objects reachable via id attribute
    */
   public NumberList getId()
   {
      NumberList result = new NumberList();
      
      for (Drug obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Drug objects and collect those Drug objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Drug objects that match the parameter
    */
   public DrugSet filterId(long value)
   {
      DrugSet result = new DrugSet();
      
      for (Drug obj : this)
      {
         if (value == obj.getId())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Drug objects and collect those Drug objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Drug objects that match the parameter
    */
   public DrugSet filterId(long lower, long upper)
   {
      DrugSet result = new DrugSet();
      
      for (Drug obj : this)
      {
         if (lower <= obj.getId() && obj.getId() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Drug objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Drug objects now with new attribute values.
    */
   public DrugSet withId(long value)
   {
      for (Drug obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of Drug objects and collect a list of the name attribute values. 
    * 
    * @return List of String objects reachable via name attribute
    */
   public ObjectSet getName()
   {
      ObjectSet result = new ObjectSet();
      
      for (Drug obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Drug objects and collect those Drug objects where the name attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Drug objects that match the parameter
    */
   public DrugSet filterName(String value)
   {
      DrugSet result = new DrugSet();
      
      for (Drug obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Drug objects and collect those Drug objects where the name attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Drug objects that match the parameter
    */
   public DrugSet filterName(String lower, String upper)
   {
      DrugSet result = new DrugSet();
      
      for (Drug obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Drug objects and assign value to the name attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Drug objects now with new attribute values.
    */
   public DrugSet withName(String value)
   {
      for (Drug obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Drug objects and collect a set of the PackagingSection objects reached via packagingSection. 
    * 
    * @return Set of PackagingSection objects reachable via packagingSection
    */
   public PackagingSectionSet getPackagingSection()
   {
      PackagingSectionSet result = new PackagingSectionSet();
      
      for (Drug obj : this)
      {
         result.with(obj.getPackagingSection());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Drug objects and collect all contained objects with reference packagingSection pointing to the object passed as parameter. 
    * 
    * @param value The object required as packagingSection neighbor of the collected results. 
    * 
    * @return Set of PackagingSection objects referring to value via packagingSection
    */
   public DrugSet filterPackagingSection(Object value)
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
      
      DrugSet answer = new DrugSet();
      
      for (Drug obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getPackagingSection()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Drug object passed as parameter to the PackagingSection attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their PackagingSection attributes.
    */
   public DrugSet withPackagingSection(PackagingSection value)
   {
      for (Drug obj : this)
      {
         obj.withPackagingSection(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Drug object passed as parameter from the PackagingSection attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public DrugSet withoutPackagingSection(PackagingSection value)
   {
      for (Drug obj : this)
      {
         obj.withoutPackagingSection(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Drug objects and collect a set of the ActiveSubstance objects reached via activeSubstance. 
    * 
    * @return Set of ActiveSubstance objects reachable via activeSubstance
    */
   public ActiveSubstanceSet getActiveSubstance()
   {
      ActiveSubstanceSet result = new ActiveSubstanceSet();
      
      for (Drug obj : this)
      {
         result.with(obj.getActiveSubstance());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Drug objects and collect all contained objects with reference activeSubstance pointing to the object passed as parameter. 
    * 
    * @param value The object required as activeSubstance neighbor of the collected results. 
    * 
    * @return Set of ActiveSubstance objects referring to value via activeSubstance
    */
   public DrugSet filterActiveSubstance(Object value)
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
      
      DrugSet answer = new DrugSet();
      
      for (Drug obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getActiveSubstance()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Drug object passed as parameter to the ActiveSubstance attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their ActiveSubstance attributes.
    */
   public DrugSet withActiveSubstance(ActiveSubstance value)
   {
      for (Drug obj : this)
      {
         obj.withActiveSubstance(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Drug object passed as parameter from the ActiveSubstance attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public DrugSet withoutActiveSubstance(ActiveSubstance value)
   {
      for (Drug obj : this)
      {
         obj.withoutActiveSubstance(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Drug objects and collect a set of the ProductGroup objects reached via productGroup. 
    * 
    * @return Set of ProductGroup objects reachable via productGroup
    */
   public ProductGroupSet getProductGroup()
   {
      ProductGroupSet result = new ProductGroupSet();
      
      for (Drug obj : this)
      {
         result.with(obj.getProductGroup());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Drug objects and collect all contained objects with reference productGroup pointing to the object passed as parameter. 
    * 
    * @param value The object required as productGroup neighbor of the collected results. 
    * 
    * @return Set of ProductGroup objects referring to value via productGroup
    */
   public DrugSet filterProductGroup(Object value)
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
      
      DrugSet answer = new DrugSet();
      
      for (Drug obj : this)
      {
         if (neighbors.contains(obj.getProductGroup()) || (neighbors.isEmpty() && obj.getProductGroup() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Drug object passed as parameter to the ProductGroup attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their ProductGroup attributes.
    */
   public DrugSet withProductGroup(ProductGroup value)
   {
      for (Drug obj : this)
      {
         obj.withProductGroup(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Drug objects and collect a set of the IndicationGroup objects reached via indicationGroup. 
    * 
    * @return Set of IndicationGroup objects reachable via indicationGroup
    */
   public IndicationGroupSet getIndicationGroup()
   {
      IndicationGroupSet result = new IndicationGroupSet();
      
      for (Drug obj : this)
      {
         result.with(obj.getIndicationGroup());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Drug objects and collect all contained objects with reference indicationGroup pointing to the object passed as parameter. 
    * 
    * @param value The object required as indicationGroup neighbor of the collected results. 
    * 
    * @return Set of IndicationGroup objects referring to value via indicationGroup
    */
   public DrugSet filterIndicationGroup(Object value)
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
      
      DrugSet answer = new DrugSet();
      
      for (Drug obj : this)
      {
         if (neighbors.contains(obj.getIndicationGroup()) || (neighbors.isEmpty() && obj.getIndicationGroup() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Drug object passed as parameter to the IndicationGroup attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their IndicationGroup attributes.
    */
   public DrugSet withIndicationGroup(IndicationGroup value)
   {
      for (Drug obj : this)
      {
         obj.withIndicationGroup(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Drug objects and collect a set of the PharmaceuticalForm objects reached via pharmaceuticalForm. 
    * 
    * @return Set of PharmaceuticalForm objects reachable via pharmaceuticalForm
    */
   public PharmaceuticalFormSet getPharmaceuticalForm()
   {
      PharmaceuticalFormSet result = new PharmaceuticalFormSet();
      
      for (Drug obj : this)
      {
         result.with(obj.getPharmaceuticalForm());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Drug objects and collect all contained objects with reference pharmaceuticalForm pointing to the object passed as parameter. 
    * 
    * @param value The object required as pharmaceuticalForm neighbor of the collected results. 
    * 
    * @return Set of PharmaceuticalForm objects referring to value via pharmaceuticalForm
    */
   public DrugSet filterPharmaceuticalForm(Object value)
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
      
      DrugSet answer = new DrugSet();
      
      for (Drug obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getPharmaceuticalForm()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Drug object passed as parameter to the PharmaceuticalForm attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their PharmaceuticalForm attributes.
    */
   public DrugSet withPharmaceuticalForm(PharmaceuticalForm value)
   {
      for (Drug obj : this)
      {
         obj.withPharmaceuticalForm(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Drug object passed as parameter from the PharmaceuticalForm attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public DrugSet withoutPharmaceuticalForm(PharmaceuticalForm value)
   {
      for (Drug obj : this)
      {
         obj.withoutPharmaceuticalForm(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Drug objects and collect a set of the AdverseEffect objects reached via adverseEffects. 
    * 
    * @return Set of AdverseEffect objects reachable via adverseEffects
    */
   public AdverseEffectSet getAdverseEffects()
   {
      AdverseEffectSet result = new AdverseEffectSet();
      
      for (Drug obj : this)
      {
         result.with(obj.getAdverseEffects());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Drug objects and collect all contained objects with reference adverseEffects pointing to the object passed as parameter. 
    * 
    * @param value The object required as adverseEffects neighbor of the collected results. 
    * 
    * @return Set of AdverseEffect objects referring to value via adverseEffects
    */
   public DrugSet filterAdverseEffects(Object value)
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
      
      DrugSet answer = new DrugSet();
      
      for (Drug obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getAdverseEffects()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Drug object passed as parameter to the AdverseEffects attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their AdverseEffects attributes.
    */
   public DrugSet withAdverseEffects(AdverseEffect value)
   {
      for (Drug obj : this)
      {
         obj.withAdverseEffects(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Drug object passed as parameter from the AdverseEffects attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public DrugSet withoutAdverseEffects(AdverseEffect value)
   {
      for (Drug obj : this)
      {
         obj.withoutAdverseEffects(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Drug objects and collect a set of the Interaction objects reached via interaction. 
    * 
    * @return Set of Interaction objects reachable via interaction
    */
   public InteractionSet getInteraction()
   {
      InteractionSet result = new InteractionSet();
      
      for (Drug obj : this)
      {
         result.with(obj.getInteraction());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Drug objects and collect all contained objects with reference interaction pointing to the object passed as parameter. 
    * 
    * @param value The object required as interaction neighbor of the collected results. 
    * 
    * @return Set of Interaction objects referring to value via interaction
    */
   public DrugSet filterInteraction(Object value)
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
      
      DrugSet answer = new DrugSet();
      
      for (Drug obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getInteraction()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Drug object passed as parameter to the Interaction attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Interaction attributes.
    */
   public DrugSet withInteraction(Interaction value)
   {
      for (Drug obj : this)
      {
         obj.withInteraction(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Drug object passed as parameter from the Interaction attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public DrugSet withoutInteraction(Interaction value)
   {
      for (Drug obj : this)
      {
         obj.withoutInteraction(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Drug objects and collect a set of the ItemInvocation objects reached via clicks. 
    * 
    * @return Set of ItemInvocation objects reachable via clicks
    */
   public ItemInvocationSet getClicks()
   {
      ItemInvocationSet result = new ItemInvocationSet();
      
      for (Drug obj : this)
      {
         result.with(obj.getClicks());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Drug objects and collect all contained objects with reference clicks pointing to the object passed as parameter. 
    * 
    * @param value The object required as clicks neighbor of the collected results. 
    * 
    * @return Set of ItemInvocation objects referring to value via clicks
    */
   public DrugSet filterClicks(Object value)
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
      
      DrugSet answer = new DrugSet();
      
      for (Drug obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getClicks()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Drug object passed as parameter to the Clicks attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Clicks attributes.
    */
   public DrugSet withClicks(ItemInvocation value)
   {
      for (Drug obj : this)
      {
         obj.withClicks(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Drug object passed as parameter from the Clicks attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public DrugSet withoutClicks(ItemInvocation value)
   {
      for (Drug obj : this)
      {
         obj.withoutClicks(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Drug objects and collect a set of the Disease objects reached via disease. 
    * 
    * @return Set of Disease objects reachable via disease
    */
   public DiseaseSet getDisease()
   {
      DiseaseSet result = new DiseaseSet();
      
      for (Drug obj : this)
      {
         result.with(obj.getDisease());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Drug objects and collect all contained objects with reference disease pointing to the object passed as parameter. 
    * 
    * @param value The object required as disease neighbor of the collected results. 
    * 
    * @return Set of Disease objects referring to value via disease
    */
   public DrugSet filterDisease(Object value)
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
      
      DrugSet answer = new DrugSet();
      
      for (Drug obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getDisease()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Drug object passed as parameter to the Disease attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Disease attributes.
    */
   public DrugSet withDisease(Disease value)
   {
      for (Drug obj : this)
      {
         obj.withDisease(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Drug object passed as parameter from the Disease attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public DrugSet withoutDisease(Disease value)
   {
      for (Drug obj : this)
      {
         obj.withoutDisease(value);
      }
      
      return this;
   }

}
