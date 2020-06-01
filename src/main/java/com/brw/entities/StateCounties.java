package com.brw.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.InheritanceType;

@Entity
@DynamicUpdate
@Table(name = "t_brw_state_counties")
@Inheritance(strategy = InheritanceType.JOINED)
public class StateCounties implements Serializable {
	
	private static final long serialVersionUID = -8504035975938683238L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "state_code")
	private String stateCode;
	
	@Column(name = "state_name")
	private String stateName;
	
	@Column(name = "county_name")
	private String countyName;

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}