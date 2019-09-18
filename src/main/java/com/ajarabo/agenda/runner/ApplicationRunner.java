package com.ajarabo.agenda.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ajarabo.agenda.model.Contact;
import com.ajarabo.agenda.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApplicationRunner implements CommandLineRunner {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Initializing contacts");
		
		Contact c1 = Contact.builder()
				.firstName("Alberto")
				.lastName("Jarabo")
				.email("albertojarabo@myemailaddress.com")
				.birthDate(new Date())
				.notes("cool guy").build();
		
		contactRepository.save(c1);
				
		
	}

}
