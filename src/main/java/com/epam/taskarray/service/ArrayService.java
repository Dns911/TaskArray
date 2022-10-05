package com.epam.taskarray.service;

import com.epam.taskarray.entity.CustomArray;

public interface ArrayService {
    int minValue(CustomArray arr);

    int maxValue(CustomArray arr);

    int[] changeIf(CustomArray arr, int findValue, int changeValue);

    double average(CustomArray arr);

    int sumArray(CustomArray arr);

    int countPositive(CustomArray arr);

    int countNegative(CustomArray arr);

    CustomArray recursiveQuickSort(CustomArray arr);
}
