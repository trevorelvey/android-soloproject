package com.epicodus.eredivisie.models;

public class Table {
    private String rank;
    private String team;
    private String playedGames;
    private String tableCrest;
    private String points;
    private String goals;
    private String goalsAgainst;
    private String goalDifferential;

    public Table() {}

    public Table(String rank, String team, String playedGames, String tableCrest, String points, String goals, String goalsAgainst, String goalDifferential) {
        this.rank = rank;
        this.team = team;
        this.playedGames = playedGames;
        this.tableCrest = tableCrest;
        this.points = points;
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.goalDifferential = goalDifferential;
    }

    public String getRank() {
        return rank;
    }

    public String getTeam() {
        return team;
    }

    public String getPlayedGames() {
        return playedGames;
    }

    public String getTableCrest() {
        return tableCrest;
    }

    public String getPoints() {
        return points;
    }

    public String getGoals() {
        return goals;
    }

    public String getGoalsAgainst() {
        return goalsAgainst;
    }

    public String getGoalDifferential() {
        return goalDifferential;
    }
}
