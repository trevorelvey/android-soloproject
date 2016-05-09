package com.epicodus.eredivisie.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.models.Fixture;
import com.epicodus.eredivisie.ui.FixtureDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FixtureViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.matchDate)
    TextView mMatchDate;
    @Bind(R.id.homeGoalsTextView)
    TextView mHomeGoalsTextView;
    @Bind(R.id.awayGoalsTextView)
    TextView mAwayGoalsTextView;
    @Bind(R.id.homeTeamName)
    TextView mHomeTeamName;
    @Bind(R.id.awayTeamName)
    TextView mAwayTeamName;

    private Context mContext;
    private ArrayList<Fixture> mFixtures = new ArrayList<>();


    public FixtureViewHolder(View itemView, ArrayList<Fixture> fixtures) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        ButterKnife.bind(this, itemView);
        mFixtures = fixtures;
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, FixtureDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("fixtures", Parcels.wrap(mFixtures));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindFixture(Fixture fixture) {
        mMatchDate.setText(fixture.getDate());
        mHomeGoalsTextView.setText(fixture.getGoalsHome());
        mAwayGoalsTextView.setText(fixture.getGoalsAway());
        mHomeTeamName.setText(fixture.getHomeTeam());
        mAwayTeamName.setText(fixture.getAwayTeam());

    }
}