package com.brw.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "rw_user_bookmarked_listing")
@Inheritance(strategy = InheritanceType.JOINED)
public class BookMarks implements Serializable {

	private static final long serialVersionUID = 5968256649563934335L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
		
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "property_details_id")
	private int propertyDetailsId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPropertyDetailsId() {
		return propertyDetailsId;
	}

	public void setPropertyDetailsId(int propertyDetailsId) {
		this.propertyDetailsId = propertyDetailsId;
	}
	
	
	

}