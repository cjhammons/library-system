package com.kraken.DataStructures.Items.Books;

/**
 * Created by Curtis on 11/14/2016.
 */
public class HardCopy extends Book {
    String locationInLibrary;

    /**
     * Default constructor
     */
    public HardCopy() {
        super();
    }

    public String getLocationInLibrary() {
        return locationInLibrary;
    }

    public void setLocationInLibrary(String locationInLibrary) {
        this.locationInLibrary = locationInLibrary;
    }
}
