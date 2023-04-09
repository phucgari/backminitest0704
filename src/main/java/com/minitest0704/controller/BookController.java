package com.minitest0704.controller;

import com.minitest0704.model.Book;
import com.minitest0704.service.IBookService;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    IBookService service;
    @GetMapping("list")
    public ResponseEntity<List<Book>> getBooks(
            @RequestParam Optional<String> nameSearch,
            @RequestParam Optional<String> authorSearch,
            @RequestParam Optional<Long> minPrice,
            @RequestParam Optional<Long> maxPrice){
        String name = nameSearch.orElse("");
        String author = authorSearch.orElse("");
        Long minPrice1 = minPrice.orElse(0L);
        Long maxPrice1 = maxPrice.orElse(9999999999999999L);
        return new ResponseEntity<>(service.getBooks(name, author, minPrice1, maxPrice1), HttpStatus.OK);
    }
    @PostMapping("save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return new ResponseEntity<>(service.saveBooks(book),HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBook (@PathVariable Long id){
        Optional<Book> book=service.getById(id);
        if(book.isEmpty())return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        service.deleteBooks(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}