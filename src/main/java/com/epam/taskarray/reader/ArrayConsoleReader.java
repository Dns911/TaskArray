package com.epam.taskarray.reader;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.service.ArrayParser;

import java.util.Scanner;

public class ArrayConsoleReader {

    public CustomArray readFromConsole(){
        String str;
        try (Scanner scanner = new Scanner(System.in)){
            str = scanner.nextLine();
        }
        return ArrayParser.parseStringToCustomArray(str);
    }
}
