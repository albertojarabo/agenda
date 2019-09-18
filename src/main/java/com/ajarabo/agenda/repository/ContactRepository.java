package com.ajarabo.agenda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ajarabo.agenda.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{
}
