package com.epicodus.eredivisie.models;

import org.parceler.Parcel;

@Parcel
public class Fixture {
    private String mDate;
    private String mHomeTeam;
    private String mAwayTeam;
    private String mGoalsHome;
    private String mGoalsAway;

    public Fixture() {}

    public Fixture(String date, String homeTeam, String awayTeam, String goalsHome, String goalsAway) {
        this.mDate = date;
        this.mHomeTeam = homeTeam;
        this.mAwayTeam = awayTeam;
        this.mGoalsHome = goalsHome;
        this.mGoalsAway = goalsAway;

    }

    public String getDate() {
        return mDate;
    }
    public String getHomeTeam() {
        return mHomeTeam;
    }
    public String getAwayTeam() {
        return mAwayTeam;
    }
    public String getGoalsHome() {
        return mHomeTeam;
    }
    public String getGoalsAway() {
        return mGoalsAway;
    }
}
