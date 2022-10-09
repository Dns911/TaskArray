package com.epam.taskarray.entity;

import com.epam.taskarray.observer.ArrayObserver;
import com.epam.taskarray.observer.impl.ArrayAvgMaxMinSumObserverImpl;
import com.epam.taskarray.validator.ArrayChecker;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.UUID;

public class CustomArray {
    private int[] array;
    private String arrayName;
    private final UUID arrayId = UUID.randomUUID();
    private final ArrayObserver observer = new ArrayAvgMaxMinSumObserverImpl();

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

    public UUID getArrayId() {
        return arrayId;
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
        notify(this);
    }

    public int getElement(int index) {
        ArrayChecker.arrayIndexChecker(array, index);
        return array[index];
    }

    public void setElement(int value, int index) {
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

    private void notify(CustomArray arr) {
        observer.updateArray(arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", " " + "[", "]")
                .add("CustomArrayName=<" + arrayName + ">")
                .add("numbers=" + Arrays.toString(array))
                .toString();
    }
}
