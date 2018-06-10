package com.rosh.akar.spring5webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosh.akar.spring5webapp.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
