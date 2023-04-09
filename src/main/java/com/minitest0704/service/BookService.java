package com.minitest0704.service;

import com.minitest0704.model.Book;
import com.minitest0704.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository repository;

    @Override
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Book saveBooks(Book book) {
        return repository.save(book);
    }

    @Override
    public void deleteBooks(Long id) {
        repository.deleteById(id);
    }
}
