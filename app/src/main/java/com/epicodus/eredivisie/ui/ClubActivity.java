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

    }






}
