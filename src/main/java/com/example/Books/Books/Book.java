package com.example.Books.Books;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(
        name = "book_sequence",
        sequenceName = "book_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "book_sequence"
    )
    private int id ;
    private String title ;
    private Double price ;
    private boolean state ;
    private String publisher ;

    public Book() {
    }

    public Book(int id,
                String title,
                double price,
                boolean state,
                String publisher) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.state = state;
        this.publisher = publisher;
    }


    public Book(String title,
                double price,
                boolean state,
                String publisher) {
        this.title = title;
        this.price = price;
        this.state = state;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book { " +
        "id => " + id +
        ", title => " + title +
        ", price => " + price +
        ", state => " + state + 
        ", publisher => " + publisher + " }";
    }

    
    


}
