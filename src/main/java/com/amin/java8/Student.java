package com.amin.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public  class Student {
    private String name;
    private String family;
    private String adress;
    private int age;

}
