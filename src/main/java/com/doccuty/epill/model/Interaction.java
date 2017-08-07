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
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.beans.PropertyChangeListener;
import de.uniks.networkparser.EntityUtil;

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.model.util.DrugSet;
   /**
    * 
    * @see <a href='../../../../../../../src/test/java/com/doccuty/epill/model/SDMLib/ModelCreator.java'>ModelCreator.java</a>
 */
@Entity
@Table(name="interaction")
   public  class Interaction implements SendableEntity
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
	  withoutDrug(this.getDrug().toArray(new Drug[this.getDrug().size()]));
      withoutInteractionDrug(this.getInteractionDrug().toArray(new Drug[this.getInteractionDrug().size()]));
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
   
   public Interaction withId(int value)
   {
      setId(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getId());
      result.append(" ").append(this.getInteraction());
      return result.substring(1);
   }


   
   //==========================================================================
   
   public static final String PROPERTY_INTERACTION = "interaction";
   
   private String interaction;

   public String getInteraction()
   {
      return this.interaction;
   }
   
   public void setInteraction(String value)
   {
      if ( ! EntityUtil.stringEquals(this.interaction, value)) {
      
         String oldValue = this.interaction;
         this.interaction = value;
         this.firePropertyChange(PROPERTY_INTERACTION, oldValue, value);
      }
   }
   
   public Interaction withInteraction(String value)
   {
      setInteraction(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       many
    * Interaction ----------------------------------- Drug
    *              interaction                   drug
    * </pre>
    * actual drug origin
    */
   
   public static final String PROPERTY_DRUG = "drug";

   @ManyToMany(cascade=CascadeType.ALL)  
   @JoinTable(name="drug_interaction", joinColumns=@JoinColumn(name="idinteraction"), inverseJoinColumns=@JoinColumn(name="iddrug"))
   private Set<Drug> drug = null;

   public Set<Drug> getDrug()
   {
      if (this.drug == null)
      {
         return DrugSet.EMPTY_SET;
      }
   
      return this.drug;
   }

   public Interaction withDrug(Drug... value)
   {
      if(value==null){
         return this;
      }
      for (Drug item : value)
      {
         if (item != null)
         {
            if (this.drug == null)
            {
               this.drug = new DrugSet();
            }
            
            boolean changed = this.drug.add (item);

            if (changed)
            {
               item.withInteraction(this);
               firePropertyChange(PROPERTY_DRUG, null, item);
            }
         }
      }
      return this;
   } 

   public Interaction withoutDrug(Drug... value)
   {
      for (Drug item : value)
      {
         if ((this.drug != null) && (item != null))
         {
            if (this.drug.remove(item))
            {
               item.withoutInteraction(this);
               firePropertyChange(PROPERTY_DRUG, item, null);
            }
         }
      }
      return this;
   }

   public Drug createDrug()
   {
      Drug value = new Drug();
      withDrug(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       many
    * Interaction ----------------------------------- Drug
    *              interaction                   interactionDrug
    * </pre>
    */
   
   public static final String PROPERTY_INTERACTIONDRUG = "interactionDrug";

   @ManyToMany(cascade=CascadeType.ALL)  
   @JoinTable(name="interaction_drug", joinColumns=@JoinColumn(name="idinteraction"), inverseJoinColumns=@JoinColumn(name="iddrug"))
   private Set<Drug> interactionDrug = null;

   public Set<Drug> getInteractionDrug()
   {
      if (this.interactionDrug == null)
      {
         return DrugSet.EMPTY_SET;
      }
   
      return this.interactionDrug;
   }

   public Interaction withInteractionDrug(Drug... value)
   {
      if(value==null){
         return this;
      }
      for (Drug item : value)
      {
         if (item != null)
         {
            if (this.interactionDrug == null)
            {
               this.interactionDrug = new DrugSet();
            }
            
            boolean changed = this.interactionDrug.add (item);

            if (changed)
            {
               item.withInteraction(this);
               firePropertyChange(PROPERTY_INTERACTIONDRUG, null, item);
            }
         }
      }
      return this;
   } 

   public Interaction withoutInteractionDrug(Drug... value)
   {
      for (Drug item : value)
      {
         if ((this.interactionDrug != null) && (item != null))
         {
            if (this.interactionDrug.remove(item))
            {
               item.withoutInteraction(this);
               firePropertyChange(PROPERTY_INTERACTIONDRUG, item, null);
            }
         }
      }
      return this;
   }

   public Drug createInteractionDrug()
   {
      Drug value = new Drug();
      withInteractionDrug(value);
      return value;
   } 
}
