package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.persistence.model.Person;
import com.demoapp.bookshelf.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person addPerson(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        repository.save(person);
        return person;
    }

    public List findAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {
        return repository.findById(id).get();
    }
}
