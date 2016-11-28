package com.kraken.DataStructures.Items.DiscItems;

import com.kraken.DataStructures.Items.Item;

/**
 * Created by Curtis on 11/14/2016.
 *
 * Abstract representation of a DiscItem. All items that are discs must extend this.
 */
public abstract class DiscItem extends Item{
    int numDiscs;
    double runtime; //in minutes?

    /**
     * Default constructor
     */
    public DiscItem() {
        super();
    }

    public double getRuntime() {
        return runtime;
    }

    public int getNumDiscs() {
        return numDiscs;
    }

    public void setNumDiscs(int numDiscs) {
        this.numDiscs = numDiscs;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }
}
