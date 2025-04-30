package com.example.Books.Repositorys;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Books.Entitys.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,UUID> {

}
