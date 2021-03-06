package com.example.rachelhutchison.guessinggame.ui.components;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rachelhutchison.guessinggame.MockImageRestService;
import com.example.rachelhutchison.guessinggame.R;
import com.example.rachelhutchison.guessinggame.RobolectricUnitTests;
import com.example.rachelhutchison.guessinggame.model.DefaultImage;
import com.example.rachelhutchison.guessinggame.model.FanDuelResponse;
import com.example.rachelhutchison.guessinggame.model.Player;
import com.example.rachelhutchison.guessinggame.model.PlayerImage;
import com.example.rachelhutchison.guessinggame.ui.GuessingActivity;
import com.squareup.picasso.Picasso;

import org.junit.Test;
import org.robolectric.Robolectric;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayersFragmentTest extends RobolectricUnitTests {

    private GuessingActivity activity;
    private String FIRSTNAME_BOBBY = "Bobby";
    private String LASTNAME_SMITH = "Smith";
    private double FPPG_RATING = 14.41463464;
    private double DISPLAY_FPPG_RATING = 14.415;
    private String URL = "urls";

    @Test
    public void willPopulatePlayerNameWhenPassedIn() {
        activity = buildActivity();
        TextView playerNameView = (TextView) activity.findViewById(R.id.player_name);
        assertEquals(FIRSTNAME_BOBBY + " " + LASTNAME_SMITH, playerNameView.getText());
    }

    @Test
    public void willPopulatePlayerFppgToThreeDecimalPlacesWhenPassedIn() {
        activity = buildActivity();
        TextView fppgRatingView = (TextView) activity.findViewById(R.id.player_fppg_rating);
        assertEquals(String.valueOf(DISPLAY_FPPG_RATING), fppgRatingView.getText());
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
    public void beforeImageLoadWillShowProgressIndicator() {
        activity = buildActivity();
        ProgressBar progressBar = (ProgressBar) activity.findViewById(R.id.player_progress_indicator);
        assertEquals(View.VISIBLE, progressBar.getVisibility());
    }

    @Test
    public void onSuccessPlayerImageLoadWillHaveVisibleImageViewAndGoneErrorImage() {
        MockImageRestService mockImageRestService = new MockImageRestService();
        Picasso mockPicasso = mockImageRestService.buildMockRestService(mockImageRestService.getSuccessResponse);
        getApplication().setImageService(mockPicasso);
        activity = buildActivity();
        ImageView playerImage = (ImageView) activity.findViewById(R.id.players_image);
        ImageView errorImage = (ImageView) activity.findViewById(R.id.error_image);
        ProgressBar progressBar = (ProgressBar) activity.findViewById(R.id.player_progress_indicator);
        assertEquals(View.VISIBLE, playerImage.getVisibility());
        assertEquals(View.GONE, errorImage.getVisibility());
        assertEquals(View.GONE, progressBar.getVisibility());
    }

    @Test
    public void onFailurePlayerImageLoadWillHaveGoneImageViewAndVisibleErrorImage() {
        MockImageRestService mockImageRestService = new MockImageRestService();
        Picasso mockPicasso = mockImageRestService.buildMockRestService(mockImageRestService.getErrorResponse);
        getApplication().setImageService(mockPicasso);
        activity = buildActivity();
        ImageView playerImage = (ImageView) activity.findViewById(R.id.players_image);
        ImageView errorImage = (ImageView) activity.findViewById(R.id.error_image);
        ProgressBar progressBar = (ProgressBar) activity.findViewById(R.id.player_progress_indicator);
        assertEquals(View.GONE, playerImage.getVisibility());
        assertEquals(View.VISIBLE, errorImage.getVisibility());
        assertEquals(View.GONE, progressBar.getVisibility());
    }

    @Test
    public void successPlayerLoadPlayerImageAndNameWillBeClickAble() {
        MockImageRestService mockImageRestService = new MockImageRestService();
        Picasso mockPicasso = mockImageRestService.buildMockRestService(mockImageRestService.getSuccessResponse);
        getApplication().setImageService(mockPicasso);
        activity = buildActivity();
        ImageView playerImage = (ImageView) activity.findViewById(R.id.players_image);
        ImageView errorImage = (ImageView) activity.findViewById(R.id.error_image);
        TextView playerName = (TextView) activity.findViewById(R.id.player_name);
        assertTrue(playerImage.isClickable());
        assertFalse(errorImage.isClickable());
        assertTrue(playerName.isClickable());
    }

    @Test
    public void onFailurePlayerImageLoadErrorImageWillBeClickableAndName() {
        MockImageRestService mockImageRestService = new MockImageRestService();
        Picasso mockPicasso = mockImageRestService.buildMockRestService(mockImageRestService.getErrorResponse);
        getApplication().setImageService(mockPicasso);
        activity = buildActivity();
        ImageView playerImage = (ImageView) activity.findViewById(R.id.players_image);
        ImageView errorImage = (ImageView) activity.findViewById(R.id.error_image);
        TextView playerName = (TextView) activity.findViewById(R.id.player_name);
        assertFalse(playerImage.isClickable());
        assertTrue(errorImage.isClickable());
        assertTrue(playerName.isClickable());
    }

    private GuessingActivity buildActivity() {
        Intent intent = new Intent(getApplication(), GuessingActivity.class);
        intent.putExtra(GuessingActivity.PLAYERS_DATA_EXTRA, buildFanDuelResponseWithOnlyOnePlayer());
        return Robolectric.buildActivity(GuessingActivity.class).withIntent(intent).create().start().get();
    }

    private FanDuelResponse buildFanDuelResponseWithOnlyOnePlayer() {
        FanDuelResponse fanDuelResponse = new FanDuelResponse();
        List<Player> players = new ArrayList<>();
        players.add(buildPlayer());
        fanDuelResponse.setPlayers(players);
        return fanDuelResponse;
    }

    private Player buildPlayer() {
        Player player = new Player();
        player.setFirstName(FIRSTNAME_BOBBY);
        player.setLastName(LASTNAME_SMITH);
        player.setFppg(FPPG_RATING);
        player.setImages(buildPlayerImages());
        return player;
    }

    private PlayerImage buildPlayerImages() {
        PlayerImage images = new PlayerImage();
        DefaultImage defaultImage = new DefaultImage();
        defaultImage.setUrl(URL);
        images.setDefaultImage(defaultImage);
        return images;
    }
}