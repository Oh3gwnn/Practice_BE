package com.example.tutoopjdbc.out;

public class TSNGame {
    private static String clapCount(int i) {
        if ((i%10%3 == 0) && (i%10 != 0)) return "*";
        else if ((i/10%3 == 0) && (i/10 != 0)) return "*";
        else return "";
    }
    public static void game369() {
        for (int i = 1; i < 100; i++) {
            System.out.printf("%02d%2s ", i, clapCount(i));
            if ((i%10 == 0) && (i != 0)) System.out.println();
        }
    }
}
