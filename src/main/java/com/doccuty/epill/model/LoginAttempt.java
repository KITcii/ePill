package com.doccuty.epill.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="login_attempt")
public class LoginAttempt {

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

	
	
	@Temporal(TemporalType.DATE)
	private Date timestamp;
	
	public Date getTimestamp() {
		return this.timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public LoginAttempt withTimestamp(Date timestamp) {
		this.setTimestamp(timestamp);
		return this;
	}
	
	
	
	private boolean success;
	
	public boolean getSuccess() {
		return this.success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public LoginAttempt withSuccess(boolean success) {
		this.setSuccess(success);
		return this;
	}
	
	
	
	private long iduser;

	public long getUserId() {
		return this.id;
	}

	public void setUserId(long value) {
		if (this.id != value) {
			this.id = value;
		}
	}
	
	public LoginAttempt withUserId(long value) {
		this.setUserId(value);
		return this;
	}
}
