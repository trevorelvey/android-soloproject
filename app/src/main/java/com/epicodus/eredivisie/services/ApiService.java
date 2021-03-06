package com.epicodus.eredivisie.services;

import android.util.Log;

import com.epicodus.eredivisie.Constants;
import com.epicodus.eredivisie.models.Club;
import com.epicodus.eredivisie.models.Fixture;
import com.epicodus.eredivisie.models.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiService {

    public static void listClubs(Callback callback) {
        String API_KEY = Constants.API_KEY;

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.LEAGUE_URL).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void searchClubs(String query, Callback callback) {
        String API_KEY = Constants.API_KEY;

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.LEAGUE_URL).newBuilder();
        urlBuilder.addQueryParameter("team", query);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Club> processResults(Response response) {
        ArrayList<Club> clubs = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject dataJSON = new JSONObject(jsonData);
                JSONArray teamsJSON = dataJSON.getJSONArray("teams");
                for (int i = 0; i < teamsJSON.length(); i++) {
                    JSONObject clubJSON = teamsJSON.getJSONObject(i);
                    String name = clubJSON.getString("name");
                    String crest = clubJSON.getString("crestUrl");
                    Club club = new Club(name, crest);
                    clubs.add(club);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clubs;
    }

    public static void displayFixtures(Callback callback) {
        String API_KEY = Constants.API_KEY;

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.LEAGUE_FIXTURES).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Fixture> listFixtures(Response response) {
        ArrayList<Fixture> fixtures = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject dataJSON = new JSONObject(jsonData);
                JSONArray matchesJSON = dataJSON.getJSONArray("fixtures");
                for (int i = 0; i < matchesJSON.length(); i++) {
                    JSONObject clubJSON = matchesJSON.getJSONObject(i);
                    String date = clubJSON.getString("date");
                    String homeTeam = clubJSON.getString("homeTeamName");
                    String awayTeam = clubJSON.getString("awayTeamName");
                    JSONObject resultJSON = clubJSON.getJSONObject("result");
                    String goalsHome = resultJSON.getString("goalsHomeTeam");
                    String goalsAway = resultJSON.getString("goalsAwayTeam");
                    Fixture fixture = new Fixture(date, homeTeam, awayTeam,goalsHome, goalsAway);
                    fixtures.add(fixture);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fixtures;
    }

    public static void displayTable(Callback callback) {
        String API_KEY = Constants.API_KEY;

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.LEAGUE_TABLE).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Table> listTable(Response response) {
        ArrayList<Table> tables = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject dataJSON = new JSONObject(jsonData);
                JSONArray standingJSON = dataJSON.getJSONArray("standing");
                for (int i = 0; i < standingJSON.length(); i++) {
                    JSONObject tableJSON = standingJSON.getJSONObject(i);
                    String rank = tableJSON.getString("position");
                    String team = tableJSON.getString("teamName");
                    String playedGames = tableJSON.getString("playedGames");
                    String tableCrest = tableJSON.getString("crestURI");
                    String points = tableJSON.getString("points");
                    String goalsFor = tableJSON.getString("goals");
                    String goalsAgainst = tableJSON.getString("goalsAgainst");
                    String goalDifferential = tableJSON.getString("goalDifference");
                    Table table = new Table(rank, team, playedGames, tableCrest, points, goalsFor, goalsAgainst, goalDifferential);
                    tables.add(table);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tables;
    }
}
