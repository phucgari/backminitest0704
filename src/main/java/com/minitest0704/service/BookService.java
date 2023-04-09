package com.minitest0704.service;

import com.minitest0704.model.Book;
import com.minitest0704.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository repository;
    BookSpecifications specs=new BookSpecifications();

    @Override
    public List<Book> getBooks(String nameSearch, String authorSearch, Long minPrice, Long maxPrice) {
        Specification<Book> searchByName = specs.bookWithNameLike(nameSearch);
        Specification<Book> searchByAuthor = specs.bookWithAuthorLike(authorSearch);
        Specification<Book> searchByPrice = specs.bookWithPriceBetween(minPrice,maxPrice);
        return repository.findAll(searchByName.and(searchByAuthor).and(searchByPrice));
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
