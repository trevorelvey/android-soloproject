package com.epicodus.eredivisie.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.eredivisie.models.Club;
import com.epicodus.eredivisie.ui.ClubDetailFragment;

import java.util.ArrayList;


public class ClubPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Club> mClubs;

    public ClubPagerAdapter(FragmentManager fm, ArrayList<Club> clubs) {
        super(fm);
        mClubs = clubs;
    }

    @Override
    public Fragment getItem(int position) {
        return ClubDetailFragment.newInstance(mClubs, position);
    }

    @Override
    public int getCount() {
        return mClubs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mClubs.get(position).getName();
    }
}
