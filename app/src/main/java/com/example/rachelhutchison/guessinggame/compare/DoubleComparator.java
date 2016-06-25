package com.example.rachelhutchison.guessinggame.compare;

public class DoubleComparator {

    public static boolean isDoubleLarger(Double myDouble, Double compareTo) {
        int compare = Double.compare(myDouble, compareTo);
        return compare > 0;
    }
}
