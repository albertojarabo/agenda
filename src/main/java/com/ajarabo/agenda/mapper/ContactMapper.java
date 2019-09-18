package com.ajarabo.agenda.mapper;

import com.ajarabo.agenda.model.Contact;
import com.ajarabo.agenda.model.Contact.ContactBuilder;
import com.ajarabo.agenda.model.dto.ContactDTO;
import com.ajarabo.agenda.model.dto.ContactInListDTO;

public class ContactMapper {

	public static ContactInListDTO toContactInListDTO(Contact contact) {
		ContactInListDTO contactInListDTO = null;

		if (contact != null) {
			contactInListDTO = new ContactInListDTO();
			contactInListDTO.setId(contact.getId());
			contactInListDTO.setFirstName(contact.getFirstName());
			contactInListDTO.setLastName(contact.getLastName());
		}

		return contactInListDTO;
	}
	
	public static Contact toContact(ContactDTO contactDTO) {
		
		 ContactBuilder contactBuilder = Contact.builder()
				 .firstName(contactDTO.getFirstName())
				 .lastName(contactDTO.getLastName())
				 .email(contactDTO.getEmail())
				 .birthDate(contactDTO.getBirthDate())
				 .phoneNumber(contactDTO.getPhoneNumber())
				 .notes(contactDTO.getNotes());
		 
		 if (contactDTO.getId() != null) {
			 contactBuilder.id(Long.valueOf(contactDTO.getId()));
		 }
		 
		 return contactBuilder.build();
	}
	
	private ContactMapper() {}
}
