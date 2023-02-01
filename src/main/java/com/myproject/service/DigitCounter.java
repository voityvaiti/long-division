package com.myproject.service;

public class DigitCounter {
    public static int countDigit(int i) {
        if(i==0) {
            return 1;
        }

        return (int) Math.log10(Math.abs(i)) + 1;
    }
}

