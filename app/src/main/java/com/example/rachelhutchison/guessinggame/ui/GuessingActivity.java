package com.example.rachelhutchison.guessinggame.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;
import com.example.rachelhutchison.guessinggame.model.Player;
import com.example.rachelhutchison.guessinggame.playergenerator.RandomPlayerGenerator;
import com.example.rachelhutchison.guessinggame.ui.components.PlayersFragment;

public class GuessingActivity extends AppCompatActivity {

    public static final String PLAYERS_DATA_EXTRA = "PLAYERS_DATA_EXTRA";
    private FanDuelPlayers fanduelPlayersData;

    private RandomPlayerGenerator randomPlayerGenerator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game);
        extractExtras();

        if (fanduelPlayersData == null) {
            displayErrorMessage();
            return;
        }

        randomPlayerGenerator = new RandomPlayerGenerator(fanduelPlayersData);

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        } else {
            populatePlayerGameData();
        }
    }

    private void populatePlayerGameData() {
        loadPlayerOneFragment(randomPlayerGenerator.getRandomPlayer());
        loadPlayerTwoFragment(randomPlayerGenerator.getRandomPlayer());
    }

    private void loadPlayerOneFragment(Player player) {
        loadPlayerFragment(player, R.id.player_one_compare_container);
    }

    private void loadPlayerTwoFragment(Player player) {
        loadPlayerFragment(player, R.id.player_two_compare_container);
    }

    private void loadPlayerFragment(Player player, int containerView) {
        String url = getPlayerImageUrl(player);
        String playerName = getPlayerDisplayName(player);
        String fppgRating = getFppgRating(player);

        FragmentManager fragmentManager = getFragmentManager();
        Fragment playerFragment = PlayersFragment.newInstance(url, playerName, fppgRating);
        fragmentManager.beginTransaction().replace(containerView, playerFragment).commit();
    }

    private String getFppgRating(Player player) {
        return String.valueOf(player.getFppg());
    }

    private String getPlayerDisplayName(Player player) {
        return player.getFirstName() + " " + player.getLastName();
    }

    private String getPlayerImageUrl(Player player) {
        return player.getPlayerCardUrl();
    }

    private void extractExtras() {
        fanduelPlayersData = (FanDuelPlayers) getIntent().getSerializableExtra(PLAYERS_DATA_EXTRA);
    }

    private void displayErrorMessage() {
        Toast.makeText(this, R.string.network_error_message, Toast.LENGTH_LONG).show();
    }
}
