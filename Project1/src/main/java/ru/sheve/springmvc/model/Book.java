package ru.sheve.springmvc.model;

public class Book {
    private int book_id;
    private String nameBook;
    private String author;
    private int year;

    public Book() {
    }

    public Book(int book_id, String nameBook, String author, int year) {
        this.book_id = book_id;
        this.nameBook = nameBook;
        this.author = author;
        this.year = year;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
