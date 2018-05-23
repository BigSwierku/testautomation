package com.jsystems.testautomation;

public class GamePlay {



    public String play(int number) {
        if (number == 0) throw new IllegalArgumentException("Number can't be zero. Change number");

        if (number % 3 == 0) return "ok";
        if (number % 3 != 0) return "Not ok";
        return String.valueOf(number);

    }
}
