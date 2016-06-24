package com.example.rachelhutchison.guessinggame.ui.components;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rachelhutchison.guessinggame.MockImageRestService;
import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.RobolectricUnitTests;
import com.example.rachelhutchison.guessinggame.ui.GuessingActivity;
import com.squareup.picasso.Picasso;

import org.junit.Test;
import org.robolectric.Robolectric;

import static org.junit.Assert.assertEquals;

public class PlayersFragmentTest extends RobolectricUnitTests {

    private GuessingActivity activity;

    @Test
    public void willPopulatePlayerNameWhenPassedIn() {
        activity = buildActivity();
        TextView playerNameView = (TextView) activity.findViewById(R.id.player_name);
        assertEquals(activity.playerName, playerNameView.getText());
    }

    @Test
    public void willPopulatePlayerFppgWhenPassedIn() {
        activity = buildActivity();
        TextView fppgRatingView = (TextView) activity.findViewById(R.id.player_fppg_rating);
        assertEquals(activity.fppg, fppgRatingView.getText());
    }

    @Test
    public void playerNameViewWillBeVisibleOnCreate() {
        activity = buildActivity();
        TextView playerNameView = (TextView) activity.findViewById(R.id.player_name);
        assertEquals(View.VISIBLE, playerNameView.getVisibility());
    }

    @Test
    public void fppgRatingViewWillBeInvisibleOnCreate() {
        activity = buildActivity();
        TextView fppgRatingView = (TextView) activity.findViewById(R.id.player_fppg_rating);
        assertEquals(View.INVISIBLE, fppgRatingView.getVisibility());
    }

    @Test
    public void onSuccessPlayerImageLoadWillHaveVisibleImageViewAndGoneErrorImage() {
        MockImageRestService mockImageRestService = new MockImageRestService();
        Picasso mockPicasso = mockImageRestService.buildMockRestService(mockImageRestService.getSuccessResponse);
        getApplication().setImageService(mockPicasso);
        activity = buildActivity();
        ImageView playerImage = (ImageView) activity.findViewById(R.id.players_image);
        ImageView errorImage = (ImageView) activity.findViewById(R.id.error_image);
        assertEquals(View.VISIBLE, playerImage.getVisibility());
        assertEquals(View.GONE, errorImage.getVisibility());
    }

    @Test
    public void onFailurePlayerImageLoadWillHaveGoneImageViewAndVisibleErrorImage() {
        MockImageRestService mockImageRestService = new MockImageRestService();
        Picasso mockPicasso = mockImageRestService.buildMockRestService(mockImageRestService.getErrorResponse);
        getApplication().setImageService(mockPicasso);
        activity = buildActivity();
        ImageView playerImage = (ImageView) activity.findViewById(R.id.players_image);
        ImageView errorImage = (ImageView) activity.findViewById(R.id.error_image);
        assertEquals(View.GONE, playerImage.getVisibility());
        assertEquals(View.VISIBLE, errorImage.getVisibility());
    }

    private GuessingActivity buildActivity() {
        return Robolectric.buildActivity(GuessingActivity.class).create().start().get();
    }

}