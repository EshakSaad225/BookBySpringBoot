package com.example.Books.Books;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import com.example.Books.Authors.Author;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue
    private UUID id ;
    private String title ;
    private Double price ;
    private boolean state ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author ;


    // @Override
    // public String toString() {
    //     return "Book { " +
    //         "id => " + id +
    //         ", title => " + title +
    //         ", price => " + price +
    //         ", state => " + state + 
    //         ", author => " + (author != null ? author.toString() : "No Author") + " }";
    // }    
}
