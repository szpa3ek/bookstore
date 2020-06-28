package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.persistence.model.Shelf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class ShelfService {

    @PersistenceContext
    private EntityManager em;

    public List<Shelf> findAll() {
        TypedQuery<Shelf> query_find_all_shelves = em.createNamedQuery("query_find_all_shelves", Shelf.class);
        return query_find_all_shelves.getResultList();
    }
}
