package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersonService {

    @PersistenceContext
    private EntityManager em;

    public Person addPerson(String firstName, String lastName){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        em.persist(person);
        return person;
    }
}
