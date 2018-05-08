package com.meroteam.scorealert.network.retrofit;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.meroteam.scorealert.R;
import com.meroteam.scorealert.models.LeagueTable;
import com.meroteam.scorealert.models.Leagues;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bpn8adh on 24/04/18.
 */

public class RetrofitManager {

    public static final String TAG = RetrofitManager.class.getSimpleName();
    private static RetrofitManager retrofitManager;
    private static String BASE_URL;

    private final RetrofitService service;
    private Retrofit retrofit;

    public static RetrofitManager getInstance(Context mContext) {
        String baseUrl = mContext.getString(R.string.api_base_url);
        // for changing url we need to check this
        if (retrofitManager == null || !retrofitManager.BASE_URL.equals(baseUrl))
            retrofitManager = new RetrofitManager(baseUrl);

        return retrofitManager;
    }

    RetrofitManager(String baseUrl) {
        BASE_URL = baseUrl;
        // for logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(180, TimeUnit.SECONDS).build();

        retrofit = new retrofit2.Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RetrofitService.class);
    }

    public void getAllData(Callback<List<Leagues>> mainResponseCallback) {
        Call<List<Leagues>> getAllApiCall = service.getAllData();
        getAllApiCall.enqueue(mainResponseCallback);
    }

    public void getSpecificLeagueData(String leagueTableUrl, Callback<LeagueTable> specificLeagueDataCallback) {
        Call<LeagueTable> getSpecificLeagueDataApiCall = service.getSpecificLeagueData(leagueTableUrl);
        getSpecificLeagueDataApiCall.enqueue(specificLeagueDataCallback);
    }
}
