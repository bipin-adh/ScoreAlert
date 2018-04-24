package com.meroteam.scorealert.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.meroteam.scorealert.R;
import com.meroteam.scorealert.ScoreAlertApplication;
import com.meroteam.scorealert.interfaces.DataFetchedListener;
import com.meroteam.scorealert.network.MainResponseHandler;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements DataFetchedListener {

    @BindView(R.id.btn_get_data)
    private Button btnGetData;
    @BindView(R.id.btn_show_data)
    private Button btnShowData;

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainResponseHandler mainResponseHandler = new MainResponseHandler(MainActivity.this, MainActivity.this);
                mainResponseHandler.getMainResponseData();
            }
        });

        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "aaaa onClick: show data:" + ScoreAlertApplication.getInstance().getLeaguesDataList());
            }
        });

    }

    @Override
    public void onSuccess() {
        btnShowData.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFailure(String msgError) {
        ScoreAlertApplication.getInstance().showToast(msgError);
    }
}
