package com.epam.taskarray.repository.impl;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.repository.ArrayRepository;
import com.epam.taskarray.repository.Specification;

import java.util.*;
import java.util.function.Predicate;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static ArrayRepository arrRepInstance;
    private final List<CustomArray> repository;

    private ArrayRepositoryImpl() {
        repository = new ArrayList<>();
    }

    public static ArrayRepository getInstance() {
        if (arrRepInstance == null) {
            arrRepInstance = new ArrayRepositoryImpl();
        }
        return arrRepInstance;
    }

    @Override
    public void add(CustomArray arr) {
        this.repository.add(arr);
    }

    @Override
    public void addList(List<CustomArray> arrList) {
        this.repository.addAll(arrList);
    }

    @Override
    public void removeByIndex(int index) {

        this.repository.remove(index);
    }

    @Override
    public void updateByIndex(int index, CustomArray newArray) {
        this.repository.remove(index);
        this.repository.add(index, newArray);
    }

    @Override
    public List<CustomArray> query(Specification specification) {
        List<CustomArray> result = new ArrayList<>();
        for (CustomArray arr : repository) {
            if (specification.specify(arr)) {
                result.add(arr);
            }
        }
        return result;
    }

    public List<CustomArray> queryLambda(Specification specification) {
        return repository.stream()
                .filter(customArray -> specification.specify(customArray))
                .toList();
    }

    public List<CustomArray> queryPredicate(Predicate<CustomArray> predicate) {
        return repository.stream()
                .filter(predicate)
                .toList();
    }

    @Override
    public void sort(Comparator<CustomArray> comparator) {
        repository.sort(comparator);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Repository CustomArray{");
        sb.append(repository);
        sb.append('}');
        return sb.toString();
    }
}
