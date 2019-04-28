package com.jsun999.example.demo;

public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());
    }
}
