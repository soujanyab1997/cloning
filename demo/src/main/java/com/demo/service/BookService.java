package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.BookRepository;
import com.demo.exception.BookNotFound;
import com.demo.model.Book;

@Service
public class BookService {

@Autowired
BookRepository repo;
 
public Book addBook(Book b) throws Exception 
{
	System.out.println("Heloooo");
//	if(repo.existsById(b.getId())) 
//	{ 
//		throw new Exception("Book already exists with this id"+b.getId());
//	}
	if(
		//	(b.getId()!=0)&&
			(!b.getName().isEmpty())&&(!b.getAuthor().isEmpty())&&(b.getPrice()!=0))
	{
	
		System.out.println(b.getName()+ " ");
	  return repo.save(b);
}
	
	throw new Exception("enter valid details");
	
 }
 
public List<Book> getAllBooks(){
	return repo.findAll();
}

public Book getBookById(long id) {
	return repo.findById(id).orElseThrow(()->
    new BookNotFound("Record Not Found,Book is Not Found with id: "+id+" ,Please provide the valid Id"));	
	
	//return repo.findById(id);
}
 
public Book updateBook(Book b,long id) { 
	Book book=repo.findById(id).orElseThrow(()->
    new BookNotFound("Record Not Found,Book is Not Found with id: "+id+" to Update,Please provide the valid Id"));	
	{
		System.out.println("book new "+book);
	if(b.getName()!=null)
	book.setName(b.getName());
	if(b.getAuthor()!=null)
	book.setAuthor(b.getAuthor());
	Book updatedbook= repo.save(book);
	return book;
}
}

public long deleteBook(long id) {
//	Book book1=repo.findById(id).get();
//	repo.delete(book1);
	repo.findById(id).orElseThrow(()->
    new BookNotFound("Record Not Found,Book is Not Found with id: "+id+" to Delete,Please provide the valid Id"));	
	{
	repo.deleteById(id);
	return id;
	}
	
}

}
