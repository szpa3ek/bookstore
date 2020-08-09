package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.persistence.model.CD;
import com.demoapp.bookshelf.persistence.model.Person;
import com.demoapp.bookshelf.repository.CDRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    CDRepository repository;

    public CD insert(String title, List<String> tracks, Person person) {
        CD cd = new CD();
        cd.setTitle(title);
        cd.setTracks(tracks);
        cd.setAuthors(List.of(person));
        repository.save(cd);
        return cd;
    }

    public List<CD> findAll() {
        return repository.findAll();
    }
}
