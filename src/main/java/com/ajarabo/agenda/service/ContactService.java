package com.ajarabo.agenda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajarabo.agenda.mapper.ContactMapper;
import com.ajarabo.agenda.model.Contact;
import com.ajarabo.agenda.model.dto.ContactDTO;
import com.ajarabo.agenda.model.dto.ContactInListDTO;
import com.ajarabo.agenda.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
//	public ContactService(ContactRepository contactRepository) {
//		this.contactRepository = contactRepository;
//	}
	
	public ContactService() {
	}
	
	public List<Contact> findAll() {
		
		List<Contact> contactList = new ArrayList<Contact>();
		Iterable<Contact> iterable = contactRepository.findAll();
		iterable.forEach(x -> contactList.add(x));
		
		return contactList;
	}
	
	public List<ContactInListDTO> findAllForListing() {
		
		List<ContactInListDTO> contactList = new ArrayList<ContactInListDTO>();
		Iterable<Contact> iterable = contactRepository.findAll();
		iterable.forEach(x -> 
			
		contactList.add(ContactMapper.toContactInListDTO(x)));
		
		return contactList;
	}
	
	public Contact findById(String id) {
		Long longId = Long.valueOf(id);
		Optional<Contact> optional = contactRepository.findById(longId);
		return optional.isPresent() ? optional.get(): null;
	}
	
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public Contact update(ContactDTO contactDTO, Contact contact) {
		Contact updatedContact = ContactMapper.toContact(contactDTO);
		updatedContact.setId(contact.getId());
		
		return contactRepository.save(updatedContact);
	}
	
	public void delete(String id) {
		Long longId = Long.valueOf(id);
		contactRepository.deleteById(longId);
	}
}
