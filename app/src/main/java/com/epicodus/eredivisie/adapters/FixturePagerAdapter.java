package com.epicodus.eredivisie.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.eredivisie.models.Fixture;
import com.epicodus.eredivisie.ui.FixtureDetailFragment;

import java.util.ArrayList;

public class FixturePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fixture> mFixtures;

    public FixturePagerAdapter(FragmentManager fm, ArrayList<Fixture> fixtures) {
        super(fm);
        mFixtures = fixtures;
    }

    @Override
    public Fragment getItem(int position) {
        return FixtureDetailFragment.newInstance(mFixtures.get(position));
    }

    @Override
    public int getCount() {
        return mFixtures.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFixtures.get(position).getDate();
    }
}
