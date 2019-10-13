package com.jsun999.example.classloader;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

public class MyTest27 {
    public static void main(String[] args) throws Exception {
//        System.out.println(System.getProperty("jdbc.drivers"));
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://47.98.51.229:3306/jsun-blog","root","asusA123");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resourceName = "java/lang/String.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }
    }


}
