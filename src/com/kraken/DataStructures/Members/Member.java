package com.kraken.DataStructures.Members;

/**
 * Created by Curtis on 11/14/2016.
 */
public class Member {

    int memberId;
    String name;
    double fines;
    boolean canCheckOut;
    boolean isLibrarian;

    /**
     * Default Constructor
     */
    public Member() {

    }

    public boolean isLibrarian() {
        return isLibrarian;
    }

    public int getMemberId() {
        return memberId;
    }

    public double getFines() {
        return fines;
    }

    public String getName() {
        return name;
    }

    public boolean CanCheckOut() {
        return canCheckOut;
    }

    public void setCanCheckOut(boolean canCheckOut) {
        this.canCheckOut = canCheckOut;
    }

    public void setFines(double fines) {
        this.fines = fines;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLibrarian(boolean librarian) {
        isLibrarian = librarian;
    }
}
