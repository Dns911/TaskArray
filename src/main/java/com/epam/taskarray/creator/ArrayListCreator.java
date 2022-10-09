package com.epam.taskarray.creator;

import com.epam.taskarray.entity.CustomArray;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCreator {
    private final List<CustomArray> arrList = new ArrayList<>();

    public ArrayListCreator() {
        super();
    }

    public List<CustomArray> getArrList(List<String> stringList) {
        for (String str : stringList) {
            if (ArrayParser.parseStringToCustomArray(str) != null) {
                arrList.add(ArrayParser.parseStringToCustomArray(str));
            }
        }
        return arrList;
    }
}
