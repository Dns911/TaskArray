package com.epam.taskarray.main;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void testMinusTen() {
        int expected = -7;
        Main maind = new Main();
        int actual = maind.minusTen(2);
        Assert.assertEquals(actual, expected);
    }
}