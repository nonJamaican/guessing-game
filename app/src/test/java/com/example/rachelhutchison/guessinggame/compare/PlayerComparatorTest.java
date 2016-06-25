package com.example.rachelhutchison.guessinggame.compare;

import com.example.rachelhutchison.guessinggame.model.Player;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PlayerComparatorTest {

    @Test
    public void willReturnFirstPlayerNameWhenFirstPlayerLargerFppgScore() {
        Player smallerPlayer = buildPlayer("smaller", "player", 12.54);
        Player largerPlayer = buildPlayer("largest", "fppg", 32.64241);
        assertEquals("largest fppg", PlayerComparator.getFullNameOfHighestFppgRating(smallerPlayer, largerPlayer));
    }

    @Test
    public void willReturnSecondPlayerNameWhenSecondPlayerLargerFppgScore() {
        Player smallerPlayer = buildPlayer("smaller", "player", 12.54);
        Player largerPlayer = buildPlayer("largest", "fppg", 32.64241);
        assertEquals("largest fppg", PlayerComparator.getFullNameOfHighestFppgRating(largerPlayer, smallerPlayer));
    }

    @Test
    public void willReturnNullWhenBothPlayersHaveSameFppgScore() {
        Player smallerPlayer = buildPlayer("smaller", "player", 12.54);
        Player samePlayer = buildPlayer("largest", "fppg", 12.54);
        assertNull(PlayerComparator.getFullNameOfHighestFppgRating(samePlayer, smallerPlayer));
    }

    private Player buildPlayer(String firstName, String lastName, double fppgRating) {
        Player player = new Player();
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setFppg(fppgRating);
        return player;
    }

}