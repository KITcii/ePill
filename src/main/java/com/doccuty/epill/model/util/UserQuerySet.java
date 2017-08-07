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

package com.doccuty.epill.model.util;

import java.util.HashSet;

import com.doccuty.epill.iteminvocation.ItemInvocation;
import com.doccuty.epill.model.UserQuery;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import java.util.Date;

import com.doccuty.epill.model.util.UserSet;
import com.doccuty.epill.user.User;

public class UserQuerySet extends HashSet<UserQuery> {
	protected Class<?> getTypClass() {
		return UserQuery.class;
	}

	public UserQuerySet() {
		// empty
	}

	public UserQuerySet(UserQuery... objects) {
		for (UserQuery obj : objects) {
			this.add(obj);
		}
	}

	public UserQuerySet(Collection<UserQuery> objects) {
		this.addAll(objects);
	}

	public static final UserQuerySet EMPTY_SET = new UserQuerySet();

	public String getEntryType() {
		return "com.doccuty.epill.model.UserQuery";
	}

	@SuppressWarnings("unchecked")
	public UserQuerySet with(Object value) {
		if (value == null) {
			return this;
		} else if (value instanceof java.util.Collection) {
			this.addAll((Collection<UserQuery>) value);
		} else if (value != null) {
			this.add((UserQuery) value);
		}

		return this;
	}

	public UserQuerySet without(UserQuery value) {
		this.remove(value);
		return this;
	}

	/**
	 * Loop through the current set of UserQuery objects and collect a list of
	 * the id attribute values.
	 * 
	 * @return List of double objects reachable via id attribute
	 */
	public NumberList getId() {
		NumberList result = new NumberList();

		for (UserQuery obj : this) {
			result.add(obj.getId());
		}

		return result;
	}

	/**
	 * Loop through the current set of UserQuery objects and collect those
	 * UserQuery objects where the id attribute matches the parameter value.
	 * 
	 * @param value
	 *            Search value
	 * 
	 * @return Subset of UserQuery objects that match the parameter
	 */
	public UserQuerySet filterId(double value) {
		UserQuerySet result = new UserQuerySet();

		for (UserQuery obj : this) {
			if (value == obj.getId()) {
				result.add(obj);
			}
		}

		return result;
	}

	/**
	 * Loop through the current set of UserQuery objects and collect those
	 * UserQuery objects where the id attribute is between lower and upper.
	 * 
	 * @param lower
	 *            Lower bound
	 * @param upper
	 *            Upper bound
	 * 
	 * @return Subset of UserQuery objects that match the parameter
	 */
	public UserQuerySet filterId(double lower, double upper) {
		UserQuerySet result = new UserQuerySet();

		for (UserQuery obj : this) {
			if (lower <= obj.getId() && obj.getId() <= upper) {
				result.add(obj);
			}
		}

		return result;
	}

	/**
	 * Loop through the current set of UserQuery objects and assign value to the
	 * id attribute of each of it.
	 * 
	 * @param value
	 *            New attribute value
	 * 
	 * @return Current set of UserQuery objects now with new attribute values.
	 */
	public UserQuerySet withId(long value) {
		for (UserQuery obj : this) {
			obj.setId(value);
		}

		return this;
	}

	/**
	 * Loop through the current set of UserQuery objects and collect a list of
	 * the timestamp attribute values.
	 * 
	 * @return List of java.util.Date objects reachable via timestamp attribute
	 */
	public ObjectSet getTimestamp() {
		ObjectSet result = new ObjectSet();

		for (UserQuery obj : this) {
			result.add(obj.getTimestamp());
		}

		return result;
	}

	/**
	 * Loop through the current set of UserQuery objects and collect those
	 * UserQuery objects where the timestamp attribute matches the parameter
	 * value.
	 * 
	 * @param value
	 *            Search value
	 * 
	 * @return Subset of UserQuery objects that match the parameter
	 */
	public UserQuerySet filterTimestamp(Date value) {
		UserQuerySet result = new UserQuerySet();

		for (UserQuery obj : this) {
			if (value == obj.getTimestamp()) {
				result.add(obj);
			}
		}

		return result;
	}

