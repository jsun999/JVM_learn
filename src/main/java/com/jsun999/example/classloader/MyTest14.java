package com.jsun999.example.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        String resourceName = "com/jsun999/example/demo/MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while(urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }
        System.out.println("------------------");
        Class<?> clazz = MyTest14.class;
        System.out.println(clazz.getClassLoader());

        Class<?> clazz1 = String.class;
        System.out.println(clazz1.getClassLoader());
    }
}
