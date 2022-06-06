package com.amin.java8;

public class Student {
    private String name;
    private String family;
    private String adress;

    public Student() {
    }

    public Student(String name, String family, String adress) {
        this.name = name;
        this.family = family;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
