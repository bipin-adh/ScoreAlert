package com.meroteam.scorealert.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.meroteam.scorealert.R;
import com.meroteam.scorealert.fragments.LeagueTableFragment;

import butterknife.ButterKnife;

/**
 * Created by bpn8adh on 09/05/18.
 * Contains specific league info
 */

public class HomeActivity extends AppCompatActivity {

    public static void launchActivity(Activity activity) {
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        FragmentTransaction transactionLaunchLeagueFragment = getSupportFragmentManager().beginTransaction();
        transactionLaunchLeagueFragment.replace(R.id.frame_layout, LeagueTableFragment.newInstance());
        transactionLaunchLeagueFragment.commit();
    }
}