	/**
	 * Loop through the current set of UserQuery objects and assign value to the
	 * timestamp attribute of each of it.
	 * 
	 * @param value
	 *            New attribute value
	 * 
	 * @return Current set of UserQuery objects now with new attribute values.
	 */
	public UserQuerySet withTimestamp(Date value) {
		for (UserQuery obj : this) {
			obj.setTimestamp(value);
		}

		return this;
	}

	/**
	 * Loop through the current set of UserQuery objects and collect a list of
	 * the message attribute values.
	 * 
	 * @return List of String objects reachable via message attribute
	 */
	public ObjectSet getMessage() {
		ObjectSet result = new ObjectSet();

		for (UserQuery obj : this) {
			result.add(obj.getMessage());
		}

		return result;
	}

	/**
	 * Loop through the current set of UserQuery objects and collect those
	 * UserQuery objects where the message attribute matches the parameter
	 * value.
	 * 
	 * @param value
	 *            Search value
	 * 
	 * @return Subset of UserQuery objects that match the parameter
	 */
	public UserQuerySet filterMessage(String value) {
		UserQuerySet result = new UserQuerySet();

		for (UserQuery obj : this) {
			if (value.equals(obj.getMessage())) {
				result.add(obj);
			}
		}

		return result;
	}

	/**
	 * Loop through the current set of UserQuery objects and collect those
	 * UserQuery objects where the message attribute is between lower and upper.
	 * 
	 * @param lower
	 *            Lower bound
	 * @param upper
	 *            Upper bound
	 * 
	 * @return Subset of UserQuery objects that match the parameter
	 */
	public UserQuerySet filterMessage(String lower, String upper) {
		UserQuerySet result = new UserQuerySet();

		for (UserQuery obj : this) {
			if (lower.compareTo(obj.getMessage()) <= 0 && obj.getMessage().compareTo(upper) <= 0) {
				result.add(obj);
			}
		}

		return result;
	}

	/**
	 * Loop through the current set of UserQuery objects and assign value to the
	 * message attribute of each of it.
	 * 
	 * @param value
	 *            New attribute value
	 * 
	 * @return Current set of UserQuery objects now with new attribute values.
	 */
	public UserQuerySet withMessage(String value) {
		for (UserQuery obj : this) {
			obj.setMessage(value);
		}

		return this;
	}

	/**
	 * Loop through the current set of UserQuery objects and collect a set of
	 * the User objects reached via user.
	 * 
	 * @return Set of User objects reachable via user
	 */
	public UserSet getUser() {
		UserSet result = new UserSet();

		for (UserQuery obj : this) {
			result.with(obj.getUser());
		}

		return result;
	}

	/**
	 * Loop through the current set of UserQuery objects and collect all
	 * contained objects with reference user pointing to the object passed as
	 * parameter.
	 * 
	 * @param value
	 *            The object required as user neighbor of the collected results.
	 * 
	 * @return Set of User objects referring to value via user
	 */
	public UserQuerySet filterUser(Object value) {
		ObjectSet neighbors = new ObjectSet();

		if (value instanceof Collection) {
			neighbors.addAll((Collection<?>) value);
		} else {
			neighbors.add(value);
		}

		UserQuerySet answer = new UserQuerySet();

		for (UserQuery obj : this) {
			if (neighbors.contains(obj.getUser()) || (neighbors.isEmpty() && obj.getUser() == null)) {
				answer.add(obj);
			}
		}

		return answer;
	}

	/**
	 * Loop through current set of ModelType objects and attach the UserQuery
	 * object passed as parameter to the User attribute of each of it.
	 * 
	 * @return The original set of ModelType objects now with the new neighbor
	 *         attached to their User attributes.
	 */
	public UserQuerySet withUser(User value) {
		for (UserQuery obj : this) {
			obj.withUser(value);
		}

		return this;
	}
}
