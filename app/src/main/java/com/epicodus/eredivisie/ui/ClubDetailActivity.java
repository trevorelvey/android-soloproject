package com.epicodus.eredivisie.ui;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.adapters.ClubPagerAdapter;
import com.epicodus.eredivisie.models.Club;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ClubDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private ClubPagerAdapter adapterViewPager;
    ArrayList<Club> mClubs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_detail);
        ButterKnife.bind(this);
        mClubs = Parcels.unwrap(getIntent().getParcelableExtra("clubs"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new ClubPagerAdapter(getSupportFragmentManager(), mClubs);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
