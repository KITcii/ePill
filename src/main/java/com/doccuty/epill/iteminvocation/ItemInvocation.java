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
   
package com.doccuty.epill.iteminvocation;

import de.uniks.networkparser.interfaces.SendableEntity;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import java.beans.PropertyChangeListener;

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.packagingsection.PackagingSection;
import com.doccuty.epill.user.User;


@Entity
@Table(name="item_invocation")
   public  class ItemInvocation implements SendableEntity
{

	
	public ItemInvocation() {
		
	}
	
	public ItemInvocation (Drug drug, Date timestamp, long cntr) {
		this.drug	= drug;
		this.timestamp	= timestamp;
		this.counter	= cntr;
	}
	
   
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
      setDrug(null);
      setPackagingSection(null);
      setUser(null);
      firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_ID = "id";

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private long id;
   
   public long getId()
   {
      return this.id;
   }
   
   public void setId(long value)
   {
      if (this.id != value) {
      
         double oldValue = this.id;
         this.id = value;
         this.firePropertyChange(PROPERTY_ID, oldValue, value);
      }
   }
   
   public ItemInvocation withId(long value)
   {
      setId(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getId()).append(" ").append(this.getDrug());
      return result.substring(1);
   }


   
   //==========================================================================
   
   public static final String PROPERTY_TIMESTAMP = "timestamp";
   
   @CreationTimestamp
   @Column(nullable = false, updatable = false)
   private Date timestamp;

   public Date getTimestamp()
   {
      return this.timestamp;
   }
   
   public void setTimestamp(Date value)
   {
      if (this.timestamp != value) {
      
         Date oldValue = this.timestamp;
         this.timestamp = value;
         this.firePropertyChange(PROPERTY_TIMESTAMP, oldValue, value);
      }
   }
   
   public ItemInvocation withTimestamp(Date value)
   {
      setTimestamp(value);
      return this;
   } 
   
   
   //==========================================================================
   
   public static final String PROPERTY_COUNTER = "counter";
   
   @Transient
   private long counter;

   public long getCounter()
   {
      return this.counter;
   }
   
   public void setCounter(long value)
   {
      if (this.counter != value) {
      
         long oldValue = this.counter;
         this.counter = value;
         this.firePropertyChange(PROPERTY_COUNTER, oldValue, value);
      }
   }
   
   public ItemInvocation withCounter(long value)
   {
      setCounter(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       one
    * ItemInvocation ----------------------------------- Drug
    *              clicks                   drug
    * </pre>
    */
   
   public static final String PROPERTY_DRUG = "drug";

   @ManyToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="iddrug")
   private Drug drug = null;

   public Drug getDrug()
   {
      return this.drug;
   }

   public boolean setDrug(Drug value)
   {
      boolean changed = false;
      
      if (this.drug != value)
      {
         Drug oldValue = this.drug;
         
         if (this.drug != null)
         {
            this.drug = null;
            oldValue.withoutClicks(this);
         }
         
         this.drug = value;
         
         if (value != null)
         {
            value.withClicks(this);
         }
         
         firePropertyChange(PROPERTY_DRUG, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public ItemInvocation withDrug(Drug value)
   {
      setDrug(value);
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
    *              many                       one
    * ItemInvocation ----------------------------------- PackagingSection
    *              clicks                   packagingSection
    * </pre>
    */
   
   public static final String PROPERTY_PACKAGINGSECTION = "packagingSection";

   @ManyToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="idpackaging_section")
   private PackagingSection packagingSection = null;
   
   public PackagingSection getPackagingSection()
   {
      return this.packagingSection;
   }

   public boolean setPackagingSection(PackagingSection value)
   {
      boolean changed = false;
      
      if (this.packagingSection != value)
      {
         PackagingSection oldValue = this.packagingSection;
         
         if (this.packagingSection != null)
         {
            this.packagingSection = null;
            oldValue.withoutClicks(this);
         }
         
         this.packagingSection = value;
         
         if (value != null)
         {
            value.withClicks(this);
         }
         
         firePropertyChange(PROPERTY_PACKAGINGSECTION, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public ItemInvocation withPackagingSection(PackagingSection value)
   {
      setPackagingSection(value);
      return this;
   } 

   public PackagingSection createPackagingSection()
   {
      PackagingSection value = new PackagingSection();
      withPackagingSection(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       one
    * ItemInvocation ----------------------------------- User
    *              clicks                   user
    * </pre>
    */
   
   public static final String PROPERTY_USER = "user";

   @ManyToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="iduser")
   private User user = null;

   public User getUser()
   {
      return this.user;
   }

   public boolean setUser(User value)
   {
      boolean changed = false;
      
      if (this.user != value)
      {
         User oldValue = this.user;
         
         if (this.user != null)
         {
            this.user = null;
            oldValue.withoutClicks(this);
         }
         
         this.user = value;
         
         if (value != null)
         {
            value.withClicks(this);
         }
         
         firePropertyChange(PROPERTY_USER, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public ItemInvocation withUser(User value)
   {
      setUser(value);
      return this;
   } 

   public User createUser()
   {
      User value = new User();
      withUser(value);
      return value;
   } 
      
}
