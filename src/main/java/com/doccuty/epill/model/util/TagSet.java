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
import com.doccuty.epill.model.Tag;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;

public class TagSet extends HashSet<Tag>
{
	protected Class<?> getTypClass() {
		return Tag.class;
	}

   public TagSet()
   {
      // empty
   }

   public TagSet(Tag... objects)
   {
      for (Tag obj : objects)
      {
         this.add(obj);
      }
   }

   public TagSet(Collection<Tag> objects)
   {
      this.addAll(objects);
   }

   public static final TagSet EMPTY_SET = new TagSet();


   public String getEntryType()
   {
      return "com.doccuty.epill.model.Tag";
   }


   @SuppressWarnings("unchecked")
   public TagSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Tag>)value);
      }
      else if (value != null)
      {
         this.add((Tag) value);
      }
      
      return this;
   }
   
   public TagSet without(Tag value)
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
      
      for (Tag obj : this)
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
   public TagSet filterId(int value)
   {
      TagSet result = new TagSet();
      
      for (Tag obj : this)
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
   public TagSet filterId(int lower, int upper)
   {
      TagSet result = new TagSet();
      
      for (Tag obj : this)
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
   public TagSet withId(int value)
   {
      for (Tag obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of Tag objects and collect a list of the tag attribute values. 
    * 
    * @return List of String objects reachable via tag attribute
    */
   public ObjectSet getTag()
   {
      ObjectSet result = new ObjectSet();
      
      for (Tag obj : this)
      {
         result.add(obj.getTag());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Tag objects and collect those Tag objects where the tag attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Tag objects that match the parameter
    */
   public TagSet filterTag(String value)
   {
      TagSet result = new TagSet();
      
      for (Tag obj : this)
      {
         if (value.equals(obj.getTag()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Tag objects and collect those Tag objects where the tag attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Tag objects that match the parameter
    */
   public TagSet filterTag(String lower, String upper)
   {
      TagSet result = new TagSet();
      
      for (Tag obj : this)
      {
         if (lower.compareTo(obj.getTag()) <= 0 && obj.getTag().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Tag objects and assign value to the tag attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Tag objects now with new attribute values.
    */
   public TagSet withTag(String value)
   {
      for (Tag obj : this)
      {
         obj.setTag(value);
      }
      
      return this;
   }

}
