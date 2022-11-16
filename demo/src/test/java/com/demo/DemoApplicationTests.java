////package com.example.demo;
////
////import java.util.ArrayList;
////import java.util.List;
////
////import java.util.Arrays;
////
////import org.assertj.core.error.ShouldHaveSameSizeAs;
////import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
////import org.junit.Before;
////import org.junit.jupiter.api.Test;
////import org.junit.platform.engine.SelectorResolutionResult.Status;
////import org.junit.runner.RunWith;
////import org.mockito.InjectMocks;
////import org.mockito.Mock;
////import org.mockito.Mockito;
////import org.mockito.MockitoAnnotations;
////import org.mockito.junit.MockitoJUnitRunner;
////import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.http.MediaType;
////import org.springframework.test.web.servlet.MockMvc;
////import org.springframework.test.web.servlet.MockMvcBuilder;
////import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
////import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
////import org.springframework.test.web.servlet.setup.MockMvcBuilders;
////
////import com.demo.controller.BookController;
////import com.demo.dao.BookRepository;
////import com.demo.model.Book;
////import com.fasterxml.jackson.databind.ObjectMapper;
////import com.fasterxml.jackson.databind.ObjectWriter;
////import com.jayway.jsonpath.JsonPath;
////
////
//////@SpringBootTest
////@RunWith(MockitoJUnitRunner.class)
////class DemoApplicationTests {
////
////	private MockMvc mockmvc;
////	
////	ObjectMapper objectmapper = new ObjectMapper();
////	ObjectWriter objectwriter = objectmapper.writer();
////	
////	@Mock
////	private BookRepository repository;
////	
////	@InjectMocks
////	private BookController controller;
////	
////	Book b1 = new Book(21,"test11","test11",100);
////	Book b2 = new Book(22,"test12","test12",200);
////	Book b3 = new Book(23,"test13","test13",300);
////	
////	@Before
////	public void setup() {
////		MockitoAnnotations.initMocks(this);
////		this.mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
////		
////	}
////	
////	@Test
////	public void get_books_mock() throws Exception{
////		List<Book> outputbooks = new ArrayList<>(Arrays.asList(b1,b2,b3));
////		Mockito.when(repository.findAll()).thenReturn(outputbooks);
////		mockmvc.perform(MockMvcRequestBuilders.get("/books")
////				.contentType(MediaType.APPLICATION_JSON))
////		.andExpect(MockMvcResultMatchers.status().isOk());
////		//.andExpect(MockMvcResultMatchers.jsonPath("$[2].name", is("test12")));
////	}
//////	@Test
//////	void contextLoads() {
//////	}
////
////}

package com.demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.demo.dao.BookRepository;
import com.demo.model.Book;
import com.demo.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
	
@Autowired
public BookService service;

@MockBean
public BookRepository repository;


@Test
public void getBooksTest() {
	when(repository.findAll()).thenReturn(Stream.of(new Book(21,"test11","test11",100)
			,new Book(22,"test11","test11",100))
			.collect(Collectors.toList()));
	assertEquals(2, service.getAllBooks().size());
//	assertEquals(2,2);
}



}



//package com.demo;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class DemoApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}