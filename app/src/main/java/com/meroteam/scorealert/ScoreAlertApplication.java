package com.meroteam.scorealert;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.meroteam.scorealert.models.Leagues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpn8adh on 24/04/18.
 */

public class ScoreAlertApplication extends Application {
    private static ScoreAlertApplication mInstance;
    private List<Leagues> leaguesDataList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized ScoreAlertApplication getInstance() {
        return mInstance;
    }

    public static Context getContext() {
        return mInstance;
    }

    public void setLeaguesData(List<Leagues> leaguesDataList) {
        this.leaguesDataList = leaguesDataList;
    }

    public List<Leagues> getLeaguesDataList() {
        return leaguesDataList;
    }

    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}