package com.example.Books.Books;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;
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
	public List<BookDto> getBook () { 
        return bookService.getBookDto();

	}

    @GetMapping("/DESC")
	public List<BookDto> getDESCBook () { 
        return bookService.getBookDtoDEC();

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

    @DeleteMapping("/deleteAllBooks")
    public void deleteAllBooks() {
    bookService.deleteAllBooks();
}
}