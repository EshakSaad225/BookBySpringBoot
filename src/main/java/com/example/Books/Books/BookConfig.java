// package com.example.Books.Books;

// import java.util.List;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class BookConfig {

//     @Bean
//     CommandLineRunner commandLineRunner( BookRepository repository){
//         return args -> {
//             Book pandaBook = new Book(
// 				"Panda Book",
// 				35.50,
// 				true
// 			);

//             Book goodBook = new Book(
// 				"Good Book",
// 				32,
// 				true
// 			);

//             Book noteBook = new Book(
// 				"Note Book",
// 				12,
// 				true
// 			);

//             repository.saveAll(
//                 List.of(pandaBook,goodBook,noteBook)
//             );
//         };
//     };

// }
