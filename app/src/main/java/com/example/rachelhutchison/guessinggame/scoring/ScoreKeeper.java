package com.example.rachelhutchison.guessinggame.scoring;

public class ScoreKeeper {

    private static final int GAME_END_LIMIT = 10;
    private int correctGuesses;
    private int incorrectGuesses;

    public int getCorrectGuesses() {
        return correctGuesses;
    }

    public void setCorrectGuesses(int correctGuesses) {
        this.correctGuesses = correctGuesses;
    }

    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public void increaseScore(boolean correct) {
        if (correct) {
            correctGuesses++;
        } else {
            incorrectGuesses++;
        }
    }

    public int getNumberTries() {
        return correctGuesses + incorrectGuesses;
    }

    public boolean isGameComplete() {
        return correctGuesses >= GAME_END_LIMIT;
    }
}
