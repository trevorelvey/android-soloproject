package com.epicodus.eredivisie.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.adapters.FixturePagerAdapter;
import com.epicodus.eredivisie.models.Fixture;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FixtureDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private FixturePagerAdapter adapterViewPager;
    ArrayList<Fixture> mFixtures = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture_detail);
        ButterKnife.bind(this);
        mFixtures = Parcels.unwrap(getIntent().getParcelableExtra("fixtures"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new FixturePagerAdapter(getSupportFragmentManager(), mFixtures);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
