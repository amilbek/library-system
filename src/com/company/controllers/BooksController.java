package com.company.controllers;

import com.company.entities.Book;
import com.company.repositories.interfaces.IBooksRepositories;

import java.util.List;

public class BooksController {
    private final IBooksRepositories bookRepo;

    public BooksController(IBooksRepositories bookRepo) {
        this.bookRepo = bookRepo;
    }

    public String addBook(int bookId, String bookName, boolean avail, int libraryId) {
        Book book = new Book(bookId, bookName, avail, libraryId);

        boolean added = bookRepo.addBook(book);

        return (added ? "Book addition was failed!" : "Book was added successfully!");
    }

    public String getBookById(int bookId) {
        Book book = bookRepo.getBookByID(bookId);

        return (book == null ? "Book was not found!" : book.toString());
    }

    public String getBookByName(String bookName) {
        List<Book> book = bookRepo.getBookByName(bookName);

        return (book == null ? "Book was not found!" : book.toString());
    }

    public String getBookByAvail(boolean avail) {
        List<Book> book = bookRepo.getBookByAvail(avail);

        return (book == null ? "Book was not found!" : book.toString());
    }

    public String getBookByLibraryId(int libraryId) {
        List<Book> book = bookRepo.getBookByLibraryId(libraryId);

        return (book == null ? "Book was not found!" : book.toString());
    }

    public String updateBookName(int bookId, String bookName) {
        Book book = new Book(bookId, bookName);

        int updated = bookRepo.updateBookName(book);
        return ((updated==0)? "Book updating was failed!" : "Book Name was updated successfully!");
    }

    public String updateBookAvail(int bookId, boolean avail) {
        Book book = new Book(bookId, avail);

        int updated = bookRepo.updateBookAvail(book);
        return ((updated==0) ? "Updating of Book Availability was failed!" : "Book Availability was updated successfully!");
    }

    public String updateLibraryId(int bookId, int libraryId) {
        Book book = new Book(bookId, libraryId);

        int updated = bookRepo.updateLibraryId(book);
        return ((updated==0) ? "Updating of Library ID was failed!" : "Library ID was updated successfully!");
    }

    public String deleteBook(int bookId) {
        Book book = new Book(bookId);

        int deleted = bookRepo.deleteBook(book);
        return ((deleted==0) ? "Deleting of Book was failed" : "Book was deleted successfully!");
    }

    public String getAllBooks() {
        List<Book> books = bookRepo.getAllBooks();

        return books.toString();
    }
}
