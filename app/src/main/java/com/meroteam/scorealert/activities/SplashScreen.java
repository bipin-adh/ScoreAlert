package com.meroteam.scorealert.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.meroteam.scorealert.R;
import com.meroteam.scorealert.ScoreAlertApplication;
import com.meroteam.scorealert.interfaces.DataFetchedListener;
import com.meroteam.scorealert.network.MainResponseHandler;

/**
 * Created by bpn8adh on 07/05/18.
 */

public class SplashScreen extends AppCompatActivity implements DataFetchedListener {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 0;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MainResponseHandler mainResponseHandler = new MainResponseHandler(SplashScreen.this, SplashScreen.this);
        mainResponseHandler.getMainResponseData();
    }

    @Override
    public void onSuccess() {
        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                MainActivity.launchActivity(SplashScreen.this);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void onFailure(String msgError) {
        ScoreAlertApplication.getInstance().showToast(msgError);
    }
}
