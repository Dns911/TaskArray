package com.epam.taskarray.main;

import com.epam.taskarray.comparator.ArrayNameComparator;
import com.epam.taskarray.creator.ArrayListCreator;
import com.epam.taskarray.entity.CustomArray;
import com.epam.taskarray.reader.ArrayFileReader;
import com.epam.taskarray.repository.ArrayRepository;
import com.epam.taskarray.repository.impl.ArrayRepositoryImpl;
import com.epam.taskarray.repository.specification.ArrayBySumLessSpecification;
import com.epam.taskarray.repository.specification.ArrayBySumMoreSpecification;
import com.epam.taskarray.warehouse.ArrayParameters;
import com.epam.taskarray.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class Main2 {
    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.log(Level.INFO, "START");
        ArrayFileReader arrayFileReader = new ArrayFileReader();
        ArrayListCreator arrayListCreator = new ArrayListCreator();
        List<CustomArray> arrayList = arrayListCreator.getArrList(arrayFileReader.readFromFile(""));
        logger.log(Level.INFO, arrayList.get(0).getArrayId());
        logger.log(Level.INFO, arrayList);
        ArrayRepository repository = ArrayRepositoryImpl.getInstance();
        repository.addList(arrayList);
//        logger.log(Level.INFO, repository);
//        List<CustomArray> arrSum = repository.query(new ArrayBySumSpecification(10));
//        logger.log(Level.INFO, arrSum);
        ArrayNameComparator arrayNameComparator = new ArrayNameComparator();
        Collections.sort(arrayList, arrayNameComparator);
//        logger.log(Level.INFO, arrayList);
//        logger.log(Level.INFO, arrayList.get(2).getArrayId());
        repository.sort(arrayNameComparator);
        repository.query(new ArrayBySumLessSpecification(5));
        logger.log(Level.INFO, repository);
        Warehouse warehouse = Warehouse.getInstance();
        ArrayParameters arrayParameters0 = new ArrayParameters();
        arrayParameters0.setParameters(arrayList.get(0));
        warehouse.put(arrayList.get(0).getArrayName(), arrayParameters0);
        logger.log(Level.INFO, warehouse);
        int[] arrNew = {2, 5, 8};
        arrayList.get(0).setArray(arrNew);
        logger.log(Level.INFO, warehouse);
        List<CustomArray> res2 = repository.queryLambda(new ArrayBySumMoreSpecification(6));
        logger.log(Level.INFO, res2);
    }
}