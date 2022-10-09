package com.epam.taskarray.repository.specification;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.repository.Specification;
import com.epam.taskarray.service.ArrayService;
import com.epam.taskarray.service.impl.ArrayServiceImpl;

public class ArrayBySumLessSpecification implements Specification {
    private int sumArray;
    ArrayService arrayService = new ArrayServiceImpl();
    public ArrayBySumLessSpecification(int sumArray) {
        this.sumArray = sumArray;
    }
    @Override
    public boolean specify(CustomArray arr) {
        return arrayService.sumArray(arr) < sumArray;
    }
}
