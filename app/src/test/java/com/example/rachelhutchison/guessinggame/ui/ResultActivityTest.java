package com.example.rachelhutchison.guessinggame.ui;

import android.content.Intent;
import android.widget.TextView;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.RobolectricUnitTests;

import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertEquals;

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

    private Intent buildIntent() {
        Intent intent = new Intent(getApplication(), ResultActivity.class);
        intent.putExtra(ResultActivity.NUMBER_OF_ATTEMPTS_EXTRA, 15);
        return intent;
    }

}