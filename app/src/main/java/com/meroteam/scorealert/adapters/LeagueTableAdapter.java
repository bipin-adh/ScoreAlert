package com.meroteam.scorealert.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meroteam.scorealert.R;
import com.meroteam.scorealert.models.LeagueTable;
import com.meroteam.scorealert.models.Leagues;
import com.meroteam.scorealert.models.Standing;
import com.meroteam.scorealert.network.SpecificLeagueDataHandler;

import java.util.ArrayList;
import java.util.List;

import static com.meroteam.scorealert.activities.MainActivity.mainActivity;

/**
 * Created by bpn8adh on 09/05/18.
 */

public class LeagueTableAdapter extends RecyclerView.Adapter<LeagueTableAdapter.MyViewHolder> {

    public static final String TAG = LeagueTableAdapter.class.getSimpleName();
    private Context context;
    private LeagueTableAdapter.MyViewHolder viewHolder;
    private List<Leagues> leagueList = new ArrayList<>();
    private List<Standing> leagueTableStandingsList = new ArrayList<>();

    public LeagueTableAdapter(Context context, List<Standing> leagueTableStandingsList) {
        this.context = context;
        this.leagueTableStandingsList = leagueTableStandingsList;
    }

    @Override
    public LeagueTableAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.league_table_item, parent, false);

        viewHolder = new LeagueTableAdapter.MyViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LeagueTableAdapter.MyViewHolder holder, int position) {
        final Standing standing = leagueTableStandingsList.get(position);
        holder.tvLeagueName.setText(standing.getTeamName());
//        holder.tvLeagueName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String leagueTableUrl = leagues.get_links().getLeagueTable().getHref();
//                SpecificLeagueDataHandler specificLeagueDataHandler = new SpecificLeagueDataHandler(mainActivity, mainActivity);
//                specificLeagueDataHandler.getSpecificData(leagueTableUrl);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return leagueTableStandingsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvLeagueName;

        public MyViewHolder(View view) {
            super(view);
            tvLeagueName = view.findViewById(R.id.tv_league_name);
        }
    }
}
