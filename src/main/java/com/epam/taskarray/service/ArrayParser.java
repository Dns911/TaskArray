package com.epam.taskarray.service;

import com.epam.taskarray.entity.CustomArray;

public  class ArrayParser {
    public static final String SPACE_DELIMITER = "\\s+";
    public static final String NUMBER_EXPRESSION = "-?\\d+";
    public static CustomArray parseStringToCustomArray(String str){
        String[] strNumbers = str.split(ArrayParser.SPACE_DELIMITER);
        int countItem = 0;
        for (String strNumber: strNumbers){
            if (strNumber.matches(ArrayParser.NUMBER_EXPRESSION)){
                countItem++;
            }
        }
        int[] arr = new int[countItem];
        for (int i = 0, j = 0; i < strNumbers.length; i++){
            if (strNumbers[i].matches(ArrayParser.NUMBER_EXPRESSION)){
                arr[j] = Integer.parseInt(strNumbers[i]);
                j++;
            }
        }

        return new CustomArray(arr);
    }
}
