package com.company.application;

import com.company.controllers.BooksController;
import com.company.repositories.interfaces.IBooksRepositories;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookApplication {
    private final BooksController controller;
    private final Scanner input;

    public BookApplication(IBooksRepositories booksRepositories) {
        controller = new BooksController(booksRepositories);
        input = new Scanner(System.in);
    }

    public void bookApp() {
        while (true) {
            System.out.println();
            System.out.println("Select option: ");
            System.out.println("1. Get all books");
            System.out.println("2. Get book by id");
            System.out.println("3. Get book by name");
            System.out.println("4. Get book by availability");
            System.out.println("5. Get book by library");
            System.out.println("6. Update book name");
            System.out.println("7. Update book availability");
            System.out.println("8. Update book library");
            System.out.println("9. Delete book");
            System.out.println("10. Add book");
            System.out.println("0. Exit");
            try {
                System.out.print("Enter option (1-10): ");
                int option = input.nextInt();
                if (option == 1) {
                    getAllBooks();
                } else if (option == 2) {
                    getBookbyId();
                } else if (option == 3) {
                    getBookByName();
                } else if (option == 4) {
                    getBookByAvail();  
                } else if (option == 5) {
                    getBookByLibraryId();
                } else if (option == 6) {
                    updateBookName();
                } else if (option == 7) {
                    updateBookAvail();
                } else if (option == 8) {
                    updateLibraryId();
                } else if (option == 9) {
                    deleteBook();
                } else if (option == 10) {
                    addBook();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                input.nextLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("*************************");
        }
    }

    public void deleteBook() {
        System.out.println("Please enter book ID");
        int bookId = input.nextInt();

        String responce = controller.deleteBook(bookId);
        System.out.println(responce);
    }

    public void updateLibraryId() {
        System.out.println("Please enter book ID");
        int bookId = input.nextInt();

        System.out.println("Please enter library ID");
        int libraryId = input.nextInt();

        String responce = controller.updateLibraryId(bookId, libraryId);
        System.out.println(responce);
    }

    public void updateBookAvail() {
        System.out.println("Please enter book ID");
        int bookId = input.nextInt();

        System.out.println("Is book available?");
        boolean avail = input.nextBoolean();

        String responce = controller.updateBookAvail(bookId, avail);
        System.out.println(responce);
    }

    public void updateBookName() {
        System.out.println("Please enter book ID");
        int bookId = input.nextInt();

        System.out.println("Please enter name of the book");
        input.nextLine();
        String bookName = input.nextLine();

        String responce = controller.updateBookName(bookId, bookName);
        System.out.println(responce);
    }

    public void getBookByLibraryId() {
        System.out.println("Please enter library ID");

        int libraryId = input.nextInt();
        String response = controller.getBookByLibraryId(libraryId);
        System.out.println(response);
    }

    public void getBookByAvail() {
        System.out.println("Please enter the type of availability");

        boolean avail = input.nextBoolean();
        String response = controller.getBookByAvail(avail);
        System.out.println(response);
    }

    public void getBookByName() {
        System.out.println("Please enter book name");

        input.nextLine();
        String bookName = input.nextLine();
        String response = controller.getBookByName(bookName);
        System.out.println(response);
    }

    public void getBookbyId() {
        System.out.println("Please enter book ID");

        int bookId = input.nextInt();
        String response = controller.getBookById(bookId);
        System.out.println(response);
    }

    public void getAllBooks() {
        String response = controller.getAllBooks();
        System.out.println(response);
    }

    public void addBook() {
        System.out.println("Please enter book ID");
        int bookId = input.nextInt();

        System.out.println("Please enter book name");
        input.nextLine();
        String bookName = input.nextLine();

        System.out.println("Please enter its availability");
        boolean avail = input.nextBoolean();

        System.out.println("Please enter library ID");
        int libraryId = input.nextInt();

        String responce = controller.addBook(bookId, bookName, avail, libraryId);
        System.out.println(responce);
    }
}
