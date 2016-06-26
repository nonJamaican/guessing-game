package com.example.rachelhutchison.guessinggame.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rachelhutchison.guessinggame.R;

public class ResultActivity extends AppCompatActivity {

    public static final String NUMBER_OF_ATTEMPTS_EXTRA = "NUMBER_OF_ATTEMPTS_EXTRA";
    private int numberOfAttempts;
    private int DEFAULT_ATTEMPTS = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        extractExtras();
        if (isAttemptsInvalid()) {
            displayErrorMessage();
        }
        configureAttemptMessage();
    }

    protected boolean isAttemptsInvalid() {
        return numberOfAttempts == DEFAULT_ATTEMPTS;
    }

    private void configureAttemptMessage() {
        TextView attemptsView = (TextView) findViewById(R.id.result_number_of_attempts);
        attemptsView.setText(getAttemptsMessage());
    }

    private void extractExtras() {
        numberOfAttempts = getIntent().getIntExtra(NUMBER_OF_ATTEMPTS_EXTRA, DEFAULT_ATTEMPTS);
    }

    private void displayErrorMessage() {
        Toast.makeText(this, R.string.attempts_load_error_message, Toast.LENGTH_LONG).show();
    }

    public String getAttemptsMessage() {
        return isAttemptsInvalid() ? getString(R.string.result_try_less_attempts) : getString(R.string.result_number_of_attempts, numberOfAttempts);
    }

    public void continuePressed(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
