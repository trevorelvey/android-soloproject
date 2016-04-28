package com.epicodus.eredivisie.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.models.Club;
import com.epicodus.eredivisie.services.ApiService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.RunnableFuture;


import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ClubActivity extends AppCompatActivity {
    public ArrayList<Club> mClubs = new ArrayList<>();
    public static final String TAG = ClubActivity.class.getSimpleName();
    @Bind(R.id.recyclerView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        ButterKnife.bind(this);

        mListView = (ListView) findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        getClubs();
    }
    private void getClubs() {
        final ApiService apiService = new ApiService();

        ApiService.listClubs(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mClubs = apiService.processResults(response);

                ClubActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] clubNames = new String[mClubs.size()];
                        for (int i = 0; i < clubNames.length; i++) {
                            clubNames[i] = mClubs.get(i).getName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(ClubActivity.this,
                                android.R.layout.simple_list_item_1, clubNames);
                        mListView.setAdapter(adapter);

                        for (Club club : mClubs) {
                            Log.d(TAG, club.getName());
                            Log.d(TAG, club.getCrest());
                        }
                    }
                });
            }
        });
    }
}
