package com.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//Mockito Test cases


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.dao.BookRepository;
import com.demo.model.Book;
import com.demo.service.BookService;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@SpringBootTest(classes= {serviceTest.class})
@RunWith(MockitoJUnitRunner.class)

class serviceTest {

	
	@Mock
	BookRepository bookrepo;
	
	@InjectMocks
	BookService bookservice;
	
	public List<Book> myBooks;
	
	public int x=0;

	@Test
	void test() {
		//fail("Not yet implemented");
		final String str="hello";
		assertEquals("hello", str);
	}
	
	@Test
	public void getbooks_test() {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(1,"bhoo","sou",10000));
		books.add(new Book(2,"test1","test",20000));
	//	System.out.println("books.....  "+books);
		when(bookrepo.findAll()).thenReturn(books);
		bookservice.getAllBooks();
		assertEquals(2,bookservice.getAllBooks().size());
		
		
	}

	
	@Test
	public void getBookbyId_test() {
		long bookid = 1;
		Book employee = new Book(1,"bhoo","sou",1000);
		when(bookrepo.findById(bookid)).thenReturn(Optional.of(employee));
		Book emp =bookservice.getBookById(bookid);
		assertEquals(bookid, emp.getId());
	}
	
	@Test
	public void createBook_test() throws Exception {
		long id = 1;
		Book book = new Book(1,"bhoo","sou",1000);
		when(bookrepo.existsById(id)).thenReturn(false);

		when(bookrepo.save(book)).thenReturn(book);
		assertEquals(book, bookservice.addBook(book));
	}

	@Test
	public void updateBook_test() {
		long bookid = 1;
		Book book = new Book(1,"bhoo","sou",1000);
		when(bookrepo.findById(bookid)).thenReturn(Optional.of(book));
		assertEquals(book, bookservice.updateBook(book,bookid));

	}
	
	@Test
	public void deleteBook_Test() {
		Book book = new Book(1,"bhoo","sou",1000);
		when(bookrepo.findById(book.getId())).thenReturn(Optional.of(book));

		bookservice.deleteBook(book.getId());
		verify(bookrepo,times(1)).deleteById(book.getId());
	}
}

