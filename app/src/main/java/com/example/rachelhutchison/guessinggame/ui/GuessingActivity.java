package com.example.rachelhutchison.guessinggame.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rachelhutchison.guessinggame.R;

public class GuessingActivity extends AppCompatActivity {

    public static final String PLAYERS_DATA_EXTRA = "PLAYERS_DATA_EXTRA";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game);
    }
}
