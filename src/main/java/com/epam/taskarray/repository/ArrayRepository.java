package com.epam.taskarray.repository;

import com.epam.taskarray.entity.CustomArray;

import java.util.*;

public class ArrayRepository {
    private static ArrayRepository arrRepInstance;
    private List<CustomArray> repository;

    private ArrayRepository() {
        repository = new ArrayList<>();
    }
    public static ArrayRepository getInstance() {
        if (arrRepInstance == null) {
            arrRepInstance = new ArrayRepository();
        }
        return arrRepInstance;
    }
    public List<CustomArray> getRepository() {
        return repository;
    }


    public void add (CustomArray arr){
        repository.add(arr);
    }

    public void addList (List<CustomArray> arrList){
        for (CustomArray customArr:
             arrList) {
            repository.add(customArr);
        }
    }

    public ArrayRepository getAll(){
        return arrRepInstance;
    }

    public void removeByIndex (int index){
        this.repository.remove(index);
    }

    public void updateByIndex (int index, CustomArray newArray){
        this.repository.remove(index);
        this.repository.add(index, newArray);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Repository CustomArray{");
        sb.append("rep=").append(repository);
        sb.append('}');
        return sb.toString();
    }
}
