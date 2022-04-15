package com.example.demo.Resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Book;
import com.example.demo.Repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	BookRepository repository;
	
	
	@PostMapping("/addBook")
	public String  saveBook(@RequestBody Book book) {
		 repository.save(book);
		return "book is added with book id as"+ book.toString() ;
		
		
	}
	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks(){
		
		return repository.findAll();
	}
	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable int id ){
		
		return repository.findById(id);
	}

	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id ){
		
		repository.deleteById(id);
		
		return "book deleted with id "+id;
	}
}
