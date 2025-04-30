package com.example.Books.DTO;
import java.util.UUID;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class BookDto {

    private UUID id ;
    private String title ;
    private Double price ;
    private boolean state ;
    private String authorName ;
    private UUID authorId ;
}
