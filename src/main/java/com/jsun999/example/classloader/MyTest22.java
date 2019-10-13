package com.jsun999.example.classloader;

public class MyTest22 {
    static{
        System.out.println("MyTest22 initializer");
    }
/**
 *  java -Djava.ext.dirs=./ MyTest22   更改扩展类路径
 *  jar cvf test.jar com/jsun999/jvm/classloader/MyTest1.class  class文件必须打包到jar才能加载
 */
    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());
        //变成扩展类加载器加载。
        System.out.println(MyTest1.class.getClassLoader());
    }
}
