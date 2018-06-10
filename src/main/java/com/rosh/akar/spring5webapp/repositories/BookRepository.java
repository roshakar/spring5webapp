package com.rosh.akar.spring5webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosh.akar.spring5webapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
