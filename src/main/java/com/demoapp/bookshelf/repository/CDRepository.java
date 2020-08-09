package com.demoapp.bookshelf.repository;

import com.demoapp.bookshelf.persistence.model.CD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CDRepository extends JpaRepository<CD,Long> {
    CD findByTitle(String title);
}
