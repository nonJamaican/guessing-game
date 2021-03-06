package com.example.rachelhutchison.guessinggame.scoring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScoreKeeperTest {

    private ScoreKeeper scoreKeeper;

    @Before
    public void setUp() {
        scoreKeeper = new ScoreKeeper();
    }

    @Test
    public void correctGuessesWhenCreatedWillBeZero() {
        assertEquals(0, scoreKeeper.getCorrectGuesses());
    }

    @Test
    public void incorrectGuessesWhenCreatedWillBeZero() {
        assertEquals(0, scoreKeeper.getIncorrectGuesses());
    }

    @Test
    public void increaseScoreWithCorrectGuessWillIncreaseCorrectByOne() {
        scoreKeeper.increaseScore(true);
        assertEquals(1, scoreKeeper.getCorrectGuesses());
    }

    @Test
    public void increaseScoreWithCorrectGuessNotChangeIncorrectGuesses() {
        scoreKeeper.increaseScore(true);
        assertEquals(0, scoreKeeper.getIncorrectGuesses());
    }

    @Test
    public void increaseScoreWithWrongGuessWillIncreaseIncorrectByOne() {
        scoreKeeper.increaseScore(false);
        assertEquals(1, scoreKeeper.getIncorrectGuesses());
    }

    @Test
    public void increaseScoreWithWrongGuessNotChangeCorrectGuesses() {
        scoreKeeper.increaseScore(false);
        assertEquals(0, scoreKeeper.getCorrectGuesses());
    }

    @Test
    public void increaseScoreWithTwoWrongGuessesIncreasesIncorrectGuessesByTwo() {
        scoreKeeper.increaseScore(false);
        scoreKeeper.increaseScore(false);
        assertEquals(2, scoreKeeper.getIncorrectGuesses());
    }

    @Test
    public void increaseScoreWithTwoCorrectGuessesIncreasesCorrectGuessesByTwo() {
        scoreKeeper.increaseScore(true);
        scoreKeeper.increaseScore(true);
        assertEquals(2, scoreKeeper.getCorrectGuesses());
    }

    @Test
    public void increaseScoreWithOneCorrectOneWrongGuessesIncreasesCorrectByOneIncorrectByOne() {
        scoreKeeper.increaseScore(false);
        scoreKeeper.increaseScore(true);
        assertEquals(1, scoreKeeper.getCorrectGuesses());
        assertEquals(1, scoreKeeper.getIncorrectGuesses());
    }

    @Test
    public void getTriesWillReturnZerosAtStart() {
        assertEquals(0, scoreKeeper.getNumberTries());
    }

    @Test
    public void getTriesWillReturnOneWhenIncorrectOneAndCorrectZero() {
        scoreKeeper.increaseScore(false);
        assertEquals(1, scoreKeeper.getNumberTries());
    }

    @Test
    public void getTriesWillReturnTwoWhenIncorrectOneAndCorrectOne() {
        scoreKeeper.increaseScore(true);
        scoreKeeper.increaseScore(false);
        assertEquals(2, scoreKeeper.getNumberTries());
    }

    @Test
    public void isGameCompleteWillReturnFalseWhenCorrectGuessesNine() {
        scoreKeeper.setCorrectGuesses(9);
        assertFalse(scoreKeeper.isGameComplete());
    }

    @Test
    public void isGameCompleteWillReturnFalseWhenCorrectGuessesTen() {
        scoreKeeper.setCorrectGuesses(10);
        assertTrue(scoreKeeper.isGameComplete());
    }
}