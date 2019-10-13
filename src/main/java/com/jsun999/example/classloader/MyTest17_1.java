package com.jsun999.example.classloader;

/**
 * 关于命名空间的重要说明
 * 子加载器所加载的类能够访问到父加载器所加载的类，
 * 父加载器所加载的类无法访问到子加载器所加载的类
 */
public class MyTest17_1 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setAsf("C:\\Users\\jsun9\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.jsun999.example.classloader.MySample");
        System.out.println("class: " + clazz.hashCode());
        //如果注释掉改行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
        //因此不会实例化MyCat对象，即没有对MyC  at进行主动使用，这里就不一定加载MyCat Class
        Object object = clazz.newInstance();

    }
}
