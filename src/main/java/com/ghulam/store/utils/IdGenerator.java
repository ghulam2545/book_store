package com.ghulam.store.utils;

public class IdGenerator {
    private static Integer offset = 1001;
    private final static Integer year = 2024;

    public static String next() {
        String id = "BS";
        id += year;
        id += offset;
        offset += 1;
        
        return id;
    }
}
