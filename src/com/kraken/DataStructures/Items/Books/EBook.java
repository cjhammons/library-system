package com.kraken.DataStructures.Items.Books;

/**
 * Created by Curtis on 11/14/2016.
 */
public class EBook extends Book {
    String accessPoint;

    /**
     * Default constructor
     */
    public EBook() {
        super();
    }

    public String getAccessPoint() {
        return accessPoint;
    }

    public void setAccessPoint(String accessPoint) {
        this.accessPoint = accessPoint;
    }
}
