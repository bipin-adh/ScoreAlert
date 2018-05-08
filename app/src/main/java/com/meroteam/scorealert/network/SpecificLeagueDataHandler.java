package com.meroteam.scorealert.network;

import android.content.Context;
import android.util.Log;

import com.meroteam.scorealert.ScoreAlertApplication;
import com.meroteam.scorealert.interfaces.DataFetchedListener;
import com.meroteam.scorealert.models.LeagueTable;
import com.meroteam.scorealert.models.Leagues;
import com.meroteam.scorealert.network.retrofit.RetrofitManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bpn8adh on 08/05/18.
 */

public class SpecificLeagueDataHandler {

    public static final String TAG = SpecificLeagueDataHandler.class.getSimpleName();
    private static final String MSG_ERROR = "Something went wrong. Please try again !!!";
    private DataFetchedListener dataFetchedListener;
    private Context context;

    public SpecificLeagueDataHandler(Context context, DataFetchedListener dataFetchedListener) {
        this.context = context;
        this.dataFetchedListener = dataFetchedListener;
    }

    public void getSpecificData(String leagueTableUrl) {

        Log.d(TAG, "getSpecificData: url:"+ leagueTableUrl);
        RetrofitManager.getInstance(context).getSpecificLeagueData(leagueTableUrl,new Callback<LeagueTable>() {
            @Override
            public void onResponse(Call<LeagueTable> call, Response<LeagueTable> response) {
                Log.d(TAG, "onResponse: getspecificdata:"+ response);
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "aaaa specific data :" + response.body());
                        ScoreAlertApplication.getInstance().setSpecificLeaguesData(response.body());
                        dataFetchedListener.onSuccess();
                    } else {
                        dataFetchedListener.onFailure(MSG_ERROR);
                    }
                } else {
                    dataFetchedListener.onFailure(MSG_ERROR);
                }
            }

            @Override
            public void onFailure(Call<LeagueTable> call, Throwable t) {
                Log.d(TAG, "onFailure: fail"+ t.getMessage());
                dataFetchedListener.onFailure(MSG_ERROR);
            }
        });
    }
}
