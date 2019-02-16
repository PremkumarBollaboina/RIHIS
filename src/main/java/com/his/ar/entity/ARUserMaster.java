package com.his.ar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.his.util.CustomeGenerator;

import lombok.Data;
/**
 * this is used for mapping in AR_USER_MASTER
 * @author Nitish
 *
 */

@Entity
@Table(name = "APR__USER_MASTER")
@Data
public class ARUserMaster {
	@Id 
	 @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="APR_SEQ") 
	 @GenericGenerator(name="APR_SEQ",strategy="com.his.util.CustomeGenerator",
	 parameters= {
			 @Parameter(name=CustomeGenerator.INCREMENT_PARAM,value="1"),
			 @Parameter(name=CustomeGenerator.VALUE_PREFIX,value="APR"),
			 @Parameter(name=CustomeGenerator.NUMBER_FORMAT,value="100%d")
	 }
	 ) 
	/* @GeneratedValue(generator="mygen") 
	 @GenericGenerator(name="mygen",strategy="com.his.util.MyGenerator") */
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
 
	@Column(name = "SUR_NAME")
	private String surName;
	
	@Column(name = "USER_EMAIL")
	private String email;

	@Column(name = "USER_PHNO")
	private String phno;

	@Column(name = "USER_SSN")
	private String ssn;

	@Column(name = "USER_DOB")
	private String dob;


}
