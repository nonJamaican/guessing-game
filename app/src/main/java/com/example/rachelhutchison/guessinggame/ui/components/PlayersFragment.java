package com.example.rachelhutchison.guessinggame.ui.components;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rachelhutchison.guessinggame.MyApplication;
import com.example.rachelhutchison.guessinggame.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PlayersFragment extends Fragment {

    private static final String PLAYER_NAME_EXTRA = "PLAYER_NAME_EXTRA";
    private static final String FPPG_RATING_EXTRA = "FPPG_RATING_EXTRA";
    private static final String IMAGE_URL_EXTRA = "IMAGE_URL_EXTRA";
    private TextView playerNameView;
    private TextView fppgRatingView;
    private ImageView playerImageView;
    private String fppgRating;
    private String playerName;
    private String imageUrl;
    private ImageView errorImageView;

    public PlayersFragment() {

    }

    public static PlayersFragment newInstance(String imageUrl, String playerName, String fppgRating) {
        Bundle args = new Bundle();
        args.putString(IMAGE_URL_EXTRA, imageUrl);
        args.putString(PLAYER_NAME_EXTRA, playerName);
        args.putString(FPPG_RATING_EXTRA, fppgRating);
        PlayersFragment fragment = new PlayersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_player, container, false);
        configureViews(inflatedView);
        extractSuppliedArguments();
        setViewText(playerNameView, playerName);
        setViewText(fppgRatingView, fppgRating);
        configureImageView();
        return inflatedView;
    }

    private void configureImageView() {
        Activity context = getActivity();
        if (context == null) {
            setPlayerImageVisible(false);
        } else {
            // new never used before, interested to see how it works. :)
            makeImageRequest(getImageService(context), imageUrl, playerImageView);
        }
    }

    private Picasso getImageService(Activity context) {
        MyApplication application = (MyApplication) context.getApplication();
        return application.getImageService();
    }

    protected void configureViews(View inflatedView) {
        playerNameView = (TextView) inflatedView.findViewById(R.id.player_name);
        fppgRatingView = (TextView) inflatedView.findViewById(R.id.player_fppg_rating);
        playerImageView = (ImageView) inflatedView.findViewById(R.id.players_image);
        errorImageView = (ImageView) inflatedView.findViewById(R.id.error_image);
    }

    private void setViewText(TextView view, String text) {
        view.setText(text);
    }

    private void extractSuppliedArguments() {
        imageUrl = getArguments().getString(IMAGE_URL_EXTRA);
        playerName = getArguments().getString(PLAYER_NAME_EXTRA);
        fppgRating = getArguments().getString(FPPG_RATING_EXTRA);
    }

    private void makeImageRequest(Picasso picasso, String url, final ImageView target) {
        picasso.load(url).into(target, new Callback() {
            @Override
            public void onSuccess() {
                setPlayerImageVisible(true);
            }

            @Override
            public void onError() {
                setPlayerImageVisible(false);
            }
        });
    }

    private void setPlayerImageVisible(boolean visible) {
        playerImageView.setVisibility(visible ? View.VISIBLE : View.GONE);
        errorImageView.setVisibility(visible ? View.GONE : View.VISIBLE);
    }
}
