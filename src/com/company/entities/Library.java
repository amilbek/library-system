package com.company.entities;

import java.sql.Time;

public class Library {
    /*Creation of variables*/
    private int libraryId;
    private String libraryAddress;
    private Time startTime;
    private Time endTime;

    /*Constructs a Library instance with the given values*/
    public Library(int libraryId, String libraryAddress, Time startTime, Time endTime) {
        this.libraryId = libraryId;
        this.libraryAddress = libraryAddress;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /*Constructs a Library instance with the given value for libraryAddress*/
    public Library(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    /*Constructs a Library instance with the given value for libraryId*/
    public Library(int libraryId) {
        this.libraryId= libraryId;
    }

    /*Constructs a Library instance with the given value for libraryId and LibraryAddress*/
    public Library(int libraryId, String libraryAddress) {
        this.libraryId = libraryId;
        this.libraryAddress = libraryAddress;
    }

    /*Returns the LibraryId*/
    public int getLibraryId() { return libraryId; }

    /*Sets the LibraryId to the given value*/
    public void setLibraryId(int libraryId) { this.libraryId = libraryId; }

    /*Returns the LibraryAddress*/
    public String getLibraryAddress() { return libraryAddress; }

    /*Sets the LibraryAddress to the given value*/
    public void setLibraryAddress(String libraryAddress) { this.libraryAddress = libraryAddress; }

    /*Returns the StartTime*/
    public Time getStartTime() { return startTime; }

    /*Sets the StartTime to the given value*/
    public void setStartTime(Time startTime) { this.startTime = startTime; }

    /*Returns the EndTime*/
    public Time getEndTime() { return endTime; }

    /*Sets the EndTime to the given value*/
    public void setEndTime(Time endTime) { this.endTime = endTime; }

    /*Returns a self-descriptive String*/
    @Override
    public String toString() {
        return "Library[" +
                "libraryId=" + libraryId +
                ", libraryAddress='" + libraryAddress + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                "]\n";
    }
}
