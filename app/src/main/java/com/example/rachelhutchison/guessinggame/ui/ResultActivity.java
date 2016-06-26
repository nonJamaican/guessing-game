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
        displayErrorMessageIfInvalidAttempt();
        configureAttemptMessage();
    }

    public void continuePressed(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void displayErrorMessageIfInvalidAttempt() {
        if (isAttemptsInvalid()) {
            displayErrorMessage();
        }
    }

    private boolean isAttemptsInvalid() {
        return numberOfAttempts == DEFAULT_ATTEMPTS;
    }

    private void configureAttemptMessage() {
        TextView attemptsView = (TextView) findViewById(R.id.result_number_of_attempts);
        attemptsView.setText(createAttemptsMessage());
    }

    private void extractExtras() {
        numberOfAttempts = getIntent().getIntExtra(NUMBER_OF_ATTEMPTS_EXTRA, DEFAULT_ATTEMPTS);
    }

    private void displayErrorMessage() {
        Toast.makeText(this, R.string.attempts_load_error_message, Toast.LENGTH_LONG).show();
    }

    private String createAttemptsMessage() {
        return isAttemptsInvalid() ? retrieveTryLessAttempts() : retrieveNumberOfAttempts();
    }

    private String retrieveNumberOfAttempts() {
        return getString(R.string.result_number_of_attempts, numberOfAttempts);
    }

    private String retrieveTryLessAttempts() {
        return getString(R.string.result_try_less_attempts);
    }

}
