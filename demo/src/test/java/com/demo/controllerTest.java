package com.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;


import com.demo.controller.BookController;
import com.demo.controller.HelloController;
import com.demo.dao.BookRepository;
import com.demo.model.Book;
import com.demo.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BookController.class)

class controllerTest {

	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private BookService service;
	
	@MockBean 
	private BookRepository repo;
	
	ObjectMapper om = new ObjectMapper();
	@Test
	public void getbooks_test() throws Exception {
		List<Book> books = new ArrayList<>();
		
		books.add(new Book(1,"bhoo","sou",10000));
		books.add(new Book(2,"test1","test",20000));
		
		Mockito.when(service.getAllBooks()).thenReturn(books);
		
		String url="/books";
		
		mockmvc.perform(MockMvcRequestBuilders.get(url)).andExpect(status().isOk());
	}
	
	@Test
	public void getBookbyId_test() throws Exception {
		long bookid = 1;
		Book book = new Book(1,"bhoo","sou",1000);
		when(service.getBookById(bookid)).thenReturn(book);
		String url="/book/1";
		
		mockmvc.perform(MockMvcRequestBuilders.get(url)).andExpect(status().isOk());
	
	}
	
	@Test
	public void addBook_test() throws Exception {
		long id = 1;
		Book book = new Book(1,"bhoo in adding","sou",1000);
		when(service.addBook(book)).thenReturn(book);
		String url="/add";
		
		
		 mockmvc.perform(MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(om.writeValueAsString(book)))
		 		.andExpect(status().isOk());
		 System.out.println("book name"+ book.getName());
	}
	
	@Test 
	public void deletebook_test() throws Exception {
		long id = 1;
		Book book = new Book(1,"bhoo","sou",1000);
		when(service.deleteBook(id)).thenReturn(id);
		String url="/delete/1";
		mockmvc.perform(MockMvcRequestBuilders.delete(url)).andExpect(status().isOk());
		
	}
	
	@Test
	public void updateBook_test() throws Exception {
		long id = 1;
		Book book = new Book(1,"bhoo in updating","sou",1000);
		when(service.updateBook(book,id)).thenReturn(book);
		String url="/update/1";
		 mockmvc.perform(MockMvcRequestBuilders
                .put(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(om.writeValueAsString(book)))
		 		.andExpect(status().isOk());
		 System.out.println("book name"+ book.getName());
	}
	
}