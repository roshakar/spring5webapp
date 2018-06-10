package com.rosh.akar.spring5webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosh.akar.spring5webapp.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
