package com.example.Books.Repositorys;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Books.Entitys.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,UUID> {

    // @Query("SELECT b FROM Book b WHERE b.title = ?1 ")
    Optional<Book> findByTitle( String title ) ; 

}
