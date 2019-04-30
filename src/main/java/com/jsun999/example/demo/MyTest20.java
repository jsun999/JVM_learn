package com.jsun999.example.demo;

public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        Class<?> clazz1 = loader1.loadClass("com.jsun999.example.demo.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.jsun999.example.demo.MyPerson");
        System.out.println(clazz1 == clazz2);
    }
}
