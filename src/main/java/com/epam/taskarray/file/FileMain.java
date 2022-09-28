package com.epam.taskarray.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileMain {
    public static void main(String[] args) {
        double[] values = {14.10, 17};
        String[] strs = {"javavavavava", "Scala"};
        try(PrintStream stream = new PrintStream(new FileOutputStream("data\\res.txt"))){
            stream.printf("Java %5.2f %7s %n", values[0], strs[0]);
            stream.printf("Java %5.2f %-7s %n", values[1], strs[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
