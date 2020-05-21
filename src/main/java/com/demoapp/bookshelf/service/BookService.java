package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.model.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class BookService {
    public List<Book> getListOfBooks() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(Objects.requireNonNull(getClass().getClassLoader()
                            .getResourceAsStream("getBooks.json")),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
