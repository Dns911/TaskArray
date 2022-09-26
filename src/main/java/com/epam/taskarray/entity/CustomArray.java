package com.epam.taskarray.entity;

import com.epam.taskarray.exception.ArrayException;

import java.util.Arrays;

public class CustomArray {
    private int[] array;

    public CustomArray() {
    }

    public CustomArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getElement (int index) throws ArrayException {
        if (index < 0 || index >= array.length){
            throw new ArrayException("Index out of array bounds");
        }
        return array[index];
    }

    public void setElement (int value, int index) throws ArrayException {
        if (index < 0 || index >= array.length){
            throw new ArrayException("Index out of array bounds");
        }
        array[index] = value;
    }

    public int size(){
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
        return "CustomArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
