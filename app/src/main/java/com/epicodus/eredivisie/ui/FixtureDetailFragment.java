package com.epicodus.eredivisie.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.eredivisie.Constants;
import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.models.Fixture;
import com.firebase.client.Firebase;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FixtureDetailFragment extends Fragment {
    @Bind(R.id.matchDate) TextView mMatchDate;
    @Bind(R.id.homeTeamName) TextView mHomeTeamName;
    @Bind(R.id.awayTeamName) TextView mAwayTeamName;
    @Bind(R.id.homeGoalsTextView) TextView mHomeGoals;
    @Bind(R.id.awayGoalsTextView) TextView mAwayGoals;

    private Fixture mFixture;

    public static FixtureDetailFragment newInstance(Fixture fixture) {
        FixtureDetailFragment fixtureDetailFragment = new FixtureDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("fixture", Parcels.wrap(fixture));
        fixtureDetailFragment.setArguments(args);
        return fixtureDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFixture = Parcels.unwrap(getArguments().getParcelable("fixture"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixture_detail, container, false);
        ButterKnife.bind(this, view);
        mSaveFixtureButton.setOnClickListener(this);

        mMatchDate.setText(mFixture.getDate());
        mHomeGoals.setText(mFixture.getGoalsHome());
        mAwayGoals.setText(mFixture.getGoalsAway());
        mHomeTeamName.setText(mFixture.getHomeTeam());
        mAwayTeamName.setText(mFixture.getAwayTeam());

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSavedFixtureButton) {
            Firebase ref = new Firebase(Constants.FIREBASE_URL_FIXTURES);
            ref.push().setValue(mFixture);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }

}
