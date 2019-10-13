package com.jsun999.example.classloader;

public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        //null
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        //sun.misc.Launcher$AppClassLoader@18b4aac2
        Class<?> clazz2 = Class.forName("com.jsun999.example.classloader.c");
        System.out.println(clazz2.getClassLoader());
    }
}

class c {

}