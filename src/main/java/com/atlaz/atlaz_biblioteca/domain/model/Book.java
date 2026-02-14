package com.atlaz.atlaz_biblioteca.domain.model;

public class Book {
    private Long id;
    private Long bookCode;
    private String title;
    private String author;
    private String genre;
    private String imageId;
    private BookStatus bookStatus;

    public Book(Long id, String title, Long bookCode, String author, String genre, String imageId, BookStatus bookStatus) {
        this.id = id;
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.imageId = imageId;
        this.bookStatus = bookStatus;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookCode() {
        return bookCode;
    }

    public void setBookCode(Long bookCode) {
        this.bookCode = bookCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}

