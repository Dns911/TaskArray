package com.epam.taskarray.validation;

public class StringValidator {
    public static final String NUMBER_EXPRESSION = "-?\\d+";
    public static Boolean validStringNumber (String stringNumber){
        return stringNumber != null && stringNumber.matches(StringValidator.NUMBER_EXPRESSION);
    }
}
