package com.demoapp.bookshelf.repository;

import com.demoapp.bookshelf.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByLastName(String lastName);
}
