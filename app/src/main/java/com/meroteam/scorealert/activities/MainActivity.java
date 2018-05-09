package com.meroteam.scorealert.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.meroteam.scorealert.R;
import com.meroteam.scorealert.ScoreAlertApplication;
import com.meroteam.scorealert.adapters.LeagueListAdapter;
import com.meroteam.scorealert.interfaces.DataFetchedListener;
import com.meroteam.scorealert.models.Leagues;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 List of Leagues
 */
public class MainActivity extends AppCompatActivity implements DataFetchedListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    private LeagueListAdapter leagueListAdapter;

    @BindView(R.id.rv_league_list)
    RecyclerView recyclerViewLeagueList;

    private List<Leagues> leagueList = new ArrayList<>();
    public static MainActivity mainActivity;

    public static void launchActivity(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainActivity = this;
        leagueList = ScoreAlertApplication.getInstance().getLeaguesDataList();
        leagueListAdapter = new LeagueListAdapter(this, leagueList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
//        recyclerViewLeagueList.setLayoutManager(new WrapContentLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewLeagueList.setLayoutManager(mLayoutManager);
        recyclerViewLeagueList.setItemAnimator(new DefaultItemAnimator());
        recyclerViewLeagueList.setHasFixedSize(true);
        recyclerViewLeagueList.setAdapter(leagueListAdapter);
        leagueListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess() {
        Log.d(TAG, "aaaaa onSuccess: mainactivity:" + ScoreAlertApplication.getInstance().getSpecificLeaguesDataList());

        ScoreAlertApplication.getInstance().showToast(ScoreAlertApplication.getInstance().getSpecificLeaguesDataList().getLeagueCaption());
        HomeActivity.launchActivity(this);
    }

    @Override
    public void onFailure(String msgError) {
        ScoreAlertApplication.getInstance().showToast(msgError);
    }
}