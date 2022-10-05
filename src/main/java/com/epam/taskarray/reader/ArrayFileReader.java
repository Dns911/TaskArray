package com.epam.taskarray.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayFileReader {
    public static String DEFAULT_FILE = "data\\info.txt";

    public List<String> readFromFile(String fileName) {
        List<String> stringList = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            file = new File(DEFAULT_FILE);
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                    stringList.add(tmp);
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(file + " not found");
        }
        return stringList;
    }
}
