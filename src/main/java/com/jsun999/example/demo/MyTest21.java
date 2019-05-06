package com.jsun999.example.demo;

import java.lang.reflect.Method;

/**
 * 类加载器的双亲委托模型的好处：
 * 1. 可以确保Java核心库的类型安全：所有的Java应用都至少会引用java.lang.Object类，也就是说在运行期，java.lang.Object
 *    这个类会被加载到Java虚拟机中；如果这个加载过程是由Java应用自己的类加载器所完成的，那么很可能就会在JVM中存在多个版本的
 *    java.lang.Object类，而且这些类之间还是不兼容的，相互不可见的（正是命名空间在发挥着作用）。
 *    借助于双亲委托机制，Java核心类库中的类的加载工作都是由启动类加载器来统一完成加载工作，从而确保了Java应用所使用的都是
 *    同一个版本的Java核心类库，他们之间是相互兼容的。
 * 2. 可以确保Java核心类库所提供的类不会被自定义的类所替代。
 * 3. 不同的类加载器可以为相同名称（binary name）的类创建额外的命名空间。相同名称的类可以并存在Java虚拟机中，只需要用不
 *    同的类加载器来加载他们即可。不同类加载器所加载的类之间是不兼容的，这就相当于在Java虚拟机内部创建了一个又一个相互隔离的
 *    Java类空间，这类技术在很多框架中都得到了实际应用。
 */
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
