package com.jsun999.example.demo;

import java.lang.reflect.Method;

public class MyTest21 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        loader1.setAsf("C:\\Users\\jsun9\\Desktop\\");
        loader2.setAsf("C:\\Users\\jsun9\\Desktop\\");
        Class<?> clazz1 = loader1.loadClass("com.jsun999.example.demo.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.jsun999.example.demo.MyPerson");
        System.out.println(clazz1 == clazz2);
        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();
        Method method = clazz1.getMethod("setMyPerson",Object.class);
        method.invoke(object1,object2);
    }
}
