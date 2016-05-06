package com.epicodus.eredivisie.models;

import org.parceler.Parcel;

@Parcel
public class Fixture {
    private String Date;
    private String HomeTeam;
    private String AwayTeam;
    private String GoalsHome;
    private String GoalsAway;

    public Fixture() {}

    public Fixture(String date, String homeTeam, String awayTeam, String goalsHome, String goalsAway) {
        this.Date = date;
        this.HomeTeam = homeTeam;
        this.AwayTeam = awayTeam;
        this.GoalsHome = goalsHome;
        this.GoalsAway = goalsAway;

    }

    public String getDate() {
        return Date;
    }
    public String getHomeTeam() {
        return HomeTeam;
    }
    public String getAwayTeam() {
        return AwayTeam;
    }
    public String getGoalsHome() {
        return GoalsHome;
    }
    public String getGoalsAway() {
        return GoalsAway;
    }
}
