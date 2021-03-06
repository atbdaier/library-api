package com.example.libraryapi.model.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.libraryapi.model.entity.Book;
import com.example.libraryapi.model.repository.BookRepository;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	BookRepository repository;
	
	@Test
	@DisplayName("Deve retornar true quando existir um livro na base com o isbn informado")
	public void returnTrueWhenIsbnExists() {
		//cenario
		String isbn = "123";
		Book book = Book.builder().title("Aventuras").author("Fulano").isbn("123").build();
		entityManager.persist(book);
		//execucao
		boolean exists = repository.existsByIsbn(isbn);
		//verificacao
		assertThat(exists).isTrue();		
				
	}

	@Test
	@DisplayName("Deve retornar false quando não existir um livro na base com o isbn informado")
	public void returnFalseWhenIsbnDoesntExists() {
		//cenario
		String isbn = "1234";
		//Book book = Book.builder().title("Aventuras").author("Fulano").isbn("123").build();
		//entityManager.persist(book);
		//execucao
		boolean exists = repository.existsByIsbn(isbn);
		//verificacao
		assertThat(exists).isFalse();		
				
	}
	
}
