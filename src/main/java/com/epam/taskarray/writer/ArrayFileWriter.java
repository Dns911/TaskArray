package com.epam.taskarray.writer;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.exception.ArrayException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ArrayFileWriter {
    public static String DEFAULT_OUT_FILE = "data\\res.txt";

    public void customArrayToFile(CustomArray customArray, String fileName, boolean append) {
        String str = null;
        File file = new File(fileName);
        if (!file.exists()) {
            file = new File(DEFAULT_OUT_FILE);
        }

        try (PrintStream stream = new PrintStream(new FileOutputStream(file, append))) {
            for (int i = 0; i < customArray.size(); i++) {
                stream.printf("Element %d = %d \n", i, customArray.getElement(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ArrayException e) {
            e.printStackTrace();
        }

    }
}
