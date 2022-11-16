package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.BookRepository;
import com.demo.exception.BookNotFound;
import com.demo.model.Book;
import com.demo.service.BookService;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200/")
public class BookController {
	@Autowired
	BookService service;//= new BookService();
	@Autowired
	BookRepository repo;
	@PostMapping("add")
	public Book addBook(@RequestBody Book b) throws Exception {
		System.out.println("book from angular" + b);
		return service.addBook(b);
		 // "success";
	//	return repo.save(b);
	}
	
	@GetMapping("books")
	public List<Book> getAllBooks()
	{
		return service.getAllBooks();
		}
	@GetMapping("book/{id}")
	public Book getBookById(@PathVariable long id) {
		return service.getBookById(id);
	}
	
	@PutMapping("update/{id}")
	public Book updateBook(@RequestBody Book b,@PathVariable long id)
	{
		return service.updateBook(b,id);
		}
	@DeleteMapping("delete/{id}")
	public long deleteBook(@PathVariable long id)   
	{
		return service.deleteBook(id);
	}
}
