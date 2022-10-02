package com.epam.taskarray.service;

import com.epam.taskarray.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayServiceTest {
public ArrayService arrayService = new ArrayService();
    @Test
    public void testMinValue() {
        int expected = -7;
        CustomArray customArray = new CustomArray(new int[]{1, -7});
        int actual = arrayService.minValue(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testMaxValue() {
        int expected = 1;
        CustomArray customArray = new CustomArray(new int[]{1, -7});
        int actual = arrayService.maxValue(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testRecursiveQuickSort() {
        CustomArray expected = new CustomArray(new int[]{1, 7, 5, 9});
        CustomArray customArray = new CustomArray(new int[]{7, 9, 1, 5});
        CustomArray actual = arrayService.recursiveQuickSort(customArray);
        Assert.assertEquals(actual, expected);
    }
}