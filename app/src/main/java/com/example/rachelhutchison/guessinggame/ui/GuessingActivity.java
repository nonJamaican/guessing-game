package com.example.rachelhutchison.guessinggame.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;

public class GuessingActivity extends AppCompatActivity {

    public static final String PLAYERS_DATA_EXTRA = "PLAYERS_DATA_EXTRA";
    private FanDuelPlayers fanduelPlayersData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game);
        extractExtras();

        if (fanduelPlayersData == null) {
            displayErrorMessage();
        }
    }

    private void extractExtras() {
        fanduelPlayersData = (FanDuelPlayers) getIntent().getSerializableExtra(PLAYERS_DATA_EXTRA);
    }

    private void displayErrorMessage() {
        Toast.makeText(this, R.string.network_error_message, Toast.LENGTH_LONG).show();
    }
}
