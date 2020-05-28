package com.demoapp.bookshelf.repository;

import com.demoapp.bookshelf.persistence.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository {

    Person getAuthorByFirstName(String firstName);

    Person getAuthorByLastName(String lastName);

    Person saveAuthor(Person p);

    void deleteBook(Person p);
}
