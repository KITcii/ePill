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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.doccuty.epill.model.util.DrugSet;
import com.doccuty.epill.model.util.UserSet;

import java.beans.PropertyChangeListener;
import de.uniks.networkparser.EntityUtil;

/**
 * 
 * @see <a href=
 *      '../../../../../../../src/test/java/com/doccuty/epill/model/SDMLib/ModelCreator.java'>ModelCreator.java</a>
 */
@Entity
@Table(name = "answer")
public class Answer implements SendableEntity {

	
	public Answer() {
		
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

	public Answer withId(long value) {
		setId(value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append(" ").append(this.getId());
		result.append(" ").append(this.getAnswer());
		return result.substring(1);
	}

	// ==========================================================================

	public static final String PROPERTY_ANSWER = "answer";

	private int answer;

	public int getAnswer() {
		return this.answer;
	}

	public void setAnswer(int value) {
		if (this.answer == value) {
			int oldValue = this.answer;
			this.answer = value;
			this.firePropertyChange(PROPERTY_ANSWER, oldValue, value);
		}
	}

	public Answer withAnswer(int value) {
		setAnswer(value);
		return this;
	}
	 

	   /********************************************************************
	    * <pre>
	    *              many                       one
	    * Answer ----------------------------------- Question
	    *              answer                   question
	    * </pre>
	    */
	   
	   public static final String PROPERTY_QUESTION = "question";

	   @ManyToOne(cascade=CascadeType.ALL)
	   @JoinColumn(name="idquestion")
	   private Question question = null;

	   public Question getQuestion()
	   {
	      return this.question;
	   }

	   public boolean setQuestion(Question value)
	   {
	      boolean changed = false;
	      
	      if (this.question != value)
	      {
	         Question oldValue = this.question;
	         
	         if (this.question != null)
	         {
	            this.question = null;
	            oldValue.withoutAnswer(this);
	         }
	         
	         this.question = value;
	         
	         if (value != null)
	         {
	            value.withAnswer(this);
	         }
	         
	         firePropertyChange(PROPERTY_QUESTION, oldValue, value);
	         changed = true;
	      }
	      
	      return changed;
	   }

	   public Answer withQuestion(Question value)
	   {
	      setQuestion(value);
	      return this;
	   } 

	   public Question createQuestion()
	   {
	      Question value = new Question();
	      withQuestion(value);
	      return value;
	   } 
}
