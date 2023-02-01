package com.myproject.longdivision;

import static com.myproject.longdivision.LongDivisionDecorationValues.*;
import static com.myproject.service.DigitCounter.countDigit;

public class LongDivisionViewModifier {

    protected LongDivisionViewModifier() {
    }

    protected StringBuilder modifyToView(StringBuilder strToModify, int dividend, int divisor) {

        replaceFirstLineByDividend(strToModify, dividend);

        int[] endLinePositions = getIndexesOfFirstThreeLinesEnd(strToModify);


        int quotient = dividend / divisor;
        int newlineCharLength = 2;

        int spacesAfterSecondLine = (countDigit(dividend) + newlineCharLength)
                - (endLinePositions[2] - endLinePositions[1]);

        int spacesAfterThirdLine = (countDigit(dividend) + newlineCharLength)
                - (endLinePositions[1] - endLinePositions[0]);

        strToModify.insert(endLinePositions[2], SPACE.repeat(spacesAfterSecondLine) +
                VERTICAL_LINE + quotient);
        strToModify.insert(endLinePositions[1], SPACE.repeat(spacesAfterThirdLine) +
                VERTICAL_LINE + HORIZONTAL_LINE.repeat(countDigit(quotient)));
        strToModify.insert(endLinePositions[0], VERTICAL_LINE + divisor);


        return strToModify;
    }

    private void replaceFirstLineByDividend(StringBuilder strToModify, int dividend) {
        for (int i = 0; i < strToModify.length(); i++) {

            String currentChar = Character.toString(
                    strToModify.charAt(i));

            if (currentChar.equals(NEW_LINE)) {
                strToModify.replace(0, i, UNDERSCORE + dividend);
                break;
            }
        }
    }

    private int[] getIndexesOfFirstThreeLinesEnd(StringBuilder str) {
        int amountOfEndLines = 3;
        int indexOfEndLine = 0;

        int[] endLinePositions = new int[amountOfEndLines];

        for (int i = 0; i < str.length(); i++) {
            String currentChar = Character.toString(
                    str.charAt(i));

            if (currentChar.equals(NEW_LINE)) {
                endLinePositions[indexOfEndLine] = i;
                indexOfEndLine++;
            }

            if (indexOfEndLine == amountOfEndLines) {
                break;
            }
        }
        return endLinePositions;
    }

}