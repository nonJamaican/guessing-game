package com.example.rachelhutchison.guessinggame.ui;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.compare.PlayerComparator;
import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;
import com.example.rachelhutchison.guessinggame.model.Player;
import com.example.rachelhutchison.guessinggame.playergenerator.RandomPlayerGenerator;
import com.example.rachelhutchison.guessinggame.scoring.ScoreKeeper;
import com.example.rachelhutchison.guessinggame.ui.components.PlayersFragment;
import com.example.rachelhutchison.guessinggame.ui.components.PlayersFragment.HandllePlayerImageInteraction;

public class GuessingActivity extends AppCompatActivity implements HandllePlayerImageInteraction {

    public static final String PLAYERS_DATA_EXTRA = "PLAYERS_DATA_EXTRA";
    private FanDuelPlayers fanduelPlayersData;
    private String nameOfWinner;

    private RandomPlayerGenerator randomPlayerGenerator;
    private ScoreKeeper scoreKeeper;
    private TextView resultMessageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game);
        scoreKeeper = new ScoreKeeper();
        extractExtras();
        configureUi();
        if (fanduelPlayersData == null) {
            displayErrorMessage();
            return;
        }

        randomPlayerGenerator = new RandomPlayerGenerator(fanduelPlayersData);
        refreshResultMessage();

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        } else {
            buildGameRound();
        }
    }

    private void buildGameRound() {
        nameOfWinner = null;
        populatePlayerGameData();
    }

    private void configureUi() {
        resultMessageView = (TextView) findViewById(R.id.guesses_result);
    }

    private void refreshResultMessage() {
        resultMessageView.setText(getString(R.string.guessed_result_message, scoreKeeper.getCorrectGuesses(), scoreKeeper.getNumberTries()));
    }

    private void populatePlayerGameData() {
        Player player1 = randomPlayerGenerator.getRandomPlayer();
        Player player2 = randomPlayerGenerator.getRandomPlayer();
        nameOfWinner = PlayerComparator.getFullNameOfHighestFppgRating(player1, player2);
        loadPlayerOneFragment(player1);
        loadPlayerTwoFragment(player2);
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
        return player.getImages().getDefaultImage().getUrl();
    }

    private void extractExtras() {
        fanduelPlayersData = (FanDuelPlayers) getIntent().getSerializableExtra(PLAYERS_DATA_EXTRA);
    }

    private void displayErrorMessage() {
        Toast.makeText(this, R.string.network_error_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void playerImageClicked(String playerName) {
        showFppgRatings();
        boolean didIGuessCorrectly = didIGuessCorrectly(playerName);
        calculateTheScore(didIGuessCorrectly);
        refreshResultMessage();
        displayGuessMessage(didIGuessCorrectly);
    }

    private void displayGuessMessage(boolean didIGuessCorrectly) {
        new AlertDialog.Builder(this)
                .setMessage(getGuessedMessage(didIGuessCorrectly))
                .setTitle(R.string.guessed_dialog_result_title)
                .setCancelable(false)
                .setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resolveContinueOrCompleteGame();
                    }
                }).create().show();
    }

    private void resolveContinueOrCompleteGame() {
        if (scoreKeeper.isGameComplete()) {
            startResultActivity();
        } else {
            buildGameRound();
        }
    }

    private void startResultActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    private String getGuessedMessage(boolean didIGuessCorrectly) {
        return didIGuessCorrectly ? getString(R.string.guessed_dialog_correctly) : getString(R.string.guessed_dialog_wrong);
    }

    private void calculateTheScore(boolean didIGuessCorrectly) {
        scoreKeeper.increaseScore(didIGuessCorrectly);
    }

    private boolean didIGuessCorrectly(String playerName) {
        return nameOfWinner == null || playerName.equals(nameOfWinner);
    }

    private void showFppgRatings() {
        PlayersFragment playerOneFragment = (PlayersFragment) getFragmentManager().findFragmentById(R.id.player_one_compare_container);
        playerOneFragment.showFppgRating();

        PlayersFragment playerTwoFragment = (PlayersFragment) getFragmentManager().findFragmentById(R.id.player_two_compare_container);
        playerTwoFragment.showFppgRating();
    }

    public void setNameOfWinner(String nameOfWinner) {
        this.nameOfWinner = nameOfWinner;
    }

    public ScoreKeeper getScoreKeeper() {
        return scoreKeeper;
    }
}
