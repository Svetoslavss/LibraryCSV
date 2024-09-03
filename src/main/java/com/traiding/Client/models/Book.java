package com.traiding.Client.models;

public class Book {

    private String author;
    private String title;
    private String content;
    private String isbn;

    public Book() {
    }

    public Book(String author, String title, String content, String isbn) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
