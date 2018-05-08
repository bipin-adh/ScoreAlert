package com.meroteam.scorealert.network.retrofit;

/**
 * Created by bpn8adh on 24/04/18.
 */

import com.meroteam.scorealert.models.LeagueTable;
import com.meroteam.scorealert.models.Leagues;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitService {
    /*
     * RetrofitService get annotation with our URL
     *
     */
    @GET("/v1/competitions/")
    Call<List<Leagues>> getAllData();

    @GET
    Call<LeagueTable> getSpecificLeagueData(@Url String url);

}

