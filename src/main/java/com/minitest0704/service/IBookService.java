package com.minitest0704.service;

import com.minitest0704.model.Book;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> getBooks(String name, String author,Long minPrice,Long maxPrice);
    Optional<Book> getById(Long id);
    Book saveBooks(Book book);
    void deleteBooks(Long id);
}
