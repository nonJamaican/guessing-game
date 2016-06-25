package com.example.rachelhutchison.guessinggame.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.RobolectricUnitTests;
import com.example.rachelhutchison.guessinggame.model.DefaultImage;
import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;
import com.example.rachelhutchison.guessinggame.model.Player;
import com.example.rachelhutchison.guessinggame.model.PlayerImage;
import com.example.rachelhutchison.guessinggame.ui.components.PlayersFragment;

import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowToast;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GuessingActivityTest extends RobolectricUnitTests {

    private GuessingActivity guessingActivity;

    @Test
    public void ifPlayerDataExtraMissingFromBundleWillShowMessageToUser() {
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).create().visible().get();
        assertEquals(guessingActivity.getString(R.string.network_error_message), ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void onCreateShouldShowInstructionMessageToUser() {
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).withIntent(buildOnePlayerIntent()).create().visible().get();
        TextView instructionMessage = (TextView) guessingActivity.findViewById(R.id.guessing_game_instruction_message);
        assertEquals(guessingActivity.getString(R.string.guessing_game_instruction_message), instructionMessage.getText());
    }

    @Test
    public void onCreateWillHideNextButton() {
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).withIntent(buildOnePlayerIntent()).create().visible().get();
        Button button = (Button) guessingActivity.findViewById(R.id.guessing_next_button);
        assertEquals(View.INVISIBLE, button.getVisibility());
    }

    @Test
    public void onCreateShouldShowPlayerOneImageAndName() {
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).withIntent(buildOnePlayerIntent()).create().visible().get();
        PlayersFragment fragment = (PlayersFragment) guessingActivity.getFragmentManager().findFragmentById(R.id.player_one_compare_container);
        assertEquals(View.VISIBLE, fragment.getPlayerImageView().getVisibility());
        assertEquals("bobby smith", fragment.getPlayerNameView().getText());
    }

    @Test
    public void onCreateShouldShowPlayerTwoImageAndName() {
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).withIntent(buildOnePlayerIntent()).create().visible().get();
        PlayersFragment fragment = (PlayersFragment) guessingActivity.getFragmentManager().findFragmentById(R.id.player_two_compare_container);
        assertEquals(View.VISIBLE, fragment.getPlayerImageView().getVisibility());
        assertEquals("bobby smith", fragment.getPlayerNameView().getText());
    }

    @Test
    public void onPlayerImageClickShouldShowBothPlayersFppgRatings() {
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).withIntent(buildOnePlayerIntent()).create().visible().get();
        PlayersFragment fragment1 = (PlayersFragment) guessingActivity.getFragmentManager().findFragmentById(R.id.player_one_compare_container);
        PlayersFragment fragment2 = (PlayersFragment) guessingActivity.getFragmentManager().findFragmentById(R.id.player_two_compare_container);
        assertEquals(View.INVISIBLE, fragment1.getFppgRatingView().getVisibility());
        assertEquals(View.INVISIBLE, fragment2.getFppgRatingView().getVisibility());
        guessingActivity.playerImageClicked("anyName", "anyRating");
        assertEquals(View.VISIBLE, fragment1.getFppgRatingView().getVisibility());
        assertEquals(View.VISIBLE, fragment2.getFppgRatingView().getVisibility());
    }

    @Test
    public void onPlayerImageClickWillDisplayNextButton() {
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).withIntent(buildOnePlayerIntent()).create().visible().get();
        guessingActivity.playerImageClicked("anyName", "anyRating");
        Button button = (Button) guessingActivity.findViewById(R.id.guessing_next_button);
        assertEquals(View.VISIBLE, button.getVisibility());
        assertEquals(guessingActivity.getString(R.string.next), button.getText());
        assertTrue(button.isEnabled());
    }

    private Intent buildOnePlayerIntent() {
        Intent intent = new Intent(getApplication(), GuessingActivity.class);
        intent.putExtra(GuessingActivity.PLAYERS_DATA_EXTRA, buildFanDuelPlayersWithOnlyOnePlayer());
        return intent;
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
        player.setImages(buildPlayerImages());
        return player;
    }

    private PlayerImage buildPlayerImages() {
        PlayerImage images = new PlayerImage();
        DefaultImage defaultImage = new DefaultImage();
        defaultImage.setUrl("https://d17odppiik753x.cloudfront.net/playerimages/nba/12342.png");
        images.setDefaultImage(defaultImage);
        return images;
    }
}