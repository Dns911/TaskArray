package com.epam.taskarray.repository;

import com.epam.taskarray.entity.CustomArray;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
    void add(CustomArray arr);

    void addList(List<CustomArray> arrList);

    void removeByIndex(int index);

    void updateByIndex(int index, CustomArray newArray);

    List<CustomArray> query(Specification specification);
    List<CustomArray> queryLambda(Specification specification);

    void sort(Comparator<CustomArray> comparator);

    @Override
    String toString();
}
