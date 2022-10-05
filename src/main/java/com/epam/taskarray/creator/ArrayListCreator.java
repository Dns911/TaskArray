package com.epam.taskarray.creator;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.exception.ArrayException;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCreator {
    public List<CustomArray> arrList = new ArrayList<>();

    public ArrayListCreator() {
    }

    public List<CustomArray> getArrList(List<String> stringList) {
        for (String str : stringList) {
            arrList.add(ArrayParser.parseStringToCustomArray(str));
        }
        return arrList;
    }
}
