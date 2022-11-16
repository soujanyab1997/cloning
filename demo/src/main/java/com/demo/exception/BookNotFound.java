package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFound extends RuntimeException{

	public int id;
	
	public BookNotFound() {
		
	}

	public BookNotFound(String s) {
		super(s);
//		this.id=id;
//		System.out.println("Book doesn't exist with id "+id);
		// TODO Auto-generated constructor stub
	}
}
