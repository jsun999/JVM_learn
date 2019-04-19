package com.jsun999.example.demo;

import java.util.Random;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会初始化
 */

public class MyTest5 {
    public static void main(String[] args) {
//        System.out.println(MyChild5.b);
        System.out.println(MyParent5_1.thread);
    }
}

interface MyGrandpa {
    public static Thread thread = new Thread(){
        {
            System.out.println("MyGrandpa invoke");
        }
    };
}
interface MyParent5 extends MyGrandpa{
//    public static int a = new Random().nextInt(3);
//    public static int a = 3;
    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5 invoke");
        }
    };

}

class MyChild5 implements MyParent5 {

    public static final int b =6;
//    public static final int b = new Random().nextInt(4);
}

interface MyGrandpa5_1 {
    public static Thread thread = new Thread(){
        {
            System.out.println("MyGrandpa5_1 invoke");
        }
    };
}

interface MyParent5_1 extends MyGrandpa5_1 {
    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5_1 invoke");
        }
    };
}