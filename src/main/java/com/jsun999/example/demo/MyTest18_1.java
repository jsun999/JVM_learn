package com.jsun999.example.demo;

public class MyTest18_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setAsf("C:\\Users\\jsun9\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.jsun999.example.demo.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader: " + clazz.getClassLoader());
    }
}
