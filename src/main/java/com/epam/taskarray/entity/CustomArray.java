package com.epam.taskarray.entity;

import com.epam.taskarray.validator.ArrayChecker;
import com.epam.taskarray.exception.ArrayException;

import java.util.Arrays;

public class CustomArray {
    private int[] array;
    private String arrayName;

    public CustomArray(int[] array) {
        this.array = array;
        this.arrayName = "DEFAULT_NAME";
    }

    public CustomArray(int[] array, String arrayName) {
        this.array = array;
        this.arrayName = arrayName;
    }

    public CustomArray() {
    }

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getElement(int index) throws ArrayException {
        ArrayChecker.arrayIndexChecker(array, index);
        return array[index];
    }

    public void setElement(int value, int index) throws ArrayException {
        ArrayChecker.arrayIndexChecker(array, index);
        array[index] = value;
    }

    public int size() {
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomArray that)) return false;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return arrayName +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
