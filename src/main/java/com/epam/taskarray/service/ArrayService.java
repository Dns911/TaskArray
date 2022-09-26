package com.epam.taskarray.service;

import com.epam.taskarray.entity.CustomArray;

public class ArrayService {
    public int minValue (CustomArray arr){
        int[] a = arr.getArray();
        int min = a[0];
        for (int i = 1; i < a.length; i++){
            if (min > a[i]){
                min = a[i];
            }
        }
        return min;
    }
    public int maxValue (CustomArray arr){
        int[] a = arr.getArray();
        int max = a[0];
        for (int i = 1; i < a.length; i++){
            if (max < a[i]){
                max = a[i];
            }
        }
        return max;
    }
    public int[] changeIf (CustomArray arr, int findValue, int changeValue){
        int[] a = arr.getArray();
        for (int i = 1; i < a.length; i++){
            if (a[i] == findValue){
                a[i] = changeValue;
            }
        }
        return a;
    }
    public double average (CustomArray arr){
        int[] a = arr.getArray();
        int sum = 0;
        for (int i = 1; i < a.length; i++){
            sum += a[i];
        }
        return (double) sum / a.length;
    }
    public int sumArray (CustomArray arr){
        int[] a = arr.getArray();
        int sum = 0;
        for (int i = 1; i < a.length; i++){
            sum += a[i];
        }
        return sum;
    }
    public int countPositive (CustomArray arr){
        int[] a = arr.getArray();
        int count = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] > 0){
                count++;
            }
        }
        return count;
    }
    public int countNegative (CustomArray arr){
        int[] a = arr.getArray();
        int count = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] < 0){
                count++;
            }
        }
        return count;
    }
    public CustomArray recursiveQuickSort(CustomArray arr) {
        int[] a = arr.getArray();
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
