package com.kraken.DataStructures.Items.DiscItems;

/**
 * Created by Curtis on 11/14/2016.
 */
public class AudioBook extends DiscItem{
    String author;
    int ISBN;

    /**
     * Default constructor
     */
    public AudioBook() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
}
