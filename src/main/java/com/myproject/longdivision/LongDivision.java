package com.myproject.longdivision;

import com.myproject.service.DigitGetter;

import static com.myproject.longdivision.LongDivisionDecorationValues.*;
import static com.myproject.service.DigitCounter.countDigit;

public class LongDivision {

    private DigitGetter dividendDigitGetter;
    private int divisor;

    private int remainder;
    private int factor;

    public String divide(int dividend, int divisor) {

        if (divisor == 0) {
            return "Error! Division by zero";
        }

        dividendDigitGetter = new DigitGetter(dividend);
        this.divisor = divisor;

        StringBuilder divisionBuilder = new StringBuilder();
        int indentLength = 0;

        while (dividendDigitGetter.hasNext()) {

            updateRemainder();
            divisionBuilder.append(SPACE.repeat(indentLength)).append(UNDERSCORE).
                    append(remainder).append(NEW_LINE);

            updateFactor();
            divisionBuilder.append(SPACE.repeat(indentLength + UNDERSCORE.length())).
                    append(factor).append(NEW_LINE);

            divisionBuilder.append(SPACE.repeat(indentLength + UNDERSCORE.length())).
                    append(HORIZONTAL_LINE.repeat(countDigit(remainder))).append(NEW_LINE);

            remainder = remainder - factor;

            indentLength = updateIndentLength(indentLength);
        }


        divisionBuilder.append(SPACE.repeat(indentLength)).append(remainder).append(NEW_LINE);

        StringBuilder modifiedDivisionBuilder = new LongDivisionViewModifier().
                modifyToView(divisionBuilder, dividend, divisor);

        return modifiedDivisionBuilder.toString();
    }

    public void updateRemainder() {
        while (remainder < divisor) {

            if (dividendDigitGetter.hasNext()) {
                remainder = Integer.parseInt(remainder +
                        dividendDigitGetter.getNextNumber());
            } else {
                break;
            }

        }
    }

    public void updateFactor() {
        factor = 0;

        while (factor + divisor <= remainder) {
            factor = factor + divisor;
        }
    }

    public int updateIndentLength(int indentLength) {
        if (remainder == 0 || factor == 0) {
            indentLength += countDigit(factor);
        } else {
            indentLength += countDigit(factor) - countDigit(remainder);
        }
        return indentLength;
    }
}
