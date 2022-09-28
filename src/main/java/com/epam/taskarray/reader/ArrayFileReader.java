package com.epam.taskarray.reader;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.service.ArrayParser;

import java.io.*;

public class ArrayFileReader {
    public static String DEFAULT_FILE = "data\\info.txt";

    public CustomArray readFromFile(String fileName) {
        String str = null;
        File file = new File(fileName);
        if (!file.exists()) {
            file = new File(DEFAULT_FILE);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            str = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(file + " not found");
        }
        return ArrayParser.parseStringToCustomArray(str);
    }
}
