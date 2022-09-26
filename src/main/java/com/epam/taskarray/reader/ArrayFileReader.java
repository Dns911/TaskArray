package com.epam.taskarray.reader;

import com.epam.taskarray.entity.CustomArray;

import java.io.*;
import java.util.Arrays;

public class ArrayFileReader {
    public static String DATA_INFO_TXT = "data\\info.txt";

    public CustomArray readFromFile(String fileReader) {
        String str = null;
        File file = new File(fileReader);
        if (!file.exists()) {
            file = new File(DATA_INFO_TXT);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            str = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(file + " not found");
        }
        return ReaderMain.convertStringToCustomArray(str);
    }
}
