package com.company.application;

import com.company.controllers.BooksController;
import com.company.controllers.LibrariesController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.BooksRepositories;
import com.company.repositories.LibrariesRepositories;
import com.company.repositories.interfaces.IBooksRepositories;
import com.company.repositories.interfaces.ILibrariesRepositories;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    /*Creating final variables*/
    private final BooksController booksController;
    private final LibrariesController librariesController;
    private final Scanner input;

    /*Creating class instance using interface name*/
    IDB db = new PostgresDB();
    /*Creating class instance using interface name and calling constructor*/
    IBooksRepositories booksRepositories = new BooksRepositories(db);
    ILibrariesRepositories librariesRepositories = new LibrariesRepositories(db);
    /*Creating an instance using the class name and calling constructor*/
    BookApplication bApp = new BookApplication(booksRepositories);
    LibraryApplication lApp = new LibraryApplication(librariesRepositories);

    /*Constructs a Application instance with default values*/
    public Application() {
        booksController = new BooksController(booksRepositories);
        librariesController = new LibrariesController(librariesRepositories);
        input = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Working with books");
            System.out.println("2. Working with libraries");
            System.out.println("0. Exit");
            try {
                System.out.print("Enter option: ");
                int option = input.nextInt();
                if (option == 1) {
                    bApp.bookApp();
                } else if (option == 2) {
                    lApp.libraryApp();
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
}
