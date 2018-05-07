package com.meroteam.scorealert.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meroteam.scorealert.R;
import com.meroteam.scorealert.models.Leagues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpn8adh on 07/05/18.
 */

public class LeagueListAdapter extends RecyclerView.Adapter<LeagueListAdapter.MyViewHolder> {

    public static final String TAG = LeagueListAdapter.class.getSimpleName();
    private Context context;
    private MyViewHolder viewHolder;
    private List<Leagues> leagueList = new ArrayList<>();


    public LeagueListAdapter(Context context, List<Leagues> leagueList) {
        this.context = context;
        this.leagueList = leagueList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.league_list_item, parent, false);

        viewHolder = new LeagueListAdapter.MyViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Leagues leagues = leagueList.get(position);
        holder.tvLeagueName.setText(leagues.getCaption());
    }

    @Override
    public int getItemCount() {
        return leagueList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvLeagueName;

        public MyViewHolder(View view) {
            super(view);
            tvLeagueName = view.findViewById(R.id.tv_league_name);
        }
    }
}