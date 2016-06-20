package com.example.rachelhutchison.guessinggame.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.RobolectricUnitTests;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MainActivityTest extends RobolectricUnitTests {

    private MainActivity mainActivity;

    @Before
    public void setUp() throws IOException {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().visible().get();
    }

    @Test
    public void shouldHaveButtonDisabledOnCreate() {
        Button button = (Button) mainActivity.findViewById(R.id.continue_button);
        assertFalse(button.isEnabled());
    }

    @Test
    public void shouldShowProgressIndicatorOnCreate() {
        ProgressBar progressIndicator = (ProgressBar) mainActivity.findViewById(R.id.progress_indicator);
        assertEquals(View.VISIBLE, progressIndicator.getVisibility());
    }

    @Test
    public void shouldOnSuccessfulGetPlayerDataRequestShouldEnableContinueButton() throws InterruptedException, IOException {
        //todo how to mock response from retrofit
    }

}