package com.example.rachelhutchison.guessinggame.ui;

import android.content.Intent;
import android.os.HandlerThread;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.rachelhutchison.guessinggame.MockRestService;
import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.RobolectricUnitTests;
import com.example.rachelhutchison.guessinggame.api.FanDuelService;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowLooper;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

public class MainActivityTest extends RobolectricUnitTests {

    private FanDuelService mockFanduelService;
    private MockRestService mockRestService;
    private MainActivity mainActivity;

    @Before
    public void setUp() {
        mockRestService = new MockRestService();
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
    public void onSuccessfulGetPlayerDataRequestShouldEnableContinueButton() throws InterruptedException {
        mockFanduelService = mockRestService.buildMockRestService(mockRestService.getSuccessResponse);
        getApplication().setService(mockFanduelService);
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().visible().get();
        Button button = (Button) mainActivity.findViewById(R.id.continue_button);
        delayThreadForRestRequestResponse();
        assertTrue(button.isEnabled());
    }

    @Test
    public void onFailureGetPlayersDataRequestShouldShowToastMessage() throws InterruptedException {
        mockFanduelService = mockRestService.buildMockRestService(mockRestService.getFailureResponse);
        getApplication().setService(mockFanduelService);
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().visible().get();
        delayThreadForRestRequestResponse();

        ShadowLooper.idleMainLooper();
        assertEquals(mainActivity.getString(R.string.network_error_message), ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void onContinueButtonPressFromSuccessResponseShouldStartNextActivity() throws InterruptedException {
        mockFanduelService = mockRestService.buildMockRestService(mockRestService.getSuccessResponse);
        getApplication().setService(mockFanduelService);
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().visible().get();
        Button button = (Button) mainActivity.findViewById(R.id.continue_button);
        delayThreadForRestRequestResponse();
        button.callOnClick();

        ShadowActivity shadow = shadowOf(mainActivity);
        Intent nextIntent = shadow.peekNextStartedActivity();
        assertEquals(GuessingActivity.class.getName(), nextIntent.getComponent().getClassName());
    }

    private void delayThreadForRestRequestResponse() throws InterruptedException {
        // todo I really dislike this Thread.sleep()
        HandlerThread.sleep(3000);
        Robolectric.getForegroundThreadScheduler().advanceToLastPostedRunnable();
    }

}