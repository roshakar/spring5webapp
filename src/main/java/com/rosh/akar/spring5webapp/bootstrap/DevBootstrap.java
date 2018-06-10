package com.rosh.akar.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.rosh.akar.spring5webapp.model.Author;
import com.rosh.akar.spring5webapp.model.Book;
import com.rosh.akar.spring5webapp.model.Publisher;
import com.rosh.akar.spring5webapp.repositories.AuthorRepository;
import com.rosh.akar.spring5webapp.repositories.BookRepository;
import com.rosh.akar.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		this.initData();		
	}
	
	private void initData() {
		
		Publisher publisher1 = new Publisher();
		publisher1.setName("Harper Collins");

		Publisher publisher2 = new Publisher();
		publisher2.setName("Worx");

		publisherRepository.save(publisher1);
		publisherRepository.save(publisher2);

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", publisher1);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEjb = new Book("J2EE Development without EJB", "23444", publisher2);
		rod.getBooks().add(noEjb);
		
		authorRepository.save(rod);
		bookRepository.save(noEjb);
	}
}
