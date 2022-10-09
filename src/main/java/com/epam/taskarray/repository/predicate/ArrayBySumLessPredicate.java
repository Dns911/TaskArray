package com.epam.taskarray.repository.predicate;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.service.ArrayService;
import com.epam.taskarray.service.impl.ArrayServiceImpl;

import java.util.function.Predicate;

public class ArrayBySumLessPredicate implements Predicate<CustomArray> {
    private int sumArray;
    ArrayService arrayService = new ArrayServiceImpl();

    public ArrayBySumLessPredicate(int sumArray) {
        this.sumArray = sumArray;
    }

    @Override
    public boolean test(CustomArray customArray) {
        return arrayService.sumArray(customArray) < sumArray;
    }
}
