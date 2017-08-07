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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.beans.PropertyChangeListener;
import de.uniks.networkparser.EntityUtil;

import com.doccuty.epill.model.util.PackagingSectionSet;
import com.doccuty.epill.model.util.UserSet;
import com.doccuty.epill.packagingsection.PackagingSection;
import com.doccuty.epill.user.User;


@Entity
@Table(name = "packaging_topic")
public class PackagingTopic implements SendableEntity {

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
		withoutUser(this.getUser().toArray(new User[this.getUser().size()]));
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

	public PackagingTopic withId(long value) {
		setId(value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append(" ").append(this.getId());
		result.append(" ").append(this.getTitle());
		return result.substring(1);
	}

	// ==========================================================================

	public static final String PROPERTY_TITLE = "title";

	@Column(unique = true)
	private String title;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String value) {
		if (!EntityUtil.stringEquals(this.title, value)) {

			String oldValue = this.title;
			this.title = value;
			this.firePropertyChange(PROPERTY_TITLE, oldValue, value);
		}
	}

	public PackagingTopic withTitle(String value) {
		setTitle(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_ORDERNUMBER = "orderNumber";

	private int orderNumber;

	public int getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(int value) {
		if (this.orderNumber != value) {

			int oldValue = this.orderNumber;
			this.orderNumber = value;
			this.firePropertyChange(PROPERTY_ORDERNUMBER, oldValue, value);
		}
	}

	public PackagingTopic withOrderNumber(int value) {
		setOrderNumber(value);
		return this;
	}

	/********************************************************************
	 * <pre>
	 *              many                       many
	 * PackagingTopic ----------------------------------- User
	 *              preferredPackagingTopic                   user
	 * </pre>
	 */

	public static final String PROPERTY_USER = "user";

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "preferredPackagingTopic")
	private Set<User> user = null;

	public Set<User> getUser() {
		if (this.user == null) {
			return UserSet.EMPTY_SET;
		}

		return this.user;
	}

	public PackagingTopic withUser(User... value) {
		if (value == null) {
			return this;
		}
		for (User item : value) {
			if (item != null) {
				if (this.user == null) {
					this.user = new UserSet();
				}

				boolean changed = this.user.add(item);

				if (changed) {
					item.withPreferredPackagingTopic(this);
					firePropertyChange(PROPERTY_USER, null, item);
				}
			}
		}
		return this;
	}

	public PackagingTopic withoutUser(User... value) {
		for (User item : value) {
			if ((this.user != null) && (item != null)) {
				if (this.user.remove(item)) {
					item.withoutPreferredPackagingTopic(this);
					firePropertyChange(PROPERTY_USER, item, null);
				}
			}
		}
		return this;
	}

	public User createUser() {
		User value = new User();
		withUser(value);
		return value;
	}

	/********************************************************************
	 * <pre>
	 *              one                       many
	 * PackagingSection ----------------------------------- ItemInvocation
	 *              packagingSection                   clicks
	 * </pre>
	 */

	public static final String PROPERTY_PACKAGINGSECTION = "packagingSection";

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "topic")
	private Set<PackagingSection> packagingSection = null;

	public Set<PackagingSection> getPackagingSection() {
		if (this.packagingSection == null) {
			return PackagingSectionSet.EMPTY_SET;
		}

		return this.packagingSection;
	}

	public PackagingTopic withPackagingSection(PackagingSection... value) {
		if (value == null) {
			return this;
		}
		for (PackagingSection item : value) {
			if (item != null) {
				if (this.packagingSection == null) {
					this.packagingSection = new PackagingSectionSet();
				}

				boolean changed = this.packagingSection.add(item);

				if (changed) {
					item.withTopic(this);
					firePropertyChange(PROPERTY_PACKAGINGSECTION, null, item);
				}
			}
		}
		return this;
	}

	public PackagingTopic withoutClicks(PackagingSection... value) {
		for (PackagingSection item : value) {
			if ((this.packagingSection != null) && (item != null)) {
				if (this.packagingSection.remove(item)) {
					item.setTopic(null);
					firePropertyChange(PROPERTY_PACKAGINGSECTION, item, null);
				}
			}
		}
		return this;
	}

	public PackagingSection createClicks() {
		PackagingSection value = new PackagingSection();
		withPackagingSection(value);
		return value;
	}
}
