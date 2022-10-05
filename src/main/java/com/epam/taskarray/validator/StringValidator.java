package com.epam.taskarray.validator;

public class StringValidator {
    public static final String NUMBER_EXPRESSION = "-?\\d+";
    public static boolean validStringNumber (String stringNumber){
        return stringNumber != null && stringNumber.matches(StringValidator.NUMBER_EXPRESSION);
    }
}
