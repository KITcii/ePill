/*
Copyright (c) 2017 mac
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.gender.Gender;
import com.doccuty.epill.model.util.DrugSet;
import com.doccuty.epill.model.util.GenderSet;
import com.doccuty.epill.model.util.UserSet;
import com.doccuty.epill.user.User;

import java.beans.PropertyChangeListener;
import de.uniks.networkparser.EntityUtil;


@Entity
@Table(name = "drug_feature")
public class DrugFeature implements SendableEntity {

	
	public DrugFeature() {
		
	}
	
	public DrugFeature(long id, String drugFeature){
		this.id = id;
		this.drugFeature = drugFeature;
	}
	
	
	// ==========================================================================

	protected PropertyChangeSupport listeners = null;

	public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		if (listeners != null) {
			listeners.firePropertyChange(propertyName, oldValue, newValue);
			return true;
		}
		return false;
	}

	public boolean addPropertyChangeListener(PropertyChangeListener listener) {
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

	public boolean removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		if (listeners != null) {
			listeners.removePropertyChangeListener(propertyName, listener);
		}
		return true;
	}

	// ==========================================================================

	public void removeYou() {
		firePropertyChange("REMOVE_YOU", this, null);
	}

	// ==========================================================================

	public static final String PROPERTY_ID = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public long getId() {
		return this.id;
	}

	public void setId(long value) {
		if (this.id != value) {

			long oldValue = this.id;
			this.id = value;
			this.firePropertyChange(PROPERTY_ID, oldValue, value);
		}
	}

	public DrugFeature withId(long value) {
		setId(value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append(" ").append(this.getId());
		result.append(" ").append(this.getDrugFeature());
		return result.substring(1);
	}

	// ==========================================================================

	public static final String PROPERTY_DRUGFEATURE = "drugFeature";

	private String drugFeature;

	public String getDrugFeature() {
		return this.drugFeature;
	}

	public void setDrugFeature(String value) {
		if (!EntityUtil.stringEquals(this.drugFeature, value)) {

			String oldValue = this.drugFeature;
			this.drugFeature = value;
			this.firePropertyChange(PROPERTY_DRUGFEATURE, oldValue, value);
		}
	}

	public DrugFeature withDrugFeature(String value) {
		setDrugFeature(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_MINAGE = "minAge";

	@Column(nullable=false, columnDefinition = "int default 0")
	private int minAge;

	public int getMinAge() {
		return this.minAge;
	}

	public void setMinAge(int value) {
		if (this.minAge != value) {
			int oldValue = this.minAge;
			this.minAge = value;
			this.firePropertyChange(PROPERTY_MINAGE, oldValue, value);
		}
	}

	public DrugFeature withMinAge(int value) {
		setMinAge(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_MAXAGE = "maxAge";

	@Column(nullable=false, columnDefinition = "int default 0")
	private int maxAge;

	public int getMaxAge() {
		return this.maxAge;
	}

	public void setMaxAge(int value) {
		if (this.maxAge != value) {
			int oldValue = this.maxAge;
			this.maxAge = value;
			this.firePropertyChange(PROPERTY_MAXAGE, oldValue, value);
		}
	}

	public DrugFeature withMaxAge(int value) {
		setMaxAge(value);
		return this;
	}
	
	
	
	   /********************************************************************
	    * <pre>
	    *              one                       many
	    * DrugFeature ----------------------------------- Drug
	    *     preferredDrugFeature                user
	    * </pre>
	    */
	   
	   public static final String PROPERTY_DRUG = "drug_feature";

	   @ManyToMany(cascade=CascadeType.ALL, mappedBy="drugFeature")
	   private Set<Drug> drug = null;
	   
	   public Set<Drug> getDrug()
	   {
	      if (this.drug == null)
	      {
	         return DrugSet.EMPTY_SET;
	      }
	   
	      return this.drug;
	   }

	   public DrugFeature withDrug(Drug... value)
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
	               item.withDrugFeature(this);
	               firePropertyChange(PROPERTY_DRUGFEATURE, null, item);
	            }
	         }
	      }
	      return this;
	   } 

	   public DrugFeature withoutDrug(Drug... value)
	   {
	      for (Drug item : value)
	      {
	         if ((this.drug != null) && (item != null))
	         {
	            if (this.drug.remove(item))
	            {
	               item.withoutDrugFeaturee(this);
	               firePropertyChange(PROPERTY_DRUGFEATURE, item, null);
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
	    *              one                       many
	    * DrugFeature ----------------------------------- User
	    *          preferredDrugFeature                   user
	    * </pre>
	    */
	   
	   public static final String PROPERTY_USER = "user";

	   @Column(nullable=true)
	   @ManyToMany(cascade=CascadeType.ALL, mappedBy="preferredDrugFeature")
	   private Set<User> user = null;
	   
	   public Set<User> getUser()
	   {
	      if (this.user == null)
	      {
	         return UserSet.EMPTY_SET;
	      }
	   
	      return this.user;
	   }

	   public DrugFeature withUser(User... value)
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
	               item.withPreferredDrugFeature(this);
	               firePropertyChange(PROPERTY_USER, null, item);
	            }
	         }
	      }
	      return this;
	   } 

	   public DrugFeature withoutUser(User... value)
	   {
	      for (User item : value)
	      {
	         if ((this.drug != null) && (item != null))
	         {
	            if (this.drug.remove(item))
	            {
	               item.withoutPreferredDrugFeature(this);
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
	    *              one                       many
	    * DrugFeature ----------------------------------- Gender
	    *          		*                	   gender
	    * </pre>
	    */
	   
	   public static final String PROPERTY_GENDER = "gender";

	   @OneToMany(cascade=CascadeType.ALL)
	   private Set<Gender> gender = null;
	   
	   public Set<Gender> getGender()
	   {
	      if (this.gender == null)
	      {
	         return GenderSet.EMPTY_SET;
	      }
	   
	      return this.gender;
	   }

	   public DrugFeature withGender(Gender... value)
	   {
	      if(value==null){
	         return this;
	      }
	      for (Gender item : value)
	      {
	         if (item != null)
	         {
	            if (this.gender == null)
	            {
	               this.gender = new GenderSet();
	            }
	            
	            boolean changed = this.gender.add (item);

	            if (changed)
	            {
	               firePropertyChange(PROPERTY_USER, null, item);
	            }
	         }
	      }
	      return this;
	   } 

	   public DrugFeature withoutGender(Gender... value)
	   {
	      for (Gender item : value)
	      {
	         if ((this.gender != null) && (item != null))
	         {
	            if (this.gender.remove(item))
	            {
	               firePropertyChange(PROPERTY_GENDER, item, null);
	            }
	         }
	      }
	      return this;
	   }

	   public Gender createGender()
	   {
		  Gender value = new Gender();
	      withGender(value);
	      return value;
	   } 
}
