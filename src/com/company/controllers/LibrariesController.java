package com.company.controllers;

import com.company.entities.Book;
import com.company.entities.Library;
import com.company.repositories.interfaces.ILibrariesRepositories;

import java.sql.Time;
import java.util.List;

public class LibrariesController {
    private final ILibrariesRepositories libraryRepo;

    public LibrariesController(ILibrariesRepositories libraryRepo) {
        this.libraryRepo = libraryRepo;
    }

    public String addLibrary(int libraryId, String libraryAddress, Time startTime, Time endTime) {
        Library library = new Library(libraryId, libraryAddress, startTime, endTime);

        boolean added = libraryRepo.addLibrary(library);
        return (added ? "Library addition was failed" : "Library was added successfully");
    }

    public String getLibraryById(int libraryId) {
        Library library = libraryRepo.getLibraryById(libraryId);

        return (library == null ? "Library was not found" : library.toString());
    }

    public String getLibraryByAddress(String libraryAddress) {
        List <Library> library = (List<Library>) libraryRepo.getLibraryByAddress(libraryAddress);

        return (library == null ? "Library was not found" : library.toString());
    }

    public String updateLibraryAddress(int libraryId, String libraryAddress) {
        Library library = new Library(libraryId, libraryAddress);

        int updated = libraryRepo.updateLibraryAddress(library);
        return ((updated==0) ? "Updating of Library Address was failed" : "Library Address was updated successfully");
    }

    public String deleteLibrary(int libraryId) {
        Library library = new Library(libraryId);

        int deleted = libraryRepo.deleteLibrary(library);
        return ((deleted==0) ? "Deleting of Library was failed" : "Library was deleted successfully!");
    }

    public String getAllLibraries() {
        List<Library> libraries = libraryRepo.getAllLibraries();

        return libraries.toString();
    }
}
