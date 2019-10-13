package com.jsun999.example.classloader;

public class MySample {
    public MySample() {
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());

        new MyCat();

        System.out.println("from MySample: " + MyCat.class);
    }
}
