package com.example.rachelhutchison.guessinggame.ui;

import android.content.Intent;
import android.widget.TextView;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.RobolectricUnitTests;
import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;
import com.example.rachelhutchison.guessinggame.model.Player;

import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowToast;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GuessingActivityTest extends RobolectricUnitTests {

    private GuessingActivity guessingActivity;

    @Test
    public void ifPlayerDataExtraMissingFromBundleWillShowMessageToUser() {
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).create().visible().get();
        assertEquals(guessingActivity.getString(R.string.network_error_message), ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void onCreateShouldShowInstructionMessageToUser() {
        Intent intent = new Intent(getApplication(), GuessingActivity.class);
        intent.putExtra(GuessingActivity.PLAYERS_DATA_EXTRA, buildFanDuelPlayersWithOnlyOnePlayer());
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).withIntent(intent).create().visible().get();
        TextView instructionMessage = (TextView) guessingActivity.findViewById(R.id.guessing_game_instruction_message);
        assertEquals(guessingActivity.getString(R.string.guessing_game_instruction_message), instructionMessage.getText());
    }

    private FanDuelPlayers buildFanDuelPlayersWithOnlyOnePlayer() {
        FanDuelPlayers fanDuelPlayers = new FanDuelPlayers();
        List<Player> players = new ArrayList<>();
        players.add(buildPlayer());
        fanDuelPlayers.setPlayers(players);
        return fanDuelPlayers;
    }

    private Player buildPlayer() {
        Player player = new Player();
        player.setFirstName("bobby");
        player.setLastName("smith");
        player.setFppg(34.2356665);
        player.setPlayerCardUrl("url");
        return player;
    }

}