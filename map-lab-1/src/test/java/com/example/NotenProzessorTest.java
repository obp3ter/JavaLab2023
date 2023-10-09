package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NotenProzessorTest {

    public static final String SHOULD_BE_EQUAL = "Soll gleich sein";

    private NotenProzessor notenProzessor;

    @Before
    public void init() {
        notenProzessor = new NotenProzessor();
    }

    @Test
    public void addToArrayTest() {
        int[] noten = new int[] { 10, 20, 30 };
        int newElement = 50;

        int[] result = notenProzessor.addToArray(noten, newElement);

        int[] expected = new int[] { 10, 20, 30, 50 };

        assertArrayEquals(SHOULD_BE_EQUAL, expected, result);
    }

}