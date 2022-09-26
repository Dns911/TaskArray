package com.epam.taskarray.main;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.exception.ArrayException;
import com.epam.taskarray.reader.ArrayFileReader;
import com.epam.taskarray.service.ArrayService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
// Array ConsoleReader arrayConsoleReader = new ArrayConsoleReader()
// CustomArray customArray = arrayConsoleReader.readFromConsole()
//        ArrayFileReader arrayFileReader = new ArrayFileReader();
//        CustomArray customArray = arrayFileReader.readFromFile("data\\copy1.txt");
//        System.out.println(customArray);
//        ArrayService arrayService = new ArrayService();
//        System.out.println(arrayService.recursiveQuickSort(customArray));
//        try {
//            System.out.println(customArray.getElement(7));
//        } catch (ArrayException e) {
//            e.printStackTrace();
//        }
//        System.out.println(arrayService.maxValue(customArray));
        fileSystem();
        byte[] value = {65, 67, 100};
        outputArrayInStream(value);
    }
    public static void fileSystem(){
        File file = new File("data" + File.separator + "info.txt");
        if (file.exists() && file.isFile()) {
            System.out.println("Path " + file.getPath());
            System.out.println("Absolute Path " + file.getAbsolutePath());
            System.out.println("Size " + file.length());
            System.out.println("Dir " + file.getParent());
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File dir = new File("data");
        if (dir.exists() && dir.isDirectory()) {
            for (File current : dir.listFiles()) {
                long millis = current.lastModified();
                Instant date = Instant.ofEpochMilli(millis);
                System.out.println(current.getPath() + "\t" + current.length() + "\t" + date);
            }
            File root = File.listRoots()[0];
            System.out.printf("\n%s %,d from %,d free bytes", root.getPath(), root.getUsableSpace(),
                    root.getTotalSpace());
        }
    }
    public static void outputArrayInStream(byte[] value){
        try (FileOutputStream output = new FileOutputStream("data/out.txt", true)) {
            output.write(48);
            output.write(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
    }
}
}
