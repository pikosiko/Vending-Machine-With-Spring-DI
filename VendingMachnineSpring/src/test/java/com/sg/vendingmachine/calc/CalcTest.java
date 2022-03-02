package com.sg.vendingmachine.calc;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.sg.vendingmachine.calc.Calc.*;
import static org.junit.jupiter.api.Assertions.*;


//import static com.calc.Calc.*;


class CalcTest {



    @Test
    public void calcCorrectChangeOneEuro(){

        int expected = 2;
        BigDecimal bd = new BigDecimal("200");
        int actual = calcOneEuros(bd);

        assertEquals(expected,actual, "Expected 2, We got" + actual);
    }

    @Test
    public void calcCorrectChangeFiftyC(){

        int expected = 4;

        int actual = CalcFiftyC(220);

        assertEquals(expected,actual, "Expected: "+expected+", We got" + actual);


    }

    @Test
    public void calcCorrectChangeTwentyC(){

        int expected = 11;

        int actual = calcTwentyC(220);

        assertEquals(expected,actual, "Expected 2, We got" + actual);


    }

    @Test
    public void calcCorrectChangeTenC(){

        int expected = 22;

        int actual = calcTenC(220);

        assertEquals(expected,actual, "Expected 2, We got" + actual);


    }

}
