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
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import java.beans.PropertyChangeListener;
import de.uniks.networkparser.EntityUtil;
import com.doccuty.epill.model.util.UserSet;
import com.doccuty.epill.user.User;
   /**
    * 
    * @see <a href='../../../../../../../src/test/java/com/doccuty/epill/model/SDMLib/ModelCreator.java'>ModelCreator.java</a>
 */
@Entity
@Table(name="user_query")
   public  class UserQuery implements SendableEntity
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
      
    	  long oldValue = this.id;
         this.id = value;
         this.firePropertyChange(PROPERTY_ID, oldValue, value);
      }
   }
   
   public UserQuery withId(long value)
   {
      setId(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getId());
      result.append(" ").append(this.getMessage());
      return result.substring(1);
   }


   
   //==========================================================================
   
   public static final String PROPERTY_TIMESTAMP = "timestamp";
   
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
   
   public UserQuery withTimestamp(Date value)
   {
      setTimestamp(value);
      return this;
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_MESSAGE = "message";
   
   private String message;

   public String getMessage()
   {
      return this.message;
   }
   
   public void setMessage(String value)
   {
      if ( ! EntityUtil.stringEquals(this.message, value)) {
      
         String oldValue = this.message;
         this.message = value;
         this.firePropertyChange(PROPERTY_MESSAGE, oldValue, value);
      }
   }
   
   public UserQuery withMessage(String value)
   {
      setMessage(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       one
    * UserQuery ----------------------------------- User
    *              query                   user
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
            oldValue.withoutQuery(this);
         }
         
         this.user = value;
         
         if (value != null)
         {
            value.withQuery(this);
         }
         
         firePropertyChange(PROPERTY_USER, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public UserQuery withUser(User value)
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
