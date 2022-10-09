package com.epam.taskarray.warehouse;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.service.ArrayService;
import com.epam.taskarray.service.impl.ArrayServiceImpl;

import java.util.StringJoiner;

public class ArrayParameters {
    private int sum;
    private int max;
    private int min;
    private double avg;
    public void setParameters(CustomArray arr){
        ArrayService arrayService = new ArrayServiceImpl();
        sum = arrayService.sumArray(arr);
        max = arrayService.maxValue(arr);
        min = arrayService.minValue(arr);
        avg = arrayService.average(arr);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ArrayParameters.class.getSimpleName() + "[", "]")
                .add("sum=" + sum)
                .add("max=" + max)
                .add("min=" + min)
                .add("avg=" + avg)
                .toString();
    }
}
