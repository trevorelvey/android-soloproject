package com.epicodus.eredivisie.models;


public class Club {
    private String mName;
    private String mCrest;

    public Club(String name, String crest) {
        this.mName = name;
        this.mCrest = crest;
    }

    public String getName() {
        return mName;
    }

    public String getCrest() {
        return mCrest;
    }
}
