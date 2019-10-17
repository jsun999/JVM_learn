package com.jsun999.example.bytecode;

public class MyTest2 {

    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    public MyTest2(){

    }
    public MyTest2(int i){
        System.out.println(i);
    }

    public static void main(String[] args) {

        MyTest2 myTest = new MyTest2();

        myTest.setX(8);

        in = 20;
    }

    private synchronized void setX(int x) {
        this.x = x;
    }

    private void test(String str) {
        synchronized (str){
            System.out.println("hello world");
        }
    }

    private static synchronized void test2(){

    }
}
