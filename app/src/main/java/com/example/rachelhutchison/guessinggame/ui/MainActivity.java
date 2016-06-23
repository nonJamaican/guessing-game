package com.example.rachelhutchison.guessinggame.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.rachelhutchison.guessinggame.MyApplication;
import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private FanDuelPlayers fanDuelPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContinueButtonEnabled(false);
        requestPlayerDataRequest();
    }

    public void continuePressed(View view) {
        Intent intent = new Intent(this, GuessingActivity.class);
        intent.putExtra(GuessingActivity.PLAYERS_DATA_EXTRA, fanDuelPlayers);
        startActivity(intent);
    }

    private void setContinueButtonEnabled(boolean enabled) {
        Button button = (Button) findViewById(R.id.continue_button);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_indicator);
        button.setEnabled(enabled);
        progressBar.setVisibility(enabled ? View.GONE : View.VISIBLE);

    }

    private void requestPlayerDataRequest() {
        final MyApplication myApplication = (MyApplication) getApplication();

        myApplication.getRestService().getFanDuelPlayerData().enqueue(new Callback<FanDuelPlayers>() {
            @Override
            public void onResponse(Call<FanDuelPlayers> call, Response<FanDuelPlayers> response) {
                fanDuelPlayers = response.body();
                setContinueButtonEnabled(true);
            }

            @Override
            public void onFailure(Call<FanDuelPlayers> call, Throwable t) {
                displayErrorMessage();
            }

        });
    }

    private void displayErrorMessage() {
        Toast.makeText(this, R.string.network_error_message, Toast.LENGTH_LONG).show();
    }
}
