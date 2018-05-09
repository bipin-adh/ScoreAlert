package com.meroteam.scorealert.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meroteam.scorealert.R;
import com.meroteam.scorealert.ScoreAlertApplication;
import com.meroteam.scorealert.adapters.LeagueListAdapter;
import com.meroteam.scorealert.adapters.LeagueTableAdapter;
import com.meroteam.scorealert.models.LeagueTable;
import com.meroteam.scorealert.models.Standing;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bpn8adh on 07/05/18.
 */

public class LeagueTableFragment extends Fragment {

    private View view;
    private LeagueTableAdapter leagueTableAdapter;

    @BindView(R.id.rv_league_table_list)
    RecyclerView recyclerViewTableList;
    private LeagueTable leagueTableData;
    private List<Standing> leagueTableDataStandingsList = new ArrayList<>();

    public LeagueTableFragment(){

    }

    public static LeagueTableFragment newInstance() {
        return new LeagueTableFragment();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_league_table_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        leagueTableData = ScoreAlertApplication.getInstance().getSpecificLeaguesDataList();
        leagueTableDataStandingsList = leagueTableData.getStanding();

        leagueTableAdapter = new LeagueTableAdapter(getActivity(), leagueTableDataStandingsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        recyclerViewLeagueList.setLayoutManager(new WrapContentLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTableList.setLayoutManager(mLayoutManager);
        recyclerViewTableList.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTableList.setHasFixedSize(true);
        recyclerViewTableList.setAdapter(leagueTableAdapter);
        leagueTableAdapter.notifyDataSetChanged();
    }
}