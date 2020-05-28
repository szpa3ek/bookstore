package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.model.Shelf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@Transactional
public class ShelfService {

    @PersistenceContext
    private EntityManager em;

    public List<Shelf> createListOfShelves(String name){
        Shelf shelf = new Shelf();
        shelf.setName(name);
        em.persist(shelf);
        return Collections.singletonList(shelf);
    }

    public List<Shelf> listAll() {
        Shelf shelf1 =new Shelf();
        shelf1.setName("THRILLER");
        Shelf shelf2 = new Shelf();
        shelf2.setName("SCIENCE FICTION");
        Shelf shelf3 =new Shelf();
        shelf3.setName("FANTASY");
        // em.persist(shelves);
        return Arrays.asList(shelf1,shelf2,shelf3);
    }

    public Shelf updateShelfName(Shelf shelf) {
        Shelf shelfToBeUpdated = em.merge(shelf);
        shelfToBeUpdated.setName(shelfToBeUpdated.getName());
        return shelf;
    }
}
