package com.epicodus.eredivisie.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.adapters.ClubListAdapter;
import com.epicodus.eredivisie.models.Club;
import com.epicodus.eredivisie.services.ApiService;

import java.io.IOException;
import java.util.ArrayList;


import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ClubActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private ClubListAdapter mAdapter;
    public ArrayList<Club> mClubs = new ArrayList<>();
    public static final String TAG = ClubActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        ButterKnife.bind(this);

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
                        mAdapter = new ClubListAdapter(getApplicationContext(), mClubs);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                        new LinearLayoutManager(ClubActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
