package com.epam.taskarray.entity;

import java.util.List;

public class RepositoryCustomArray {
    private List<CustomArray> repository;

    public RepositoryCustomArray(List<CustomArray> repository) {
        this.repository = repository;
    }

    public List<CustomArray> getRepository() {
        return repository;
    }

    public void setRepository(List<CustomArray> repository) {
        this.repository = repository;
    }

    public void addCustomArray (CustomArray arr){
        this.repository.add(arr);
    }
    public void removeCustomArray (int index){
        this.repository.remove(index);
        }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RepositoryCustomArray{");
        sb.append("repository=").append(repository);
        sb.append('}');
        return sb.toString();
    }
}
