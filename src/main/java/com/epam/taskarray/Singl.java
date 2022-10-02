package com.epam.taskarray;

public class Singl {
    private static Singl singlInstance;

    private Singl() {
    }

    public static Singl getInstance() {
        if (singlInstance == null) {
            singlInstance = new Singl();
        }
        return singlInstance;
    }
}
