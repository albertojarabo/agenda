package com.ajarabo.agenda.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Contact")
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Contact {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private String firstName;

	@Basic(optional = false)
	@Column(nullable = false)
	private String lastName;
	
	@Basic(optional = true)
	@Column(nullable = true)
	private String email;

	@Basic(optional = true)
	@Column(nullable = true)
	private String phoneNumber;
	
	@Basic(optional = true)
	@Column(nullable = true)
	private Date birthDate;

	@Basic(optional = true)
	@Column(nullable = true)
	private String notes;
	
}	
