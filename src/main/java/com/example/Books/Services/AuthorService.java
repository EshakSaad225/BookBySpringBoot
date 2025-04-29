package com.example.Books.Authors;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Books.Books.Book;
import com.example.Books.Books.BookWithoutAuthorDto;
import jakarta.transaction.Transactional;

@Service
public class AuthorService {

    @Autowired  
    private final AuthorRepository authorRepository ; 

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthor () { 
		return authorRepository.findAll() ;
        }

    public void addNewAuthor(Author author) {
        authorRepository.save(author) ;
    }

    public void deleteAuthor(UUID authorId) {
        boolean exists = authorRepository.existsById(authorId) ;
        if(!exists){
            throw new IllegalStateException("author with id " + authorId + " does not exists") ;
        }
        authorRepository.deleteById(authorId);
    }

    @Transactional
    public void updateAuthor(UUID authorId, String fName, String lName) {

        Author author =  authorRepository.findById(authorId).orElseThrow(
            () -> new IllegalStateException("author with id " + authorId + " does not exists") 
        ) ;

        if(fName != null && fName.length() > 0 
            && !Objects.equals(author.getFirstName(), fName)){
                author.setFirstName(fName);
        }

        if(lName != null && lName.length() > 0 
        && !Objects.equals(author.getLastName(), lName)){
            author.setLastName(lName);
        }

    }

    public void deleteAllAuthor() {
        authorRepository.deleteAll();
    }

    private BookWithoutAuthorDto bookWithoutAuthorDto (Book book){
        BookWithoutAuthorDto bookWithoutAuthorDto = new BookWithoutAuthorDto();
        bookWithoutAuthorDto.setId(book.getId());
        bookWithoutAuthorDto.setTitle(book.getTitle());
        bookWithoutAuthorDto.setPrice(book.getPrice());
        bookWithoutAuthorDto.setState(book.isState());
        return bookWithoutAuthorDto;
    }

    private AuthorDto authorToDto(Author author) {
        AuthorDto authorDto = new AuthorDto() ;
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        authorDto.setPhoneNumber(author.getPhoneNumber());

        if(!author.getBooks().isEmpty()){

            List<BookWithoutAuthorDto> bookWithoutAuthorDto = author.getBooks()
                .stream()
                .map(this::bookWithoutAuthorDto) // لازم تكون عامل الميثود دي
            .collect(Collectors.toList());
            authorDto.setBooks(bookWithoutAuthorDto);
        }
        return authorDto ;
    }

    public List<AuthorDto> getAuthorDto(){
        List<Author> author = getAuthor();
        if(author.isEmpty()){
            return List.of() ;
        }
        return author.stream()
        .map(this::authorToDto)
        .toList();
    }
    
}
