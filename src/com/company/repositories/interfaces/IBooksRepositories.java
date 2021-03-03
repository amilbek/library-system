package com.company.repositories.interfaces;

import com.company.entities.Book;

import java.util.List;

public interface IBooksRepositories {
    boolean addBook(Book book);

    Book getBookByID(int bookId);
    List<Book> getBookByName(String bookName);
    List<Book> getBookByAvail(boolean avail);
    List<Book> getBookByLibraryId(int libraryId);

    int updateBookName(Book book);
    int updateBookAvail(Book book);
    int updateLibraryId(Book book);

    int deleteBook(Book book);

    List<Book> getAllBooks();
}
