package com.example.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private double price;

    @Builder
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
}