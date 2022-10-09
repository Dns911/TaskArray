package com.epam.taskarray.creator;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.validator.StringValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParser {
    static final Logger logger = LogManager.getLogger();
    public static final String ITEM_DELIMITER = ",?;?-?\\s+";
    public static final String NAME_ARRAY_DELIMITER = ":\\s?+";

    private ArrayParser() {
        super();
    }

    public static CustomArray parseStringToCustomArray(String str) {
        String[] strName = str.split(ArrayParser.NAME_ARRAY_DELIMITER);
        if (strName.length != 2) {
            logger.log(Level.ERROR, "NOT VALID STRING:\"{}\" IT NEED TO HAVE ONE \":\" DELIMITER, WILL BE RETURN NULL", str);
            return null;
        }
        String arrayName = strName[0];

        String[] strNumbers = strName[1].split(ArrayParser.ITEM_DELIMITER);
        int countItem = 0;
        for (String strNumber : strNumbers) {
            if (StringValidator.validStringNumber(strNumber)) {
                countItem++;
            }
        }
        int[] arr = new int[countItem];
        int j = 0;
        for (int i = 0; i < strNumbers.length && j < countItem; i++) {
            if (StringValidator.validStringNumber(strNumbers[i])) {
                arr[j] = Integer.parseInt(strNumbers[i]);
                j++;
            }
        }
        if (countItem == strNumbers.length) {
            logger.log(Level.INFO, "ARRAY: <{}> WAS CREATED WITHOUT WARNS", arrayName);
        } else {
            logger.log(Level.INFO, "STRING HAVE BAD ITEM(s) AND ARRAY: <{}> WAS CREATED WITHOUT BAD ITEM(s)", arrayName);
        }

        return new CustomArray(arr, arrayName);
    }
}
