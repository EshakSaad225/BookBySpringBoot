package com.example.Books.DTO;
import java.util.UUID;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 

public class BookWithoutAuthorDto {
    
    private UUID id ;
    private String title ;
    private Double price ;
    private boolean state ;
    
}
