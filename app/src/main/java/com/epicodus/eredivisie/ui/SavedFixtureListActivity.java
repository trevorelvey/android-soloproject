package com.epicodus.eredivisie.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.eredivisie.Constants;
import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.adapters.FirebaseFixtureListAdapter;
import com.epicodus.eredivisie.models.Fixture;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedFixtureListActivity extends AppCompatActivity {
    private Query mQuery;
    private Firebase mFirebaseFixturesRef;
    private FirebaseFixtureListAdapter mAdapter;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture);
        ButterKnife.bind(this);

        mFirebaseFixturesRef = new Firebase(Constants.FIREBASE_URL_FIXTURES);

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery() {
        String location = mFirebaseFixturesRef.toString();
        mQuery = new Firebase(location);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseFixtureListAdapter(mQuery, Fixture.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}