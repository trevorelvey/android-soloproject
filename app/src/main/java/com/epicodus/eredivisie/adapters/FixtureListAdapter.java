package com.epicodus.eredivisie.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.models.Fixture;
import com.epicodus.eredivisie.ui.FixtureDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FixtureListAdapter extends RecyclerView.Adapter<FixtureViewHolder> {
    private ArrayList<Fixture> mFixtures = new ArrayList<>();
    private Context mContext;

    public FixtureListAdapter(Context context, ArrayList<Fixture> fixtures) {
        mContext = context;
        mFixtures = fixtures;
    }
    @Override
    public FixtureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixture_list_item, parent, false);

        FixtureViewHolder viewHolder = new FixtureViewHolder(view, mFixtures);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FixtureViewHolder holder, int position) {
        holder.bindFixture(mFixtures.get(position));
    }

    @Override
    public int getItemCount() {
        return mFixtures.size();
    }


}