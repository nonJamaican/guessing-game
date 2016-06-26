package com.example.rachelhutchison.guessinggame.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.RobolectricUnitTests;
import com.example.rachelhutchison.guessinggame.model.DefaultImage;
import com.example.rachelhutchison.guessinggame.model.FanDuelResponse;
import com.example.rachelhutchison.guessinggame.model.Player;
import com.example.rachelhutchison.guessinggame.model.PlayerImage;
import com.example.rachelhutchison.guessinggame.ui.components.PlayersFragment;

import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowAlertDialog;
import org.robolectric.shadows.ShadowToast;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

public class GuessingActivityTest extends RobolectricUnitTests {

    private GuessingActivity guessingActivity;

    @Test
    public void ifPlayerDataExtraMissingFromBundleWillShowMessageToUser() {
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).create().visible().get();
        assertEquals(guessingActivity.getString(R.string.network_error_message), ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void onCreateShouldShowInstructionMessageToUser() {
        buildActivity(buildOnePlayerIntent());
        TextView instructionMessage = (TextView) guessingActivity.findViewById(R.id.guessing_game_instruction_message);
        assertEquals(guessingActivity.getString(R.string.guessing_game_instruction_message), instructionMessage.getText());
    }

    @Test
    public void onCreateShouldShowPlayerOneImageAndName() {
        buildActivity(buildOnePlayerIntent());
        PlayersFragment fragment = (PlayersFragment) guessingActivity.getFragmentManager().findFragmentById(R.id.player_one_compare_container);
        assertEquals(View.VISIBLE, fragment.getPlayerImageView().getVisibility());
        assertEquals("bobby smith", fragment.getPlayerNameView().getText());
    }

    @Test
    public void onCreateShouldShowPlayerTwoImageAndName() {
        buildActivity(buildOnePlayerIntent());
        PlayersFragment fragment = (PlayersFragment) guessingActivity.getFragmentManager().findFragmentById(R.id.player_two_compare_container);
        assertEquals(View.VISIBLE, fragment.getPlayerImageView().getVisibility());
        assertEquals("bobby smith", fragment.getPlayerNameView().getText());
    }

    @Test
    public void onCreateWillDisplayNumberOfCorrectGuessesAndTriesAsZero() {
        buildActivity(buildOnePlayerIntent());
        TextView guessResult = (TextView) guessingActivity.findViewById(R.id.guesses_result);
        assertEquals(guessingActivity.getString(R.string.guessed_result_message, 0, 0), guessResult.getText());
    }

    @Test
    public void onPlayerImageClickShouldShowBothPlayersFppgRatings() {
        buildActivity(buildOnePlayerIntent());
        PlayersFragment fragment1 = (PlayersFragment) guessingActivity.getFragmentManager().findFragmentById(R.id.player_one_compare_container);
        PlayersFragment fragment2 = (PlayersFragment) guessingActivity.getFragmentManager().findFragmentById(R.id.player_two_compare_container);
        assertEquals(View.INVISIBLE, fragment1.getFppgRatingView().getVisibility());
        assertEquals(View.INVISIBLE, fragment2.getFppgRatingView().getVisibility());
        guessingActivity.playerImageClicked("anyName");
        assertEquals(View.VISIBLE, fragment1.getFppgRatingView().getVisibility());
        assertEquals(View.VISIBLE, fragment2.getFppgRatingView().getVisibility());
    }

    @Test
    public void onPlayerImageClickWithWrongNameWillDisplayWrongResultDialog() {
        buildActivity(buildOnePlayerIntent());
        guessingActivity.setNameOfWinner("bobby smith");
        guessingActivity.playerImageClicked("anyName");
        AlertDialog latestAlertDialog = ShadowAlertDialog.getLatestAlertDialog();
        ShadowAlertDialog shadowAlert = Shadows.shadowOf(latestAlertDialog);
        assertEquals(guessingActivity.getString(R.string.guessed_dialog_result_title), shadowAlert.getTitle());
        assertEquals(guessingActivity.getString(R.string.guessed_dialog_wrong), shadowAlert.getMessage());
        assertEquals(guessingActivity.getString(R.string.next), latestAlertDialog.getButton(DialogInterface.BUTTON_POSITIVE).getText());
    }

    @Test
    public void onPlayerImageClickWithCorrectNameWillDisplayCorrectResultDialog() {
        buildActivity(buildOnePlayerIntent());
        guessingActivity.playerImageClicked("bobby smith");
        AlertDialog latestAlertDialog = ShadowAlertDialog.getLatestAlertDialog();
        ShadowAlertDialog shadowAlert = Shadows.shadowOf(latestAlertDialog);
        assertEquals(guessingActivity.getString(R.string.guessed_dialog_result_title), shadowAlert.getTitle());
        assertEquals(guessingActivity.getString(R.string.guessed_dialog_correctly), shadowAlert.getMessage());
        assertEquals(guessingActivity.getString(R.string.next), latestAlertDialog.getButton(DialogInterface.BUTTON_POSITIVE).getText());
    }
    
    @Test
    public void onPlayerImageClickIfGameEndConditionsReachedWillDisplayResultsDialogWithButtonTextContinue() {
        buildActivity(buildOnePlayerIntent());
        increaseScoreToNineCorrect();
        guessingActivity.playerImageClicked("bobby smith");
        AlertDialog latestAlertDialog = ShadowAlertDialog.getLatestAlertDialog();
        assertEquals(guessingActivity.getString(R.string.continue_button), latestAlertDialog.getButton(DialogInterface.BUTTON_POSITIVE).getText());
    }

    @Test
    public void onPlayerImageClickWithCorrectNameWillDisplayResultsMessageCorrect() {
        buildActivity(buildOnePlayerIntent());
        guessingActivity.playerImageClicked("bobby smith");
        TextView guessResult = (TextView) guessingActivity.findViewById(R.id.guesses_result);
        assertEquals(guessingActivity.getString(R.string.guessed_result_message, 1, 1), guessResult.getText());
    }

    @Test
    public void onPlayerImageClickWithWrongNameWillDisplayResultsMessageCorrect() {
        buildActivity(buildOnePlayerIntent());
        guessingActivity.setNameOfWinner("bobby smith");
        guessingActivity.playerImageClicked("anyName");
        TextView guessResult = (TextView) guessingActivity.findViewById(R.id.guesses_result);
        assertEquals(guessingActivity.getString(R.string.guessed_result_message, 0, 1), guessResult.getText());
    }

    @Test
    public void onPositiveButtonClickFromResultDialogWillNotFinishActivity() {
        buildActivity(buildOnePlayerIntent());
        guessingActivity.playerImageClicked("bobby smith");
        AlertDialog latestAlertDialog = ShadowAlertDialog.getLatestAlertDialog();
        latestAlertDialog.getButton(DialogInterface.BUTTON_POSITIVE).performClick();
        assertFalse(guessingActivity.isFinishing());
    }

    @Test
    public void onPositiveButtonClickFromResultDialogIfGameEndConditionsReachedWillStartResultActivity() {
        buildActivity(buildOnePlayerIntent());
        increaseScoreToNineCorrect();
        guessingActivity.playerImageClicked("bobby smith");
        AlertDialog latestAlertDialog = ShadowAlertDialog.getLatestAlertDialog();
        latestAlertDialog.getButton(DialogInterface.BUTTON_POSITIVE).performClick();
        ShadowActivity shadow = shadowOf(guessingActivity);
        Intent nextIntent = shadow.peekNextStartedActivity();
        assertEquals(ResultActivity.class.getName(), nextIntent.getComponent().getClassName());
        assertTrue(nextIntent.hasExtra(ResultActivity.NUMBER_OF_ATTEMPTS_EXTRA));
        assertTrue(guessingActivity.isFinishing());
    }

    protected void increaseScoreToNineCorrect() {
        for (int i = 0; i < 9; i++) {
            guessingActivity.getScoreKeeper().increaseScore(true);
        }
    }

    private void buildActivity(Intent intent) {
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).withIntent(intent).create().visible().get();
    }

    private Intent buildOnePlayerIntent() {
        Intent intent = new Intent(getApplication(), GuessingActivity.class);
        intent.putExtra(GuessingActivity.PLAYERS_DATA_EXTRA, buildFanDuelResponseWithOnlyOnePlayer());
        return intent;
    }

    private FanDuelResponse buildFanDuelResponseWithOnlyOnePlayer() {
        FanDuelResponse fanDuelResponse = new FanDuelResponse();
        List<Player> players = new ArrayList<>();
        players.add(buildPlayer());
        fanDuelResponse.setPlayers(players);
        return fanDuelResponse;
    }

    private Player buildPlayer() {
        return buildPlayer("bobby", "smith");
    }

    private Player buildPlayer(String name, String lastname) {
        Player player = new Player();
        player.setFirstName(name);
        player.setLastName(lastname);
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