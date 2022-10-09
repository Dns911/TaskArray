package com.epam.taskarray.warehouse;

import com.epam.taskarray.entity.CustomArray;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Warehouse {
    private static Warehouse warehouseInstance;
    private Map<String, ArrayParameters> params = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (warehouseInstance == null) {
            warehouseInstance = new Warehouse();
        }
        return warehouseInstance;
    }

    public ArrayParameters get(String key) {
        return params.get(key);
    }

    public ArrayParameters put(String key, ArrayParameters arrayParameters) {
        return params.put(key, arrayParameters);
    }

    public void putAll(Map<String, ArrayParameters> m) {

        params.putAll(m);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Warehouse.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
