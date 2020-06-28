package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.persistence.model.CD;
import com.demoapp.bookshelf.persistence.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Slf4j
@Transactional
public class CDService {
    @PersistenceContext
    private EntityManager entityManager;

    public CD insert(String title, List<String> tracks, Person person) {
        CD cd = new CD();
        cd.setTitle(title);
        cd.setTracks(tracks);
        cd.setAuthors(List.of(person));
        entityManager.persist(cd);
        return cd;
    }

    public List<CD> findAll() {
        TypedQuery<CD> query_find_all_cds = entityManager.createNamedQuery("query_find_all_cds", CD.class);
        return query_find_all_cds.getResultList();
    }
}
