package com.epam.taskarray.observer.service;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.service.ArrayService;
import com.epam.taskarray.service.impl.ArrayServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayServiceTest {
    static final Logger logger = LogManager.getLogger();
    public ArrayService arrayService = new ArrayServiceImpl();

    @BeforeClass
    public void beforeClass() {

    }

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
        CustomArray expected = new CustomArray(new int[]{1, 5, 7, 9});
        CustomArray customArray = new CustomArray(new int[]{7, 9, 1, 5});
        CustomArray actual = arrayService.recursiveQuickSort(customArray);
        Assert.assertEquals(actual, expected, "Test pass");
    }
}