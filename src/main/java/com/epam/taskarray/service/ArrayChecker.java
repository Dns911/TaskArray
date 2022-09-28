package com.epam.taskarray.service;

public class ArrayChecker {
    public static void arrayChecker (int[] arr){
        if (arr == null){
            throw new NullPointerException("Array is NULL");
        }
        if (arr.length == 0){
            throw new NullPointerException("Array length = 0");
        }
    }
    public static void arrayIndexChecker (int[] array, int index){
        if (index < 0 || index >= array.length){
            throw new ArrayIndexOutOfBoundsException("Index out of array bounds");
        }
    }
}
