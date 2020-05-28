package com.demoapp.bookshelf.repository.implementation;

import com.demoapp.bookshelf.persistence.model.Person;
import com.demoapp.bookshelf.repository.AuthorsRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AuthorsRepositoryImpl implements AuthorsRepository {
    private EntityManager em;

    public AuthorsRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Person getAuthorByFirstName(String firstName) {
        TypedQuery<Person> authorTypedQuery = em.createQuery("SELECT p FROM Person p WHERE p.firstName = :firstName", Person.class);
        authorTypedQuery.setParameter("firstName", firstName);
        return authorTypedQuery.getSingleResult();
    }

    @Override
    public Person getAuthorByLastName(String lastName) {
        TypedQuery<Person> authorTypedQuery = em.createQuery("SELECT p FROM Person p WHERE p.lastName = :lastName", Person.class);
        authorTypedQuery.setParameter("lastName", lastName);
        return authorTypedQuery.getSingleResult();
    }

    @Override
    public Person saveAuthor(Person person) {
        if (person.getId() == null) {
            em.persist(person);
        } else {
            person = em.merge(person);
        }
        return person;
    }

    @Override
    public void deleteBook(Person person) {
        if (em.contains(person)) {
            em.remove(person);
        } else {
            em.merge(person);
        }
    }
}
