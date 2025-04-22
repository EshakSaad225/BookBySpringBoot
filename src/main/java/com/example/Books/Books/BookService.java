 package com.example.Books.Books;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class BookService {

    @Autowired  
    private final BookRepository bookRepository ; 

    

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBook () { 
		// return bookRepository.findAll() ;
        
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "id")) ;
	}

    public List<Book> getDESCBook () {         
        return bookRepository.findAll(Sort.by(Sort.Direction.DESC, "price")) ;
	}

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findByTitle(book.getTitle()) ;

        if(bookOptional.isPresent()){
            throw new IllegalStateException("Title taken") ;
        }

        bookRepository.save(book) ;

        // System.out.println(book);
    }

    public void deleteBook(Integer bookId) {
        boolean exists = bookRepository.existsById(bookId) ;
        if(!exists){
            throw new IllegalStateException("book with id " + bookId + " does not exists") ;
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Integer bookId, String title, Double price) {

        Book book =  bookRepository.findById(bookId).orElseThrow(
            () -> new IllegalStateException("book with id " + bookId + " does not exists") 
        ) ;

        if(title != null && title.length() > 0 
            && !Objects.equals(book.getTitle(), title)){
            book.setTitle(title);
        }

        if(price !=  null && !price.isNaN()
        && !Objects.equals(book.getPrice(), price)){
        book.setPrice(price);
    }

    }

    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }
    
}
