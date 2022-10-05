package com.epam.taskarray.service.impl;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.validator.ArrayChecker;
import com.epam.taskarray.service.ArrayService;

public class ArrayServiceImpl implements ArrayService {
    @Override
    public int minValue(CustomArray arr){
        int[] a = arr.getArray();
        ArrayChecker.arrayChecker(a);
        int min = a[0];
        for (int i = 1; i < a.length; i++){
            if (min > a[i]){
                min = a[i];
            }
        }
        return min;
    }
    @Override
    public int maxValue(CustomArray arr){
        int[] a = arr.getArray();
        ArrayChecker.arrayChecker(a);
        int max = a[0];
        for (int i = 1; i < a.length; i++){
            if (max < a[i]){
                max = a[i];
            }
        }
        return max;
    }
    @Override
    public int[] changeIf(CustomArray arr, int findValue, int changeValue){
        int[] a = arr.getArray();
        ArrayChecker.arrayChecker(a);
        for (int i = 1; i < a.length; i++){
            if (a[i] == findValue){
                a[i] = changeValue;
            }
        }
        return a;
    }
    @Override
    public double average(CustomArray arr){
        int[] a = arr.getArray();
        ArrayChecker.arrayChecker(a);
        int sum = 0;
        for (int i = 1; i < a.length; i++){
            sum += a[i];
        }
        return (double) sum / a.length;
    }
    @Override
    public int sumArray(CustomArray arr){
        int[] a = arr.getArray();
        ArrayChecker.arrayChecker(a);
        int sum = 0;
        for (int i = 1; i < a.length; i++){
            sum += a[i];
        }
        return sum;
    }
    @Override
    public int countPositive(CustomArray arr){
        int[] a = arr.getArray();
        ArrayChecker.arrayChecker(a);
        int count = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] > 0){
                count++;
            }
        }
        return count;
    }
    @Override
    public int countNegative(CustomArray arr){
        int[] a = arr.getArray();
        ArrayChecker.arrayChecker(a);
        int count = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] < 0){
                count++;
            }
        }
        return count;
    }
    @Override
    public CustomArray recursiveQuickSort(CustomArray arr) {
        int[] a = arr.getArray();
        ArrayChecker.arrayChecker(a);
        if (a.length != 0) {
            int leftIndex = 0;
            int rightIndex = a.length - 1;
            sortArray(a, leftIndex, rightIndex);
        }
        arr.setArray(a);
        return arr;
    }
    private int[] sortArray(int[] array, int leftIndex, int rightIndex) {
        int i = leftIndex;
        int j = rightIndex;
        int pivot = array[leftIndex];
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (leftIndex < j) {
            sortArray(array, leftIndex, j);
        }

        if (i < rightIndex) {
            sortArray(array, i, rightIndex);
        }

        return array;
    }
}
