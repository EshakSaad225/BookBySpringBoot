package com.example.Books.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Books.DTO.BookDto;
import com.example.Books.Entitys.Book;
import com.example.Books.Services.BookService;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "/Books")
public class BookController {

    @Autowired
    private BookService bookService ;

	// public BookController(BookService bookService) {
    //     this.bookService = bookService;
    // }

    @GetMapping
	public List<BookDto> getBooks () { 
        return bookService.getBookDto();
	}

    @GetMapping("/sorted")
	public List<BookDto> getDESCBooks (@SortDefault(sort = "price",direction = Sort.Direction.DESC)Sort sort) { 
        return bookService.getBookDtoDEC(sort);
	}

    @PostMapping
    public void registerNewBook(@RequestBody Book book){
        bookService.addNewBook(book) ;
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") UUID bookId ){
        bookService.deleteBook(bookId) ;
    }

    @PutMapping(path = "{bookId}")
    public void updateBook(
        @PathVariable("bookId") UUID bookId ,
        @RequestParam (required = false) String title ,
        @RequestParam (required = false) Double price 
    ){
        bookService.updateBook(bookId , title , price ) ;
    }

    @DeleteMapping("/delete")
    public void deleteAllBooks() {
    bookService.deleteAllBooks();
}
}