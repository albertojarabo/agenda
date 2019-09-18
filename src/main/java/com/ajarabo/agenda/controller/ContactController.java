package com.ajarabo.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajarabo.agenda.exception.InvalidValueException;
import com.ajarabo.agenda.mapper.ContactMapper;
import com.ajarabo.agenda.model.Contact;
import com.ajarabo.agenda.model.dto.ContactDTO;
import com.ajarabo.agenda.model.dto.ContactInListDTO;
import com.ajarabo.agenda.service.ContactService;
import com.ajarabo.agenda.utils.Verify;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ContactController {

	 @Autowired
	 private ContactService contactService;
	 
	 @GetMapping("/contacts")
	 public List<Contact> allContacts() {
		 log.info("running contactController.allContacts()");
		 return contactService.findAll();
	 }
	 
	 @GetMapping("/contacts/list")
	 public List<ContactInListDTO> allContactsForListing() {
		 log.info("running contactController.allContactsForListing()");
		 return contactService.findAllForListing();
	 }

	 @GetMapping("/contacts/{id}")
	 public Contact getContact(@PathVariable String id) {
		 log.info("running contactService.findById(" + id + ")");
		 
		 Contact verifyContact = contactService.findById(id);
		 
		 Verify.isNotNull(verifyContact);
		 
		 return verifyContact;
	 }
	 
	 @PostMapping("/contacts")
	 public String createContact(@RequestBody ContactDTO contactDTO) throws JsonProcessingException {
		 log.info("running contactController.createContact(ContactInfo)");
		 log.debug("--> running contactController.createContact(" + contactDTO.toString() + ")");
		 String resultJson = "";
		 
		 Contact contact = ContactMapper.toContact(contactDTO);
		 contact = contactService.save(contact);
		 resultJson = new ObjectMapper().writeValueAsString(contact);
		 
		 return resultJson;
	 }
	 
	 @PutMapping("/contacts/{id}")
	 public String updateContact(@PathVariable String id, @RequestBody ContactDTO contactDTO) throws JsonProcessingException {
		 log.info("running contactController.updateContact(" + id + ", ContactInfo)");
		 log.debug("--> running contactController.updateContact(" + id + ", " + contactDTO.toString() + ")");
		 
		 String resultJson = "";

		 Contact verifyContact = contactService.findById(id);
		 
		 Verify.isNotNull(verifyContact);
		 
		 contactDTO.setId(id);
		 Contact contact = ContactMapper.toContact(contactDTO);
		 
		 contact = contactService.save(contact);
		 resultJson = new ObjectMapper().writeValueAsString(contact);
		 
		 return resultJson;
	 }
	 
	 @DeleteMapping("/contacts/{id}")
	 public void deleteContact(@PathVariable String id) {
		 log.info("running contactController.deleteContact(" + id + ")");
		 try {
			 contactService.delete(id);
		 } catch (Exception e) {
			 throw new InvalidValueException();
		 }
	 }

	 
}
