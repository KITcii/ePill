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

package com.doccuty.epill.user;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import de.uniks.networkparser.EntityUtil;
import de.uniks.networkparser.interfaces.SendableEntity;

@Entity
@Table(name = "user_simple")
@Inheritance(strategy = InheritanceType.JOINED)
public class SimpleUser implements SendableEntity {

	private static final String PROPERTY_PREFERREDFONTSIZE_DEFAULT = "defaultFontSize";

	public SimpleUser() {

	}

	public SimpleUser(long id, String firstname, String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public SimpleUser(long id, String firstname, String lastname, String username, String password, String salt,
			String preferredFontSize, int levelOfDetail, boolean redGreenColorblind, int weight) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.preferredFontSize = preferredFontSize;
		this.levelOfDetail = levelOfDetail;
		this.redGreenColorblind = redGreenColorblind;
		this.weight = weight;
	}

	public SimpleUser(User user) {
		this.id = user.getId();
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.dateOfBirth = user.getDateOfBirth();
		this.redGreenColorblind = user.getRedGreenColorblind();

		this.dateOfRegistration = user.getDateOfRegistration();

		this.username = user.getUsername();
		this.salt = user.getSalt();
		this.password = user.getPassword();

		this.email = user.getEmail();

		this.preferredFontSize = user.getPreferredFontSize();
		this.levelOfDetail = user.getLevelOfDetail();
		this.weight = user.getWeight();
		this.breakfastTime = user.getBreakfastTime();
		this.dinnerTime = user.getDinnerTime();
		this.lunchTime = user.getLunchTime();
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

	@Override
	public boolean addPropertyChangeListener(PropertyChangeListener listener) {
		if (listeners == null) {
			listeners = new PropertyChangeSupport(this);
		}
		listeners.addPropertyChangeListener(listener);
		return true;
	}

	@Override
	public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		if (listeners == null) {
			listeners = new PropertyChangeSupport(this);
		}
		listeners.addPropertyChangeListener(propertyName, listener);
		return true;
	}

	@Override
	public boolean removePropertyChangeListener(PropertyChangeListener listener) {
		if (listeners == null) {
			listeners.removePropertyChangeListener(listener);
		}
		listeners.removePropertyChangeListener(listener);
		return true;
	}

