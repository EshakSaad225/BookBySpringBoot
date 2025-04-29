package com.example.Books.Authors;
import java.util.List;
import java.util.UUID;
import com.example.Books.Books.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 

@Entity
@Table
public class Author {
    
    @Id
    @GeneratedValue
    private UUID id ;
    private String firstName ;
    private String lastName ;
    private String phoneNumber ;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    // @Override
    // public String toString() {
    //     return "Author { " +
    //         "id => " + id +
    //         ", first name => " + firstName +
    //         ", last name => " + lastName +
    //         ", phone number => " + phoneNumber + 
    //         ", books => " + (books != null ? books.toString() : "No books") + " }"; 
    // }
    
}
