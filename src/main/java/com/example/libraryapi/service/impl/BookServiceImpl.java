package com.example.libraryapi.service.impl;

import org.springframework.stereotype.Service;

import com.example.libraryapi.model.entity.Book;
import com.example.libraryapi.model.repository.BookRepository;
import com.example.libraryapi.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository repository;
	
	
	public BookServiceImpl(BookRepository repository) {
		
		this.repository = repository;
	}


	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return repository.save(book);
	}

}
