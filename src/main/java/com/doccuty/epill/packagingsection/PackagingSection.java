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

package com.doccuty.epill.packagingsection;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.beans.PropertyChangeListener;
import com.doccuty.epill.model.PackagingTopic;
import de.uniks.networkparser.EntityUtil;

import com.doccuty.epill.model.util.ItemInvocationSet;
import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.iteminvocation.ItemInvocation;


@Entity
@Table(name = "packaging_section")
public class PackagingSection implements SendableEntity {

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
		setDrug(null);
		withoutClicks(this.getClicks().toArray(new ItemInvocation[this.getClicks().size()]));
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

	public PackagingSection withId(long value) {
		setId(value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append(" ").append(this.getId());
		result.append(" ").append(this.getText());
		return result.substring(1);
	}

	// ==========================================================================

	public static final String PROPERTY_STATE = "state";

	private int state;
	
	public int getState()
	{
	   return this.state;
	}
	
	public void setState(int value)
	{
	   if (this.state != value) {
	   
	      int oldValue = this.state;
	      this.state = value;
	      this.firePropertyChange(PROPERTY_STATE, oldValue, value);
	   }
	}
	
	public PackagingSection withState(int value)
	{
	   setState(value);
	   return this;
	}
	
	
	// ==========================================================================

	public static final String PROPERTY_ISTAILORED = "isTailored";

	@Transient
	private boolean isTailored = false;
	
	public boolean getIsTailored()
	{
	   return this.isTailored;
	}
	
	public void setIsTailored(boolean value)
	{
	   if (this.isTailored != value) {
	   
	      boolean oldValue = this.isTailored;
	      this.isTailored = value;
	      this.firePropertyChange(PROPERTY_ISTAILORED, oldValue, value);
	   }
	}
	
	public PackagingSection withIsTailored(boolean value)
	{
	   setIsTailored(value);
	   return this;
	}

	// ==========================================================================

	public static final String PROPERTY_TOPIC = "topic";

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "idpackaging_topic")
	private PackagingTopic topic;

	public PackagingTopic getTopic()
   {
      return this.topic;
   }

	public void setTopic(PackagingTopic value)
   {
      if (this.topic != value) {
      
         PackagingTopic oldValue = this.topic;
         this.topic = value;
         this.firePropertyChange(PROPERTY_TOPIC, oldValue, value);
      }
   }

	public PackagingSection withTopic(PackagingTopic value)
   {
      setTopic(value);
      return this;
   }

	// ==========================================================================

	public static final String PROPERTY_TEXT = "text";

	@Column(name="text", columnDefinition="TEXT")
	private String text;

	public String getText()
   {
      return this.text;
   }

	public void setText(String value)
   {
      if ( ! EntityUtil.stringEquals(this.text, value)) {
      
         String oldValue = this.text;
         this.text = value;
         this.firePropertyChange(PROPERTY_TEXT, oldValue, value);
      }
   }

	public PackagingSection withText(String value)
   {
      setText(value);
      return this;
   }

	/********************************************************************
    * <pre>
    *              many                       one
    * PackagingSection ----------------------------------- Drug
    *              packagingSection                   drug
    * </pre>
    */
   
   public static final String PROPERTY_DRUG = "drug";

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "iddrug")
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
            oldValue.withoutPackagingSection(this);
         }
         
         this.drug = value;
         
         if (value != null)
         {
            value.withPackagingSection(this);
         }
         
         firePropertyChange(PROPERTY_DRUG, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

	public PackagingSection withDrug(Drug value)
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
    *              one                       many
    * PackagingSection ----------------------------------- ItemInvocation
    *              packagingSection                   clicks
    * </pre>
    */
   
   public static final String PROPERTY_CLICKS = "clicks";

	@OneToMany(cascade=CascadeType.ALL, mappedBy="packagingSection")
   private Set<ItemInvocation> clicks = null;

	public Set<ItemInvocation> getClicks()
   {
      if (this.clicks == null)
      {
         return ItemInvocationSet.EMPTY_SET;
      }
   
      return this.clicks;
   }

	public PackagingSection withClicks(ItemInvocation... value) {
		if (value == null) {
			return this;
		}
		for (ItemInvocation item : value) {
			if (item != null) {
				if (this.clicks == null) {
					this.clicks = new ItemInvocationSet();
				}

				boolean changed = this.clicks.add(item);

				if (changed) {
					item.withPackagingSection(this);
					firePropertyChange(PROPERTY_CLICKS, null, item);
				}
			}
		}
		return this;
	}

	public PackagingSection withoutClicks(ItemInvocation... value) {
		for (ItemInvocation item : value) {
			if ((this.clicks != null) && (item != null)) {
				if (this.clicks.remove(item)) {
					item.setPackagingSection(null);
					firePropertyChange(PROPERTY_CLICKS, item, null);
				}
			}
		}
		return this;
	}

	public ItemInvocation createClicks() {
		ItemInvocation value = new ItemInvocation();
		withClicks(value);
		return value;
	}
}
