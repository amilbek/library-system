package com.company.entities;

public class Book {
    /*Creation of variables*/
    private int bookId;
    private String bookName;
    private boolean avail;
    private int libraryId;

    /*Constructs a Book instance to the given values*/
    public Book(int bookId, String bookName, boolean avail, int libraryId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.avail = avail;
        this.libraryId = libraryId;
    }

    /*Constructs a Book instance to the given value for libraryId*/
    public Book(int libraryId) { this.libraryId = libraryId; }

    /*Constructs a Book instance to the given value for bookId and bookName*/
    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    /*Constructs a Book instance to the given value for bookId and avail*/
    public Book(int bookId, boolean avail) {
        this.bookId = bookId;
        this.avail = avail;
    }

    /*Constructs a Book instance to the given value for bookId and libraryId*/
    public Book(int bookId, int libraryId) {
        this.bookId = bookId;
        this.libraryId = libraryId;
    }

    /*Returns the BookId*/
    public int getBookId() { return bookId; }

    /*Sets the BookId to the given value*/
    public void setBookId(int bookId) { this.bookId = bookId; }

    /*Returns the BookId*/
    public String getBookName() { return bookName; }

    /*Sets the BookName to the given value*/
    public void setBookName(String bookName) { this.bookName = bookName; }

    /*Returns the Availability of Book*/
    public boolean isAvail() { return avail; }

    /*Sets the Availability to the given value*/
    public void setAvail(boolean avail) { this.avail = avail; }

    /*Returns the BookId*/
    public int getLibrary() { return libraryId; }

    /*Sets the LibraryId to the given value*/
    public void setLibrary(int libraryId) { this.libraryId = libraryId; }

    /*Returns a self-descriptive String*/
    @Override
    public String toString() {
        return "Book[" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", avail=" + avail +
                ", libraryId=" + libraryId +
                "]\n";
    }
}