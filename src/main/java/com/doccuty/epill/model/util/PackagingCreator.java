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

import de.uniks.networkparser.interfaces.SendableEntityCreatorNoIndex;

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.model.Packaging;
import de.uniks.networkparser.IdMap;

public class PackagingCreator implements SendableEntityCreatorNoIndex
{
   private final String[] properties = new String[]
   {
      Packaging.PROPERTY_ID,
      Packaging.PROPERTY_NAME,
      Packaging.PROPERTY_PZN
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Packaging();
   }
   
   @Override
   public Object getValue(Object target, String attrName)
   {
      int pos = attrName.indexOf('.');
      String attribute = attrName;
      
      if (pos > 0)
      {
         attribute = attrName.substring(0, pos);
      }

      if (Packaging.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((Packaging) target).getId();
      }

      if (Packaging.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         return ((Packaging) target).getName();
      }

      if (Packaging.PROPERTY_PZN.equalsIgnoreCase(attribute))
      {
         return ((Packaging) target).getPzn();
      }

      if (Packaging.PROPERTY_DRUG.equalsIgnoreCase(attribute))
      {
         return ((Packaging) target).getDrug();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (Packaging.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         ((Packaging) target).setName((String) value);
         return true;
      }

      if (Packaging.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((Packaging) target).setId(Integer.parseInt(value.toString()));
         return true;
      }

      if (Packaging.PROPERTY_PZN.equalsIgnoreCase(attrName))
      {
         ((Packaging) target).setPzn((String) value);
         return true;
      }

      if (Packaging.PROPERTY_DRUG.equalsIgnoreCase(attrName))
      {
         ((Packaging) target).setDrug((Drug) value);
         return true;
      }
      
      if (SendableEntityCreatorNoIndex.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }
      
      return false;
   }
   public static IdMap createIdMap(String sessionID)
   {
      return com.doccuty.epill.model.util.CreatorCreator.createIdMap(sessionID);
   }
   
   //==========================================================================
      public void removeObject(Object entity)
   {
      ((Packaging) entity).removeYou();
   }
}
