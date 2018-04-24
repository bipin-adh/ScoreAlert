package com.meroteam.scorealert.network.retrofit;

/**
 * Created by bpn8adh on 24/04/18.
 */

import com.meroteam.scorealert.models.Leagues;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    /*
     * RetrofitService get annotation with our URL
     *
     */
    @GET("v1/competitions/")
    Call<List<Leagues>> getAllData();
}

