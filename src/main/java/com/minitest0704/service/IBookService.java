package com.minitest0704.service;

import com.minitest0704.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> getBooks();
    Optional<Book> getById(Long id);
    Book saveBooks(Book book);
    void deleteBooks(Long id);
}
