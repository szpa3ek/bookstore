package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.persistence.model.Shelf;
import com.demoapp.bookshelf.repository.ShelfRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class ShelfService {

    @Autowired
    ShelfRepository repository;

    public List<Shelf> findAll() {
        return repository.findAll();
    }
}
