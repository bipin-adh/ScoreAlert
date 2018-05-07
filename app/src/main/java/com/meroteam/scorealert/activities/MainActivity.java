package com.meroteam.scorealert.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.meroteam.scorealert.R;
import com.meroteam.scorealert.ScoreAlertApplication;
import com.meroteam.scorealert.adapters.LeagueListAdapter;
import com.meroteam.scorealert.models.Leagues;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private LeagueListAdapter leagueListAdapter;

    @BindView(R.id.rv_league_list)
    RecyclerView recyclerViewLeagueList;

    private List<Leagues> leagueList = new ArrayList<>();

    public static void launchActivity(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        leagueList = ScoreAlertApplication.getInstance().getLeaguesDataList();
        leagueListAdapter = new LeagueListAdapter(this, leagueList);
        // Binds the Adapter to the ListView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
//        recyclerViewLeagueList.setLayoutManager(new WrapContentLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewLeagueList.setLayoutManager(mLayoutManager);
        recyclerViewLeagueList.setItemAnimator(new DefaultItemAnimator());
        recyclerViewLeagueList.setHasFixedSize(true);
        recyclerViewLeagueList.setAdapter(leagueListAdapter);
        leagueListAdapter.notifyDataSetChanged();
    }
}
