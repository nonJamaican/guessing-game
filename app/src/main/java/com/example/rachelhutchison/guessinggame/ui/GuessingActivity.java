package com.example.rachelhutchison.guessinggame.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;
import com.example.rachelhutchison.guessinggame.ui.components.PlayersFragment;

public class GuessingActivity extends AppCompatActivity {

    public static final String PLAYERS_DATA_EXTRA = "PLAYERS_DATA_EXTRA";
    private FanDuelPlayers fanduelPlayersData;

    //todo replace with actuals;
    public String playerName = "Brian Smith";
    public String fppg = "0.1478618973";
    public String url = "https://d17odppiik753x.cloudfront.net/playerimages/nba/9524.png";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game);
        extractExtras();

        if (fanduelPlayersData == null) {
            displayErrorMessage();
        }

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        } else {
            loadPlayerFragment(url, playerName, fppg);
        }
    }

    private void loadPlayerFragment(String url, String playerName, String fppgRating) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment playerFragment = PlayersFragment.newInstance(url, playerName, fppgRating);
        fragmentManager.beginTransaction().replace(R.id.player_one_compare_container, playerFragment).commit();
    }

    private void extractExtras() {
        fanduelPlayersData = (FanDuelPlayers) getIntent().getSerializableExtra(PLAYERS_DATA_EXTRA);
    }

    private void displayErrorMessage() {
        Toast.makeText(this, R.string.network_error_message, Toast.LENGTH_LONG).show();
    }
}
