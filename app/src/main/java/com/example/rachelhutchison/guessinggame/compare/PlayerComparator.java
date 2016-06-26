package com.example.rachelhutchison.guessinggame.compare;

import com.example.rachelhutchison.guessinggame.model.Player;

public class PlayerComparator {

    public static final int EQUAL_RATING = 0;

    public static String getFullNameOfHighestFppgRating(Player player1, Player player2) {
        int compare = Double.compare(getFppgRating(player1), getFppgRating(player2));
        return compare == EQUAL_RATING ? null : getPlayersFullName(choosePlayer(player1, player2, compare));
    }

    protected static Player choosePlayer(Player player1, Player player2, int compare) {
        return playerOneHasHigherRating(compare) ? player1 : player2;
    }

    private static boolean playerOneHasHigherRating(int compare) {
        return compare > EQUAL_RATING;
    }

    private static String getPlayersFullName(Player player) {
        return player.getFirstName() + " " + player.getLastName();
    }

    private static Double getFppgRating(Player player) {
        return player.getFppg();
    }
}
