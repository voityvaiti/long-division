package com.myproject.service;

public class DigitGetter {
    private int currentPosition = -1;
    private final char[] charsOfDividend;

    public DigitGetter(Integer dividend) {
        charsOfDividend = dividend.toString().toCharArray();
    }

    public String getNextNumber() {
        if (currentPosition + 1 < charsOfDividend.length) {
            currentPosition++;
            return String.valueOf(charsOfDividend[currentPosition]);
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        return charsOfDividend.length > currentPosition + 1;
    }

}
