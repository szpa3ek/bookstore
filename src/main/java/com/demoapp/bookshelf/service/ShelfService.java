package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.model.Shelf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@Transactional
public class ShelfService {

    @PersistenceContext
    private EntityManager em;

    public List<Shelf> listAll() {
        Shelf shelf = new Shelf();
        shelf.setName("BOOK");
        return Collections.singletonList(shelf);
    }
}
