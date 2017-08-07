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
   
package com.doccuty.epill.gender;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.beans.PropertyChangeListener;
import de.uniks.networkparser.EntityUtil;

import com.doccuty.epill.disease.Disease;
import com.doccuty.epill.model.util.DiseaseSet;
import com.doccuty.epill.model.util.UserSet;
import com.doccuty.epill.user.User;
   /**
    * 
    * @see <a href='../../../../../../../src/test/java/com/doccuty/epill/model/SDMLib/ModelCreator.java'>ModelCreator.java</a>
 */
@Entity
@Table(name="gender")
   public  class Gender implements SendableEntity
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
      withoutUser(this.getUser().toArray(new User[this.getUser().size()]));
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
   
   public Gender withId(int value)
   {
      setId(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getId());
      result.append(" ").append(this.getGender());
      return result.substring(1);
   }


   
   //==========================================================================
   
   public static final String PROPERTY_GENDER = "gender";
   
   @Column(unique=true)
   private String gender;

   public String getGender()
   {
      return this.gender;
   }
   
   public void setGender(String value)
   {
      if ( ! EntityUtil.stringEquals(this.gender, value)) {
      
         String oldValue = this.gender;
         this.gender = value;
         this.firePropertyChange(PROPERTY_GENDER, oldValue, value);
      }
   }
   
   public Gender withGender(String value)
   {
      setGender(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       many
    * Gender ----------------------------------- User
    *              gender                   user
    * </pre>
    */
   
   public static final String PROPERTY_USER = "user";

   @OneToMany(mappedBy="gender", cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST})
   private Set<User> user = null;

   public Set<User> getUser()
   {
      if (this.user == null)
      {
         return UserSet.EMPTY_SET;
      }
   
      return this.user;
   }

   public Gender withUser(User... value)
   {
      if(value==null){
         return this;
      }
      for (User item : value)
      {
         if (item != null)
         {
            if (this.user == null)
            {
               this.user = new UserSet();
            }
            
            boolean changed = this.user.add (item);

            if (changed)
            {
               item.withGender(this);
               firePropertyChange(PROPERTY_USER, null, item);
            }
         }
      }
      return this;
   } 

   public Gender withoutUser(User... value)
   {
      for (User item : value)
      {
         if ((this.user != null) && (item != null))
         {
            if (this.user.remove(item))
            {
               item.setGender(null);
               firePropertyChange(PROPERTY_USER, item, null);
            }
         }
      }
      return this;
   }

   public User createUser()
   {
      User value = new User();
      withUser(value);
      return value;
   } 
   
   /********************************************************************
    * <pre>
    *              many                       many
    * Gender ----------------------------------- Disease
    *              gender                   disease
    * </pre>
    */
   
   public static final String PROPERTY_DISEASE = "disease";

   @ManyToMany(cascade=CascadeType.ALL)  
   @JoinTable(name="gender_disease", joinColumns=@JoinColumn(name="idgender"), inverseJoinColumns=@JoinColumn(name="iddisease"))
   private Set<Disease> disease = null;
   
   public Set<Disease> getDisease()
   {
      if (this.disease == null)
      {
         return DiseaseSet.EMPTY_SET;
      }
   
      return this.disease;
   }

   public Gender withDisease(Disease... value)
   {
      if(value==null){
         return this;
      }
      for (Disease item : value)
      {
         if (item != null)
         {
            if (this.disease == null)
            {
               this.disease = new DiseaseSet();
            }
            
            boolean changed = this.disease.add (item);

            if (changed)
            {
               item.withGender(this);
               firePropertyChange(PROPERTY_DISEASE, null, item);
            }
         }
      }
      return this;
   } 

   public Gender withoutDisease(Disease... value)
   {
      for (Disease item : value)
      {
         if ((this.disease != null) && (item != null))
         {
            if (this.disease.remove(item))
            {
               item.withoutGender(this);
               firePropertyChange(PROPERTY_DISEASE, item, null);
            }
         }
      }
      return this;
   }

   public Disease createDisease()
   {
      Disease value = new Disease();
      withDisease(value);
      return value;
   }
}
