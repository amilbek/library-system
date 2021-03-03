package com.company.application;

import com.company.controllers.LibrariesController;
import com.company.repositories.interfaces.ILibrariesRepositories;

import java.sql.Time;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryApplication {
    private final LibrariesController controller;
    private final Scanner input;

    public LibraryApplication(ILibrariesRepositories librariesRepositories) {
        controller = new LibrariesController(librariesRepositories);
        input = new Scanner(System.in);
    }

    public void libraryApp() {
        while (true) {
            System.out.println();
            System.out.println("Select option: ");
            System.out.println("1. Get all libraries");
            System.out.println("2. Get library by id");
            System.out.println("3. Get library by address");
            System.out.println("4. Update library address");
            System.out.println("5. Delete library");
            System.out.println("6. Add library");
            System.out.println("0. Exit");
            try {
                System.out.print("Enter option (1-6): ");
                int option = input.nextInt();
                if (option == 1) {
                    getAllLibraries();
                } else if (option == 2) {
                    getLibraryById();
                } else if (option == 3) {
                    getLibraryByAddress();
                } else if (option == 4) {
                    updateLibraryAddress();
                } else if (option == 5) {
                    deleteLibrary();
                }  else if (option == 6) {
                    addLibrary();
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

    public void deleteLibrary() {
        System.out.println("Please enter library ID");
        int libraryId = input.nextInt();

        String responce = controller.deleteLibrary(libraryId);
        System.out.println(responce);
    }

    private void updateLibraryAddress() {
        System.out.println("Please enter library ID");
        int libraryId = input.nextInt();

        System.out.println("Please enter new address of the library");
        input.nextLine();
        String libraryAddress = input.nextLine();
        String responce = controller.updateLibraryAddress(libraryId, libraryAddress);
        System.out.println(responce);
    }

    private void getLibraryByAddress() {
        System.out.println("Please enter library address");

        input.nextLine();
        String libraryAddress = input.nextLine();
        String response = controller.getLibraryByAddress(libraryAddress);
        System.out.println(response);
    }

    private void getLibraryById() {
        System.out.println("Please enter library ID");

        int libraryId = input.nextInt();
        String response = controller.getLibraryById(libraryId);
        System.out.println(response);
    }

    private void getAllLibraries() {
        String response = controller.getAllLibraries();
        System.out.println(response);
    }

    public void addLibrary() {
        System.out.println("Please enter library ID");
        int libraryId = input.nextInt();

        System.out.println("Please enter library address");
        input.nextLine();
        String libraryAdress = input.nextLine();

        System.out.println("Please enter opening time of library");
        Time startTime = Time.valueOf(input.next());

        System.out.println("Please enter closing time of library");
        Time endTime = Time.valueOf(input.next());

        String responce = controller.addLibrary(libraryId, libraryAdress, startTime, endTime);
        System.out.println(responce);
    }
}
