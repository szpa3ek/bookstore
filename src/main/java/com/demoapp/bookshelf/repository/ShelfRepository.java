package com.demoapp.bookshelf.repository;

import com.demoapp.bookshelf.persistence.model.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf,Long> {

}
