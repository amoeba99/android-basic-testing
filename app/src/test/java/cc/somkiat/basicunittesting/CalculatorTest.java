package cc.somkiat.basicunittesting;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void OnePlusNineResultTen(){
        Calculator calculator = new Calculator();
        int result = calculator.plus(1, 9);
        assertEquals(10, result);
    }

    @Test
    public void SixPlusSevenResultThirteen(){
        Calculator calculator = new Calculator();
        int result = calculator.plus(6, 7);
        assertEquals(13, result);
    }
}
