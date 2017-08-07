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
   
package com.doccuty.epill.model;

import de.uniks.networkparser.interfaces.SendableEntity;
import java.beans.PropertyChangeSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.beans.PropertyChangeListener;
import de.uniks.networkparser.EntityUtil;
import com.doccuty.epill.model.PharmaceuticalForm;
   /**
    * 
    * @see <a href='../../../../../../../src/test/java/com/doccuty/epill/model/SDMLib/ModelCreator.java'>ModelCreator.java</a>
 */
@Entity
@Table(name="intake_information")
   public  class IntakeInformation implements SendableEntity
{

   
   //==========================================================================
   
   protected PropertyChangeSupport listeners = null;
   
   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (listeners != null) {
   		listeners.firePropertyChange(propertyName, oldValue, newValue);
   		return true;
   	}
   	return false;
   }
   
   public boolean addPropertyChangeListener(PropertyChangeListener listener) 
   {
   	if (listeners == null) {
   		listeners = new PropertyChangeSupport(this);
   	}
   	listeners.addPropertyChangeListener(listener);
   	return true;
   }
   
   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
   	if (listeners == null) {
   		listeners = new PropertyChangeSupport(this);
   	}
   	listeners.addPropertyChangeListener(propertyName, listener);
   	return true;
   }
   
   public boolean removePropertyChangeListener(PropertyChangeListener listener) {
   	if (listeners == null) {
   		listeners.removePropertyChangeListener(listener);
   	}
   	listeners.removePropertyChangeListener(listener);
   	return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener) {
   	if (listeners != null) {
   		listeners.removePropertyChangeListener(propertyName, listener);
   	}
   	return true;
   }

   
   //==========================================================================
   
   
   public void removeYou()
   {
      setPharmaceuticalForm(null);
      firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_ID = "id";
   
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private int id;

   public int getId()
   {
      return this.id;
   }
   
   public void setId(int value)
   {
      if (this.id != value) {
      
         int oldValue = this.id;
         this.id = value;
         this.firePropertyChange(PROPERTY_ID, oldValue, value);
      }
   }
   
   public IntakeInformation withId(int value)
   {
      setId(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getId());
      result.append(" ").append(this.getAmount());
      result.append(" ").append(this.getUnit());
      return result.substring(1);
   }


   
   //==========================================================================
   
   public static final String PROPERTY_AMOUNT = "amount";
   
   private String amount;

   public String getAmount()
   {
      return this.amount;
   }
   
   public void setAmount(String value)
   {
      if ( ! EntityUtil.stringEquals(this.amount, value)) {
      
         String oldValue = this.amount;
         this.amount = value;
         this.firePropertyChange(PROPERTY_AMOUNT, oldValue, value);
      }
   }
   
   public IntakeInformation withAmount(String value)
   {
      setAmount(value);
      return this;
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_UNIT = "unit";
   
   private String unit;

   public String getUnit()
   {
      return this.unit;
   }
   
   public void setUnit(String value)
   {
      if ( ! EntityUtil.stringEquals(this.unit, value)) {
      
         String oldValue = this.unit;
         this.unit = value;
         this.firePropertyChange(PROPERTY_UNIT, oldValue, value);
      }
   }
   
   public IntakeInformation withUnit(String value)
   {
      setUnit(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * IntakeInformation ----------------------------------- PharmaceuticalForm
    *              intakeInformation                   pharmaceuticalForm
    * </pre>
    */
   
   public static final String PROPERTY_PHARMACEUTICALFORM = "pharmaceuticalForm";

   @OneToOne
   @JoinColumn (name="idpharmaceutical_form")
   private PharmaceuticalForm pharmaceuticalForm = null;

   public PharmaceuticalForm getPharmaceuticalForm()
   {
      return this.pharmaceuticalForm;
   }

   public boolean setPharmaceuticalForm(PharmaceuticalForm value)
   {
      boolean changed = false;
      
      if (this.pharmaceuticalForm != value)
      {
         PharmaceuticalForm oldValue = this.pharmaceuticalForm;
         
         if (this.pharmaceuticalForm != null)
         {
            this.pharmaceuticalForm = null;
            oldValue.setIntakeInformation(null);
         }
         
         this.pharmaceuticalForm = value;
         
         if (value != null)
         {
            value.withIntakeInformation(this);
         }
         
         firePropertyChange(PROPERTY_PHARMACEUTICALFORM, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public IntakeInformation withPharmaceuticalForm(PharmaceuticalForm value)
   {
      setPharmaceuticalForm(value);
      return this;
   } 

   public PharmaceuticalForm createPharmaceuticalForm()
   {
      PharmaceuticalForm value = new PharmaceuticalForm();
      withPharmaceuticalForm(value);
      return value;
   } 
}
