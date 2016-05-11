package com.epicodus.eredivisie.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.adapters.ClubListAdapter;
import com.epicodus.eredivisie.models.Club;
import com.epicodus.eredivisie.services.ApiService;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ClubActivity extends AppCompatActivity {
    public static final String TAG = ClubActivity.class.getSimpleName();
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private ClubListAdapter mAdapter;
    public ArrayList<Club> mClubs = new ArrayList<>();


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

    private ArrayList<Club> searchClubs(String query) {
        ArrayList<Club> clubs = new ArrayList<>();
        for (Club club : mClubs) {
            if (club.getName().contains(query)) {
                clubs.add(club);
            }
        }
        return clubs;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                ArrayList<Club> clubs = searchClubs(query);
                mAdapter = new ClubListAdapter(getApplicationContext(), clubs);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager =
                        new LinearLayoutManager(ClubActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
            return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
