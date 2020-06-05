package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.persistence.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
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

    public List findAll() {
        Query query = em.createNamedQuery("query_find_all_authors", Person.class);
        return query.getResultList();
    }
}
