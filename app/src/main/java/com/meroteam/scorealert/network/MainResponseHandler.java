package com.meroteam.scorealert.network;

import android.content.Context;
import android.util.Log;

import com.meroteam.scorealert.ScoreAlertApplication;
import com.meroteam.scorealert.interfaces.DataFetchedListener;
import com.meroteam.scorealert.models.Leagues;
import com.meroteam.scorealert.network.retrofit.RetrofitManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bpn8adh on 24/04/18.
 */

public class MainResponseHandler {

    public static final String TAG = MainResponseHandler.class.getSimpleName();
    private static final String MSG_ERROR = "Something went wrong. Please try again !!!";
    private DataFetchedListener dataFetchedListener;
    private Context context;

    public MainResponseHandler(Context context, DataFetchedListener dataFetchedListener) {
        this.context = context;
        this.dataFetchedListener = dataFetchedListener;
    }

    public void getMainResponseData() {

        RetrofitManager.getInstance(context).getAllData(new Callback<List<Leagues>>() {
            @Override
            public void onResponse(Call<List<Leagues>> call, Response<List<Leagues>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ScoreAlertApplication.getInstance().setLeaguesData(response.body());
                        dataFetchedListener.onSuccess();
                    } else {
                        dataFetchedListener.onFailure(MSG_ERROR);
                    }
                } else {
                    dataFetchedListener.onFailure(MSG_ERROR);
                }
            }

            @Override
            public void onFailure(Call<List<Leagues>> call, Throwable t) {
                dataFetchedListener.onFailure(MSG_ERROR);
            }
        });
    }
}
