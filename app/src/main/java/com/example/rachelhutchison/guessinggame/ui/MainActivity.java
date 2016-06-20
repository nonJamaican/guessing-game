package com.example.rachelhutchison.guessinggame.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.api.FanDuelServiceRequest;
import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Call<FanDuelPlayers> fanDuelPlayersCall;
    private FanDuelPlayers fanDuelPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContinueButtonEnabled(false);
        requestPlayerDataRequest();
    }

    private void setContinueButtonEnabled(boolean enabled) {
        Button button = (Button) findViewById(R.id.continue_button);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_indicator);
        button.setEnabled(enabled);
        progressBar.setVisibility(enabled ? View.GONE : View.VISIBLE);

    }

    private void requestPlayerDataRequest() {
        setFanDuelPlayersCall(new FanDuelServiceRequest().makeGetPlayersDataRequest());
        fanDuelPlayersCall.enqueue(new Callback<FanDuelPlayers>() {
            @Override
            public void onResponse(Call<FanDuelPlayers> call, Response<FanDuelPlayers> response) {
                fanDuelPlayers = response.body();
                setContinueButtonEnabled(true);
            }

            @Override
            public void onFailure(Call<FanDuelPlayers> call, Throwable t) {
            }

        });
    }

    protected void setFanDuelPlayersCall(Call<FanDuelPlayers> call) {
        fanDuelPlayersCall = call;
    }
}
