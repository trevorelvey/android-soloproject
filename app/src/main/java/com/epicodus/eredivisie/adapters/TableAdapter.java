package com.epicodus.eredivisie.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.eredivisie.R;
import com.epicodus.eredivisie.models.Table;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableViewHolder> {
    private ArrayList<Table> mTables = new ArrayList<>();
    private Context mContext;

    public TableAdapter(Context context, ArrayList<Table> tables) {
        mContext = context;
        mTables = tables;
    }

    @Override
    public TableAdapter.TableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_list_item, parent, false);
        TableViewHolder viewHolder = new TableViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TableAdapter.TableViewHolder holder, int position) {
        holder.bindTable(mTables.get(position));
    }

    @Override
    public int getItemCount() {
        return mTables.size();
    }

    public class TableViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.clubTableImageView) ImageView mClubTableImageView;
        @Bind(R.id.clubTableTextView) TextView mClubTableTextView;
        @Bind(R.id.gamesPlayedTextView) TextView mGamesPlayedTextView;
        @Bind(R.id.pointsTextView) TextView mPointsTextView;
        @Bind(R.id.goalsForTextView) TextView mGoalsForTextView;
        @Bind(R.id.goalsAgainstTextView) TextView mGoalsAgainstTextView;
        @Bind(R.id.goalsDiffTextView) TextView mGoalsDiffTextView;
        private Context mContext;


        public TableViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindTable(Table table) {
            mClubTableTextView.setText(table.getTeam());
            mGamesPlayedTextView.setText(table.getPlayedGames());
            mPointsTextView.setText(table.getPoints());
            mGoalsForTextView.setText(table.getGoals());
            mGoalsAgainstTextView.setText(table.getGoalsAgainst());
            mGoalsDiffTextView.setText(table.getGoalDifferential());
            Picasso.with(mContext).load(table.getTableCrest()).into(mClubTableImageView);
        }
    }
}