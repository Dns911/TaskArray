package com.epam.taskarray.main;

import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.reader.ArrayFileReader;
import com.epam.taskarray.service.ArrayService;
import com.epam.taskarray.writer.ArrayFileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        ArrayFileReader arrayFileReader = new ArrayFileReader();
        CustomArray customArray = arrayFileReader.readFromFile("");
        System.out.println(customArray);
        ArrayService arrayService = new ArrayService();
        System.out.println(arrayService.recursiveQuickSort(customArray));

        System.out.println(customArray);
        ArrayFileWriter arrayFileWriter = new ArrayFileWriter();
        arrayFileWriter.customArrayToFile(customArray, "", false);

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
