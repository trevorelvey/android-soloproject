package com.epicodus.eredivisie;

public class Constants {

    //API
    public static final String API_KEY = BuildConfig.API_KEY;
    public static final String LEAGUE_URL = "http://api.football-data.org/v1/soccerseasons/404/teams";
    public static final String LEAGUE_FIXTURES = "http://api.football-data.org/v1/soccerseasons/404/fixtures";

    //FIREBASE
    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;

    //USER AUTHENTICATION
    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String KEY_UID = "UID";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
    public static final String KEY_USER_EMAIL = "email";

}
