package com.company.repositories.interfaces;

import com.company.entities.Library;

import java.util.List;

public interface ILibrariesRepositories {
    boolean addLibrary(Library library);

    Library getLibraryById(int libraryId);
    List<Library> getLibraryByAddress(String libraryAddress);

    int updateLibraryAddress(Library library);

    int deleteLibrary(Library library);

    List<Library> getAllLibraries();
}
