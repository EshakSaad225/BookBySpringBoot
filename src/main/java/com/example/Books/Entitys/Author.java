package com.example.Books.Entitys;
import java.util.List;
import java.util.UUID;

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
    
}
