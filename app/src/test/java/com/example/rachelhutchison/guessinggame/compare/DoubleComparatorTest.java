package com.example.rachelhutchison.guessinggame.compare;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DoubleComparatorTest {

    @Test
    public void compareWithFirstDoubleLargerWillReturnTrue() {
        assertTrue(DoubleComparator.isDoubleLarger(0.0002, 0.0001));
    }

    @Test
    public void compareWithFirstDoubleLessWillReturnFalse() {
        assertFalse(DoubleComparator.isDoubleLarger(0.0001, 0.0002));
    }

    @Test
    public void compareWithSameDoublesWillReturnFalse() {
        assertFalse(DoubleComparator.isDoubleLarger(1.11, 1.11));
    }

}