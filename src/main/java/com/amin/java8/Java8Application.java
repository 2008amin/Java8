package com.amin.java8;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class Java8Application {

    private static final ConcurrentHashMap<String, Object> studentss = new ConcurrentHashMap();


    public static void main(String[] args) {
        ArrayListWithJava8 arrayListWithJava8 = new ArrayListWithJava8();
        arrayListWithJava8.filterAndMapNumbers();

    }
}
