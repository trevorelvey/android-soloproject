package com.epicodus.eredivisie.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.eredivisie.Constants;
import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.models.Club;
import com.epicodus.eredivisie.ui.ClubDetailActivity;
import com.epicodus.eredivisie.ui.ClubDetailFragment;
import com.squareup.picasso.Picasso;
import org.parceler.Parcels;

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
        private int mOrientation;
        private Integer mPosition;

        public ClubViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            mOrientation = itemView.getResources().getConfiguration().orientation;

            if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                createDetailFragment(0);
            }

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mPosition = getLayoutPosition();

                    if(mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                        createDetailFragment(mPosition);
                    } else {
                    Intent intent = new Intent(mContext, ClubDetailActivity.class);
                    intent.putExtra(Constants.EXTRA_KEY_POSITION, mPosition);
                    intent.putExtra(Constants.EXTRA_KEY_CLUBS, Parcels.wrap(mClubs));
                    mContext.startActivity(intent);
                }
            });
        }

        private void createDetailFragment(int position) {
            ClubDetailFragment detailFragment = ClubDetailFragment.newInstance(mClubs, position);
            FragmentTransaction ft = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.clubDetailContainer, detailFragment);
            ft.commit();
        }

        public void bindClub(Club club) {
            mClubNameTextView.setText(club.getName());
            Picasso.with(mContext).load(club.getCrest()).into(mCrestImageView);
        }
    }
}
