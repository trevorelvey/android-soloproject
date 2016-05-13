package com.epicodus.eredivisie.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.adapters.ClubListAdapter;
import com.epicodus.eredivisie.models.Club;

import java.util.ArrayList;

import butterknife.Bind;

public class ClubListFragment extends Fragment {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private String mRecentAddress;
    private ClubListAdapter mAdapter;
    public ArrayList<Club> mClubs = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

}
