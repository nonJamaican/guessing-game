package com.example.rachelhutchison.guessinggame.ui;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.RobolectricUnitTests;

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

}