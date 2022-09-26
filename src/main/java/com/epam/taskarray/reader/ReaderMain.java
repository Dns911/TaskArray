package com.epam.taskarray.reader;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.exception.ArrayException;

public  class ReaderMain {
    public static final String SPACE_DELIMITER = "\\s+";
    public static final String NUMBER_EXPRESSION = "\\d+";
    public static CustomArray convertStringToCustomArray (String str){
        String[] strNumbers = str.split(ReaderMain.SPACE_DELIMITER);
        int countItem = 0;
        for (String strNumber: strNumbers){
            if (strNumber.matches(ReaderMain.NUMBER_EXPRESSION)){
                countItem++;
            }
        }
        int[] arr = new int[countItem];
        for (int i = 0, j = 0; i < strNumbers.length; i++){
            if (strNumbers[i].matches(ReaderMain.NUMBER_EXPRESSION)){
                arr[j] = Integer.parseInt(strNumbers[i]);
                j++;
            }
        }
        if (arr == null ){
            throw new NullPointerException();
        }
        if (arr.length == 0 ){
            throw new ArrayIndexOutOfBoundsException("Array length = 0");
        }

        return new CustomArray(arr);
    }
}
