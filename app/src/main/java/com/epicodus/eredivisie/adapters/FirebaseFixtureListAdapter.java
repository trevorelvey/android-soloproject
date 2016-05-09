package com.epicodus.eredivisie.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.models.Fixture;
import com.epicodus.eredivisie.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

public class FirebaseFixtureListAdapter extends FirebaseRecyclerAdapter<FixtureViewHolder, Fixture> {

    public FirebaseFixtureListAdapter(Query query, Class<Fixture> itemClass) {
        super(query, itemClass);
    }

    @Override
    public FixtureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fixture_list_item, parent, false);
        return new FixtureViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(FixtureViewHolder holder, int position) {
        holder.bindFixture(getItem(position));
    }

    @Override
    protected void itemAdded(Fixture item, String key, int position) {

    }

    @Override
    protected void itemChanged(Fixture oldItem, Fixture newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Fixture item, String key, int position) {

    }

    @Override
    protected void itemMoved(Fixture item, String key, int oldPosition, int newPosition) {

    }
}
