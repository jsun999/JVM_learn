package com.jsun999.example.classloader;

/**
 * @Author jy
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter2: " + Singleton.counter2);
    }
}
class Singleton {
    public static int counter1;

    public static int counter2 = 0;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
        System.out.println(counter1);
        System.out.println(counter2);
    }

//    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
