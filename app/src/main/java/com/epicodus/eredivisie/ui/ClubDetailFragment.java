package com.epicodus.eredivisie.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.parceler.Parcels;
import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.models.Club;
import com.squareup.picasso.Picasso;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ClubDetailFragment extends Fragment {
    @Bind(R.id.crestView) ImageView mCrestView;
    @Bind(R.id.clubLabel) TextView mClubLabel;

    private Club mClub;

    public static ClubDetailFragment newInstance(Club club) {
        ClubDetailFragment clubDetailFragment = new ClubDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("club", Parcels.wrap(club));
        clubDetailFragment.setArguments(args);
        return clubDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mClub = Parcels.unwrap(getArguments().getParcelable("club"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_club_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mClub.getCrest()).into(mCrestView);
        mClubLabel.setText(mClub.getName());
        return view;
    }

}
