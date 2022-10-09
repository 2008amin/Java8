package com.amin.java8;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class Java8Application {

    private static final ConcurrentHashMap<String, Object> studentss = new ConcurrentHashMap();


    public static void main(String[] args) {
        LocalDateJava8 local = new LocalDateJava8();
        local.testInstant();
        //Current DateTime=2022-10-09T10:59:59.713
        //Current Timestamp = 2022-10-09T07:30:18.997Z


    }
}
