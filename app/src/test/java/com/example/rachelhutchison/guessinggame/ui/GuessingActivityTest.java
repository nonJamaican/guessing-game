package com.example.rachelhutchison.guessinggame.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.RobolectricUnitTests;
import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;

import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowToast;

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
        intent.putExtra(GuessingActivity.PLAYERS_DATA_EXTRA, new FanDuelPlayers());
        guessingActivity = Robolectric.buildActivity(GuessingActivity.class).withIntent(intent).create().visible().get();
        TextView instructionMessage = (TextView) guessingActivity.findViewById(R.id.guessing_game_instruction_message);
        assertEquals(guessingActivity.getString(R.string.guessing_game_instruction_message), instructionMessage.getText());
    }

}