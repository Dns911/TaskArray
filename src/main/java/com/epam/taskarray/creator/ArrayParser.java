package com.epam.taskarray.creator;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.validator.StringValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public  class ArrayParser {
    static final Logger logger = LogManager.getLogger();
    public static final String DELIMITER = ",?;?-?\\s+";

    public static CustomArray parseStringToCustomArray(String str){
        String[] strNumbers = str.split(ArrayParser.DELIMITER);
        int countItem = 0;
        for (String strNumber: strNumbers){
            if (StringValidator.validStringNumber(strNumber)){
                countItem++;
            }
        }
        int[] arr = new int[countItem];
        for (int i = 0, j = 0; i < strNumbers.length; i++){
            if (StringValidator.validStringNumber(strNumbers[i])){
                arr[j] = Integer.parseInt(strNumbers[i]);
                j++;
            }
        }
        if (countItem == strNumbers.length){
            logger.log(Level.INFO,"Valid string for array");
        }else{
            logger.log(Level.INFO,"Not valid string for array");
        }

        return new CustomArray(arr);
    }
}
