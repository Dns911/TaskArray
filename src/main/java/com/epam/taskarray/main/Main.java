package com.epam.taskarray.main;

import com.epam.taskarray.creator.ArrayListCreator;
import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.exception.ArrayException;
import com.epam.taskarray.reader.ArrayFileReader;
import com.epam.taskarray.repository.ArrayRepository;
import com.epam.taskarray.repository.impl.ArrayRepositoryImpl;
import com.epam.taskarray.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.StringJoiner;

public class Main {
    static final Logger logger = LogManager.getLogger();

    int minusTen(int n) {
        logger.log(Level.INFO, "");
        return n - 10;
    }

    public static void main(String[] args) throws ArrayException {
        logger.log(Level.INFO, "Start:");
//        ArrayFileReader arrayFileReader = new ArrayFileReader();
//        ArrayParser arrayParser = new ArrayParser();
//        ArrayList<String> listString = arrayFileReader.readFromFile("");
//        System.out.println(listString);
//        CustomArray customArray = ArrayParser.parseStringToCustomArray(listString.get(0));
//        ArrayService arrayService = new ArrayServiceImpl();
//        System.out.println(customArray);
//
//        System.out.println(arrayService.recursiveQuickSort(customArray));
//
//        System.out.println(customArray);
//        ArrayFileOuter arrayFileOuter = new ArrayFileOuter();
//        arrayFileOuter.customArrayToFile(customArray, "", false);
        ArrayFileReader arrayFileReader = new ArrayFileReader();
        ArrayListCreator arrayListCreator = new ArrayListCreator();
        List<CustomArray> arrayList = arrayListCreator.getArrList(arrayFileReader.readFromFile(""));
        System.out.println(arrayList);
        ArrayRepository rep = ArrayRepositoryImpl.getInstance();
        rep.addList(arrayList);
        System.out.println("   ");
        System.out.println(rep);
        ArrayRepository rep2 = ArrayRepositoryImpl.getInstance();
        rep2.add(arrayList.get(1));
        System.out.println("   ");
        System.out.println(rep2);
        System.out.println("   ");
        System.out.println("   ");
        System.out.println("  ");
        rep2.removeByIndex(1);
        System.out.println(rep);
        StringJoiner joiner = new StringJoiner("--")
                .add("**" + arrayList + "000");
        System.out.println(joiner);
    }

    public static void fileSystem() {
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
            System.out.printf("\n%s %,d from %,d free bytes", root.getPath(), root.getUsableSpace(), root.getTotalSpace());
        }
    }

    public static void outputArrayInStream(byte[] value) {
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