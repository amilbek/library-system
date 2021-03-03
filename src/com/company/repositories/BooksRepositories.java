package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Book;
import com.company.repositories.interfaces.IBooksRepositories;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BooksRepositories implements IBooksRepositories {
    /*Creation of final variable*/
    private final IDB db;

    /*Constructs a BooksRepositories instance tp the given value for db*/
    public BooksRepositories(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addBook(Book book) {
        Connection con = null;

        try {
            con = db.getConnection();
            /*Query for PostgreSQL to add data to the table*/
            String sql = "INSERT INTO books(book_id, book_name, avail, library_id) VALUES(?, ?, ?, ?)";
            /*The object of statement is responsible to execute queries with the database*/
            PreparedStatement st = con.prepareStatement(sql);
            /*Passing a value for a column*/
            st.setInt(1, book.getBookId());
            st.setString(2, book.getBookName());
            st.setBoolean(3, book.isAvail());
            st.setInt(4, book.getLibrary());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            /*Close connection - clean up the system resources*/
            try {
                con.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public Book getBookByID(int bookId) {
        Connection con = null;
        try {
            con = db.getConnection();
            /*Query for PostgreSQL to select books by book ID*/
            String sql = "SELECT book_id, book_name, avail, library_id FROM books WHERE book_id =? ORDER BY book_id ASC";
            /*The object of statement is responsible to execute queries with the database*/
            PreparedStatement st = con.prepareStatement(sql);
            /*Passing a value for a column*/
            st.setInt(1, bookId);
            /*The executeQuery() method of Statement interface is used to execute queries to the database*/
            ResultSet rs = st.executeQuery();
            /*Processing the result*/
            if (rs.next()) {
                Book book = new Book(rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getBoolean("avail"),
                        rs.getInt("library_id"));

                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            /*Close connection - clean up the system resources*/
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Book> getBookByName(String bookName) {
        Connection con = null;
        try {
            con = db.getConnection();
            /*Query for PostgreSQL to select books by book name*/
            String sql = "SELECT book_id, book_name, avail, library_id FROM books WHERE book_name =? ORDER BY book_id ASC";
            /*The object of statement is responsible to execute queries with the database*/
            PreparedStatement st = con.prepareStatement(sql);
            /*Passing a value for a column*/
            st.setString(1, bookName);
            /*The executeQuery() method of Statement interface is used to execute queries to the database*/
            ResultSet rs = st.executeQuery();
            /*Creating list of books*/
            List<Book> books = new LinkedList<>();
            /*Processing the result*/
            while (rs.next()) {
                Book book = new Book(rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getBoolean("avail"),
                        rs.getInt("library_id"));

                /*Adding book to the list books*/
                books.add(book);
            }
            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            /*Close connection - clean up the system resources*/
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Book> getBookByAvail(boolean avail) {
        Connection con = null;
        try {
            con = db.getConnection();
            /*Query for PostgreSQL to select books by book name*/
            String sql = "SELECT book_id, book_name, avail, library_id FROM books WHERE avail =? ORDER BY book_id ASC";
            /*The object of statement is responsible to execute queries with the database*/
            PreparedStatement st = con.prepareStatement(sql);
            /*Passing a value for a column*/
            st.setBoolean(1, avail);
            /*The executeQuery() method of Statement interface is used to execute queries to the database*/
            ResultSet rs = st.executeQuery();
            /*Creating the list books*/
            List<Book> books = new LinkedList<>();
            /*Processing the result*/
            while (rs.next()) {
                Book book = new Book(rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getBoolean("avail"),
                        rs.getInt("library_id"));

                /*Adding book to the list boob*/
                books.add(book);
            }
            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            /*Close connection clean up the system resources*/
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Book> getBookByLibraryId(int libraryId) {
        Connection con = null;
        try {
            con = db.getConnection();
            /*Query for the PostgreSQL to select books by their library*/
            String sql = "SELECT book_id, book_name, avail, library_id FROM books WHERE library_id =? ORDER BY book_id ASC";
            /*The object of statement is responsible to execute queries with the database*/
            PreparedStatement st = con.prepareStatement(sql);
            /*Passing a value for a column*/
            st.setInt(1, libraryId);
            /*Creating the list books*/
            List<Book> books = new LinkedList<>();
            /*The executeQuery() method of Statement interface is used to execute queries to the database*/
            ResultSet rs = st.executeQuery();
            /*Processing the result*/
            while (rs.next()) {
                Book book = new Book(rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getBoolean("avail"),
                        rs.getInt("library_id"));

                /*Adding book to the list boob*/
                books.add(book);
            }
            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            /*Close connection clean up the system resources*/
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public int updateBookName(Book book) {
        Connection con = null;
        int rowsAffected = 0;

        try {
            con = db.getConnection();
            /*Query for PostgreSQL to update book name*/
            String sql = "UPDATE books SET book_name =? WHERE book_id =?";
            /*The object of statement is responsible te execute update with the database*/
            PreparedStatement st = con.prepareStatement(sql);
            /*Passing values for columns*/
            st.setString(1, book.getBookName());
            st.setInt(2, book.getBookId());
            /*The executeUpdate() method of Statement interface is used to execute update in the database*/
            rowsAffected = st.executeUpdate();
            /*Returns the number of rows that affected by updating*/
            return rowsAffected;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            /*Close connection clean up the system resources*/
            try {
                con.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return rowsAffected;
    }

    @Override
    public int updateBookAvail(Book book) {
        Connection con = null;
        int rowsAffected = 0;

        try {
            con = db.getConnection();
            String sql = "UPDATE books SET avail =? WHERE book_id =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setBoolean(1, book.isAvail());
            st.setInt(2, book.getBookId());

            rowsAffected = st.executeUpdate();
            return rowsAffected;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return rowsAffected;
    }

    @Override
    public int updateLibraryId(Book book) {
        Connection con = null;
        int rowsAffected = 0;

        try {
            con = db.getConnection();
            String sql = "UPDATE books SET library_id =? WHERE book_id =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, book.getLibrary());
            st.setInt(2, book.getBookId());

            rowsAffected = st.executeUpdate();
            return rowsAffected;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return rowsAffected;
    }

    @Override
    public int deleteBook(Book book) {
        Connection con = null;
        int rowsAffected = 0;

        try {
            con = db.getConnection();
            String sql = "DELETE FROM books WHERE book_id =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, book.getLibrary());

            rowsAffected = st.executeUpdate();
            return rowsAffected;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return rowsAffected;
    }

    @Override
    public List<Book> getAllBooks() {
        Connection con = null;

        try {
            con = db.getConnection();
            /*Query for PostgreSQL to select all books from the database*/
            String sql = "SELECT* FROM books ORDER BY book_id ASC";
            /*The object of statement is responsible to execute queries with the database*/
            Statement st = con.createStatement();
            /*The executeQuery() method of Statement interface is used to execute queries to the database*/
            ResultSet rs = st.executeQuery(sql);
            /*Creating the list books*/
            List<Book> books = new LinkedList<>();
            /*Processing the result*/
            while (rs.next()) {
                Book book = new Book(rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getBoolean("avail"),
                        rs.getInt("library_id"));

                /*Adding book to the list books*/
                books.add(book);
            }

            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }
}
