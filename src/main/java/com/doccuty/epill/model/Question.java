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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.doccuty.epill.model.util.AnswerSet;
import com.doccuty.epill.model.util.UserSet;
import com.doccuty.epill.user.User;

import java.beans.PropertyChangeListener;
import de.uniks.networkparser.EntityUtil;

/**
 * 
 * @see <a href=
 *      '../../../../../../../src/test/java/com/doccuty/epill/model/SDMLib/ModelCreator.java'>ModelCreator.java</a>
 */
@Entity
@Table(name = "question")
public class Question implements SendableEntity {

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

	public Question withId(int value) {
		setId(value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append(" ").append(this.getId());
		result.append(" ").append(this.getQuestion());
		return result.substring(1);
	}

	// ==========================================================================

	public static final String PROPERTY_QUESTION = "question";

	private String question;

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String value) {
		if (!EntityUtil.stringEquals(this.question, value)) {

			String oldValue = this.question;
			this.question = value;
			this.firePropertyChange(PROPERTY_QUESTION, oldValue, value);
		}
	}

	public Question withQuestion(String value) {
		setQuestion(value);
		return this;
	}

	// ==========================================================================

	public static final String PROPERTY_ADDRESS = "address";

	private String address;

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String value) {
		if (!EntityUtil.stringEquals(this.address, value)) {

			String oldValue = this.address;
			this.address = value;
			this.firePropertyChange(PROPERTY_ADDRESS, oldValue, value);
		}
	}

	public Question withAddress(String value) {
		setAddress(value);
		return this;
	}

	/********************************************************************
	 * <pre>
	 *              one                       many
	 * Question ----------------------------------- Answer
	 *            question                   answer
	 * </pre>
	 */

	public static final String PROPERTY_ANSWER = "answer";

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private Set<Answer> answer = null;

	public Set<Answer> getAnswer() {
		if (this.answer == null) {
			return AnswerSet.EMPTY_SET;
		}

		return this.answer;
	}

	public Question withAnswer(Answer... value) {
		if (value == null) {
			return this;
		}
		for (Answer item : value) {
			if (item != null) {
				if (this.answer == null) {
					this.answer = new AnswerSet();
				}

				boolean changed = this.answer.add(item);

				if (changed) {
					item.withQuestion(this);
					firePropertyChange(PROPERTY_ANSWER, null, item);
				}
			}
		}
		return this;
	}

	public Question withoutAnswer(Answer... value) {
		for (Answer item : value) {
			if ((this.answer != null) && (item != null)) {
				if (this.answer.remove(item)) {
					item.setQuestion(null);
					firePropertyChange(PROPERTY_ANSWER, item, null);
				}
			}
		}
		return this;
	}

	public Answer createAnswer() {
		Answer value = new Answer();
		withAnswer(value);
		return value;
	}
}
