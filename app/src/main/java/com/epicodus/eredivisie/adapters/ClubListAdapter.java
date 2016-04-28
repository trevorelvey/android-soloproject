package com.epicodus.eredivisie.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.models.Club;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ClubListAdapter extends RecyclerView.Adapter<ClubListAdapter.ClubViewHolder> {
    private ArrayList<Club> mClubs = new ArrayList<>();
    private Context mContext;

    public ClubListAdapter(Context context, ArrayList<Club> clubs) {
        mContext = context;
        mClubs = clubs;
    }
    @Override
    public ClubListAdapter.ClubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_list_item, parent, false);
        ClubViewHolder viewHolder = new ClubViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ClubListAdapter.ClubViewHolder holder, int position) {
        holder.bindClub(mClubs.get(position));
    }

    @Override
    public int getItemCount() {
        return mClubs.size();
    }

    public class ClubViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.crestImageView)
        ImageView mCrestImageView;
        @Bind(R.id.clubNameTextView)
        TextView mClubNameTextView;
        private Context mContext;


        public ClubViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindClub(Club club) {
            mClubNameTextView.setText(club.getName());
        }
    }
}
