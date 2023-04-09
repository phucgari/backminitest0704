package com.minitest0704.service;

import com.minitest0704.model.Book;
import org.springframework.data.jpa.domain.Specification;


public class BookSpecifications {
    public Specification<Book> bookWithNameLike(String name){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"),"%"+name+"%"));
    }
    public Specification<Book> bookWithAuthorLike(String author){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("author"),"%"+author+"%"));
    }
    public Specification<Book> bookWithPriceBetween(Long min,Long max){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("price"),min,max));
    }
}
