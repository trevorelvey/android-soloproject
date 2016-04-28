package com.epicodus.eredivisie.services;

import com.epicodus.eredivisie.Constants;
import com.epicodus.eredivisie.models.Club;

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

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_KEY).newBuilder();
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
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clubs;
    }
}
