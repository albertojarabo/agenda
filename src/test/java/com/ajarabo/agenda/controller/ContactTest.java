package com.ajarabo.agenda.controller;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ajarabo.agenda.model.Contact;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactTest {

	@Test
	public void testContactBuilder() {
		final Long expectedId = new Random().nextLong();
		final Contact fromBuilder = Contact.builder()
				.id(expectedId)
				.firstName("Alberto")
				.lastName("Jarabo")
				.email("albertojarabo@myemailaddress.com")
				.notes("cool guy").build();
		assertEquals(expectedId,fromBuilder.getId());
	}
}