	@Override
	public boolean removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		if (listeners != null) {
			listeners.removePropertyChangeListener(propertyName, listener);
		}
		return true;
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
			this.id = value;
		}
	}

	public SimpleUser withId(long value) {
		setId(value);
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();

		result.append(" ").append(this.getId());
		result.append(" ").append(this.getFirstname());
		result.append(" ").append(this.getLastname());
		result.append(" ").append(this.getUsername());
		result.append(" ").append(this.getPassword());
		result.append(" ").append(this.getEmail());
		result.append(" ").append(this.getPreferredFontSize());
		result.append(" ").append(this.getWeight());
		return result.substring(1);
	}

	// ==========================================================================

	public static final String PROPERTY_FIRSTNAME = "firstname";

	private String firstname;

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String value) {
		if (!EntityUtil.stringEquals(this.firstname, value)) {
			this.firstname = value;
		}
	}

	public SimpleUser withFirstname(String value) {
		setFirstname(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_LASTNAME = "lastname";

	private String lastname;

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String value) {
		if (!EntityUtil.stringEquals(this.lastname, value)) {

			this.lastname = value;
		}
	}

	public SimpleUser withLastname(String value) {
		setLastname(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_USERNAME = "username";

	@Column(unique = true)
	private String username;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String value) {
		if (!EntityUtil.stringEquals(this.username, value)) {
			this.username = value;
		}
	}

	public SimpleUser withUsername(String value) {
		setUsername(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_PASSWORD = "password";

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String value) {
		if (!EntityUtil.stringEquals(this.password, value)) {
			this.password = value;
		}
	}

	public SimpleUser withPassword(String value) {
		setPassword(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_SALT = "salt";

	@JsonIgnore
	private String salt;

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String value) {
		if (!EntityUtil.stringEquals(this.salt, value)) {

			final String oldValue = this.salt;
			this.salt = value;
			this.firePropertyChange(PROPERTY_SALT, oldValue, value);
		}
	}

	public SimpleUser withSalt(String value) {
		setSalt(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_EMAIL = "email";

	@Column
	private String email;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String value) {
		if (!EntityUtil.stringEquals(this.email, value)) {
			this.email = value;
		}
	}

	public SimpleUser withEmail(String value) {
		setEmail(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_DATEOFBIRTH = "dateOfBirth";

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date value) {
		if (this.dateOfBirth != value) {
			this.dateOfBirth = value;
		}
	}

	public SimpleUser withDateOfBirth(Date value) {
		setDateOfBirth(value);
		return this;
	}

	@JsonIgnore
	public int getAge() {

		if (this.dateOfBirth == null) {
			return 0;
		}

		final Calendar cal = Calendar.getInstance();
		cal.setTime(this.dateOfBirth);

		final LocalDate b = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH));
		final long age = b.until(LocalDate.now(), ChronoUnit.YEARS);

		return (int) age;
	}

	// ==========================================================================

	public static final String PROPERTY_PREFERREDFONTSIZE = "preferredFontSize";

	private String preferredFontSize = PROPERTY_PREFERREDFONTSIZE_DEFAULT;

	public String getPreferredFontSize() {
		return this.preferredFontSize;
	}

	public void setPreferredFontSize(String value) {
		if (this.preferredFontSize != value) {
			this.preferredFontSize = value;
		}
	}

	public SimpleUser withPreferredFontSize(String value) {
		setPreferredFontSize(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_LEVELOFDETAIL = "levelOfDetail";

	private int levelOfDetail;

	public int getLevelOfDetail() {
		return this.levelOfDetail;
	}

	public void setLevelOfDetail(int value) {
		if (this.levelOfDetail != value) {
			final int oldValue = this.levelOfDetail;
			this.levelOfDetail = value;
			this.firePropertyChange(PROPERTY_LEVELOFDETAIL, oldValue, value);
		}
	}

	public SimpleUser withLevelOfDetail(int value) {
		setLevelOfDetail(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_DATEOFREGISTRATION = "dateOfRegistration";

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date dateOfRegistration;

	public Date getDateOfRegistration() {
		return this.dateOfRegistration;
	}

	public void setDateOfRegistration(Date value) {
		if (this.dateOfRegistration != value) {
			this.dateOfRegistration = value;
		}
	}

	public SimpleUser withDateOfRegistration(Date value) {
		setDateOfRegistration(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_REDGREENCOLORBLIND = "redGreenColorblind";

	private boolean redGreenColorblind = false;

	public boolean getRedGreenColorblind() {
		return this.redGreenColorblind;
	}

	public void setRedGreenColorblind(boolean value) {
		if (this.redGreenColorblind != value) {
			final boolean oldValue = this.redGreenColorblind;
			this.redGreenColorblind = value;
			this.firePropertyChange(PROPERTY_REDGREENCOLORBLIND, oldValue, value);
		}
	}

	public SimpleUser withRedGreenColorblind(boolean value) {
		setRedGreenColorblind(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_WEIGHT = "weight";

	@Column(nullable = false, columnDefinition = "int default 0")
	private int weight;

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int value) {
		if (this.weight != value) {
			final int oldValue = this.weight;
			this.weight = value;
			this.firePropertyChange(PROPERTY_WEIGHT, oldValue, value);
		}
	}

	public SimpleUser withWeight(int value) {
		setWeight(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_BREAKFAST_TIME = "breakfasttime";

	@Column(name = "breakfast_time")
	private int breakfastTime;

	public int getBreakfastTime() {
		return this.breakfastTime;
	}

	public void setBreakfastTime(int value) {
		if (this.breakfastTime != value) {
			final int oldValue = this.breakfastTime;
			this.breakfastTime = value;
			this.firePropertyChange(PROPERTY_BREAKFAST_TIME, oldValue, value);
		}
	}

	public SimpleUser withBreakfastTime(int value) {
		setBreakfastTime(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_LUNCH_TIME = "lunchtime";

	@Column(name = "lunch_time")
	private int lunchTime;

	public int getLunchTime() {
		return this.lunchTime;
	}

	public void setLunchTime(int value) {
		if (this.lunchTime != value) {
			final int oldValue = this.lunchTime;
			this.lunchTime = value;
			this.firePropertyChange(PROPERTY_LUNCH_TIME, oldValue, value);
		}
	}

	public SimpleUser withLunchTime(int value) {
		setLunchTime(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_DINNER_TIME = "dinnertime";

	@Column(name = "dinner_time")
	private int dinnerTime;

	public int getDinnerTime() {
		return this.dinnerTime;
	}

	public void setDinnerTime(int value) {
		if (this.dinnerTime != value) {
			final int oldValue = this.dinnerTime;
			this.dinnerTime = value;
			this.firePropertyChange(PROPERTY_DINNER_TIME, oldValue, value);
		}
	}

	public SimpleUser withDinnerTime(int value) {
		setDinnerTime(value);
		return this;
	}

}
