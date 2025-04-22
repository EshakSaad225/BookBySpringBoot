package com.example.Books.Books;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    private final BookService bookService ;

	public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
	public List<Book> getBook () { 
        return bookService.getBook();

	}

    @GetMapping("/DESC")
	public List<Book> getDESCBook () { 
        return bookService.getDESCBook();

	}

    @PostMapping
    public void registerNewBook(@RequestBody Book book){
        bookService.addNewBook(book) ;
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer bookId ){
        bookService.deleteBook(bookId) ;
    }

    @PutMapping(path = "{bookId}")
    public void updateBook(
        @PathVariable("bookId") Integer bookId ,
        @RequestParam (required = false) String title ,
        @RequestParam (required = false) Double price 
    ){
        bookService.updateBook(bookId , title , price ) ;
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllBooks() {
    bookService.deleteAllBooks();
}
    

}
