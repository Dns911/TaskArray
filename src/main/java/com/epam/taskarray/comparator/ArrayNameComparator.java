package com.epam.taskarray.comparator;

import com.epam.taskarray.entity.CustomArray;

import java.util.Comparator;

public class ArrayNameComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return o1.getArrayName().compareTo(o2.getArrayName());
    }
}
