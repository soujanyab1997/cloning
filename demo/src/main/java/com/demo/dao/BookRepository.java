package com.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

	//Boolean existsById(int id); 

}
