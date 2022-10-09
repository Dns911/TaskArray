package com.epam.taskarray.observer.impl;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.observer.ArrayObserver;
import com.epam.taskarray.warehouse.ArrayParameters;
import com.epam.taskarray.warehouse.Warehouse;

public class ArrayAvgMaxMinSumObserverImpl implements ArrayObserver {
    @Override
    public void updateArray(CustomArray arr) {
        ArrayParameters arrayParameters = new ArrayParameters();
        Warehouse warehouse = Warehouse.getInstance();
        arrayParameters.setParameters(arr);
        warehouse.put(arr.getArrayName(), arrayParameters);
    }
}
