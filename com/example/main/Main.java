package com.example.main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NotenProzessor notenProzessor = new NotenProzessor();

        int[] noten = new int[] { 10, 20, 30, 39, 47, 48, 60 };

        System.out.println(Arrays.toString(notenProzessor.nichtAusreichendeNoten(noten)));
    }
}
