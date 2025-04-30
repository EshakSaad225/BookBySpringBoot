 package com.example.Books.Services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Books.DTO.BookDto;
import com.example.Books.DTO.BookWithoutAuthorDto;
import com.example.Books.Entitys.Book;
import com.example.Books.Repositorys.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {

    @Autowired  
    private BookRepository bookRepository ; 

    // public BookService(BookRepository bookRepository) {
    //     this.bookRepository = bookRepository;
    // }

    public List<Book> getBooks () { 
		return bookRepository.findAll() ;
        
        // return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "id")) ;
	}

    public List<Book> getSortedBook (Sort sort) {         
        return bookRepository.findAll(sort) ;
	}

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findByTitle(book.getTitle()) ;

        if(bookOptional.isPresent()){
            throw new IllegalStateException("Title taken") ;
        }

        bookRepository.save(book) ;

        // System.out.println(book);
    }

    public void deleteBook(UUID bookId) {
        boolean exists = bookRepository.existsById(bookId) ;
        if(!exists){
            throw new IllegalStateException("book with id " + bookId + " does not exists") ;
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(UUID bookId, String title, Double price) {

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

    private BookDto booktoDto (Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setPrice(book.getPrice());
        bookDto.setState(book.isState());
        bookDto.setAuthorName(book.getAuthor() != null ? book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() : null);
        bookDto.setAuthorId(book.getAuthor() != null ? book.getAuthor().getId() : null );
        return bookDto ;
    }

    public List<BookDto> getBookDto(){
        List<Book> books = getBooks();
        if(books.isEmpty()){
            return List.of() ;
        }
        return books.stream()
        .map(this::booktoDto)
        .toList();
    }

    public List<BookDto> getBookDtoDEC(Sort sort){
        List<Book> books = getSortedBook(sort);
        if(books.isEmpty()){
            return List.of() ;
        }
        return books.stream()
        .map(this::booktoDto)
        .toList();
    }

        public BookWithoutAuthorDto bookWithoutAuthorDto (Book book){
        BookWithoutAuthorDto bookWithoutAuthorDto = new BookWithoutAuthorDto();
        bookWithoutAuthorDto.setId(book.getId());
        bookWithoutAuthorDto.setTitle(book.getTitle());
        bookWithoutAuthorDto.setPrice(book.getPrice());
        bookWithoutAuthorDto.setState(book.isState());
        return bookWithoutAuthorDto;
    }
    
}
