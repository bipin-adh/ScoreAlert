package com.meroteam.scorealert.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.meroteam.scorealert.R;
import com.meroteam.scorealert.models.Leagues;
import com.meroteam.scorealert.network.SpecificLeagueDataHandler;

import java.util.ArrayList;
import java.util.List;

import static com.meroteam.scorealert.activities.MainActivity.mainActivity;

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
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Leagues leagues = leagueList.get(position);
        holder.tvLeagueName.setText(leagues.getCaption());
        holder.tvLeagueName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.progressBar.setVisibility(View.VISIBLE);
                String leagueTableUrl = leagues.get_links().getLeagueTable().getHref();
                SpecificLeagueDataHandler specificLeagueDataHandler = new SpecificLeagueDataHandler(mainActivity, mainActivity);
                specificLeagueDataHandler.getSpecificData(leagueTableUrl);
                holder.progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return leagueList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvLeagueName;
        ProgressBar progressBar;

        public MyViewHolder(View view) {
            super(view);
            tvLeagueName = view.findViewById(R.id.tv_league_name);
            progressBar = view.findViewById(R.id.pb_get_specific_league_data);
        }
    }
}