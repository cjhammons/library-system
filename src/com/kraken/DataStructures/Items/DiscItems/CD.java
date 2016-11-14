package com.kraken.DataStructures.Items.DiscItems;

/**
 * Created by Curtis on 11/14/2016.
 */
public class CD extends DiscItem {

    String artist;

    /**
     * Default constructor
     */
    public CD() {
        super();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
