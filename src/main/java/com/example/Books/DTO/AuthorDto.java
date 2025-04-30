package com.example.Books.DTO;
import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class AuthorDto {
    private UUID id ;
    private String firstName ;
    private String lastName ;
    private String phoneNumber ;
    private List<BookWithoutAuthorDto> books;

}
