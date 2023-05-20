package com.upendra_accio.bookManager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private Integer id;
    private String author;
    private String title;
    private Integer page;

    public Book(){}
    public Book(Integer id, String author, String title, Integer page) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.page = page;
    }
}
