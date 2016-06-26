package com.example.rachelhutchison.guessinggame.ui;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.RobolectricUnitTests;

import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

public class ResultActivityTest extends RobolectricUnitTests {

    private ResultActivity resultsActivity;

    @Test
    public void ifPlayerDataExtraMissingFromBundleWillShowMessageToUser() {
        resultsActivity = Robolectric.buildActivity(ResultActivity.class).create().visible().get();
        assertEquals(resultsActivity.getString(R.string.attempts_load_error_message), ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void shouldShowSuccessMessageToUser() {
        resultsActivity = Robolectric.buildActivity(ResultActivity.class).create().visible().get();
        TextView successMessage = (TextView) resultsActivity.findViewById(R.id.result_success_message);
        assertEquals(resultsActivity.getString(R.string.result_success_message), successMessage.getText());
    }

    @Test
    public void shouldHaveButtonConfiguredOnCreate() {
        resultsActivity = Robolectric.buildActivity(ResultActivity.class).withIntent(buildIntent()).create().visible().get();
        Button button = (Button) resultsActivity.findViewById(R.id.result_continue_button);
        assertEquals(resultsActivity.getString(R.string.result_continue_button), button.getText());
    }

    @Test
    public void shouldDisplayNumberOfAttemptsItTookToUserWhenPassedInIntent() {
        resultsActivity = Robolectric.buildActivity(ResultActivity.class).withIntent(buildIntent()).create().visible().get();
        TextView attemptsView = (TextView) resultsActivity.findViewById(R.id.result_number_of_attempts);
        assertEquals(resultsActivity.getString(R.string.result_number_of_attempts, 15), attemptsView.getText());
    }

    @Test
    public void shouldDisplayBetterTriesAttemptsItTookToUserWhenNotPassedInIntent() {
        resultsActivity = Robolectric.buildActivity(ResultActivity.class).create().visible().get();
        TextView attemptsView = (TextView) resultsActivity.findViewById(R.id.result_number_of_attempts);
        assertEquals(resultsActivity.getString(R.string.result_try_less_attempts), attemptsView.getText());
    }

    @Test
    public void shouldFinishActivityAndStartMainActivityOnContinueButtonPressed() {
        resultsActivity = Robolectric.buildActivity(ResultActivity.class).withIntent(buildIntent()).create().visible().get();
        Button button = (Button) resultsActivity.findViewById(R.id.result_continue_button);
        button.performClick();
        ShadowActivity shadow = shadowOf(resultsActivity);
        Intent nextIntent = shadow.peekNextStartedActivity();
        assertEquals(MainActivity.class.getName(), nextIntent.getComponent().getClassName());
        assertEquals(Intent.FLAG_ACTIVITY_CLEAR_TOP, nextIntent.getFlags());
    }

    private Intent buildIntent() {
        Intent intent = new Intent(getApplication(), ResultActivity.class);
        intent.putExtra(ResultActivity.NUMBER_OF_ATTEMPTS_EXTRA, 15);
        return intent;
    }

}