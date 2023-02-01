package com.myproject.longdivision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongDivisionTest {

    static LongDivision longDivision = new LongDivision();

    @Test
    void divide_printCorrectForm_ifAllParamsAreValid() {
        String expected = """
                        _14789│20
                         140  │———
                         ———  │739
                          _78
                           60
                           ——
                          _189
                           180
                           ———
                            9
                        """;
        assertEquals(expected, longDivision.divide(14789, 20));
    }

    @Test
    void divide_printCorrectForm_ifParamsAreBig() {
        String expected = """
                        _410893077│701
                         3505     │——————
                         ————     │586152
                         _6039
                          5608
                          ————
                          _4313
                           4206
                           ————
                           _1070
                            701
                            ————
                           _3697
                            3505
                            ————
                            _1927
                             1402
                             ————
                             525
                        """;

        assertEquals(expected, longDivision.divide(410893077, 701));

    }

    @Test
    void divide_printZeroAnswer_ifDividendLessThanDivisor() {
        String expected = """
                        _40│56
                         0 │—
                         ——│0
                         40
                        """;
        assertEquals(expected, longDivision.divide(40, 56));
    }

    @Test
    void divide_printNumberOneAnswer_ifDividendEqualsDivisor() {
        String expected = """
                        _555│555
                         555│—
                         ———│1
                           0
                        """;
        assertEquals(expected, longDivision.divide(555, 555));
    }

    @Test
    void divide_returnError_ifDivisorIsZero() {
        assertEquals("Error! Division by zero", longDivision.divide(5, 0));
    }
}