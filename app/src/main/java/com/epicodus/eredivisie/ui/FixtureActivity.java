package com.epicodus.eredivisie.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.adapters.FixtureListAdapter;
import com.epicodus.eredivisie.models.Fixture;
import com.epicodus.eredivisie.services.ApiService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FixtureActivity extends AppCompatActivity {
    public static final String TAG = FixtureActivity.class.getSimpleName();
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private FixtureListAdapter mAdapter;

    public ArrayList<Fixture> mFixtures = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        displayFixtures();
    }
    private void displayFixtures() {
        final ApiService apiService = new ApiService();

        ApiService.displayFixtures(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mFixtures = apiService.listFixtures(response);

                FixtureActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new FixtureListAdapter(getApplicationContext(), mFixtures);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(FixtureActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}