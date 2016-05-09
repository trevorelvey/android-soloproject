package com.epicodus.eredivisie.models;

import org.parceler.Parcel;

@Parcel
public class Fixture {
    private String date;
    private String homeTeam;
    private String awayTeam;
    private String goalsHome;
    private String goalsAway;

    public Fixture() {}

    public Fixture(String date, String homeTeam, String awayTeam, String goalsHome, String goalsAway) {
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.goalsHome = goalsHome;
        this.goalsAway = goalsAway;

    }

    public String getDate() {
        return date;
    }
    public String getHomeTeam() {
        return homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }
    public String getGoalsHome() {
        return goalsHome;
    }
    public String getGoalsAway() {
        return goalsAway;
    }
}
