package com.example.Books.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Books.DTO.AuthorDto;
import com.example.Books.Entitys.Author;
import com.example.Books.Services.AuthorService;

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
@RequestMapping(path = "/Authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService ;

	// public AuthorController(AuthorService authorService) {
    //     this.authorService = authorService;
    // }


    @GetMapping
	public List<AuthorDto> getAuthors () { 
        return authorService.getAuthorDto();

	}

    @PostMapping
    public void registerNewAuthor(@RequestBody Author author){
        authorService.addNewAuthor(author) ;
    }

    @DeleteMapping(path = "{authorId}")
    public void deleteAuthor(@PathVariable("authorId") UUID AuthorId ){
        authorService.deleteAuthor(AuthorId) ;
    }

    @PutMapping(path = "{authorId}")
    public void updateAuthor(
        @PathVariable("authorId") UUID AuthorId ,
        @RequestParam (required = false) String firstName ,
        @RequestParam (required = false) String lastName 
    ){
        authorService.updateAuthor(AuthorId , firstName , lastName ) ;
    }

    @DeleteMapping("/delete")
    public void deleteAllAuthors() {
        authorService.deleteAllAuthors();
}
    

}