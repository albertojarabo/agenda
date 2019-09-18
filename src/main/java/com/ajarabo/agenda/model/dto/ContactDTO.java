package com.ajarabo.agenda.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date birthDate;
	private String notes;
	
}	
