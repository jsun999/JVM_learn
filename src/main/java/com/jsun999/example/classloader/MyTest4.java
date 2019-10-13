package com.jsun999.example.classloader;

/**
 * 对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为[LLcom.jsun999.example.demo.MyParent4
 * 这种形式。动态生成的类型，其父类型就是Object。
 * 对于数组来说，JavaDoc经常将构成数组的元素为Component，实际上就是将数组降低一个维度后的类型
 *
 * 助记符：
 * anewarray：表示创建一个引用类型的（如类、接口、数组）数组，并将其引用值压入栈顶
 * newarray：表示创建一个指定的原始类型（如int、float、char等）的数组，并将其引用值压入栈顶
 * [I int数组 ， [C char数组 , [Z boolean数组 , [S short数组 ， [B byte数组
 */
public class MyTest4 {
    public static void main(String[] args) {
        //输出
        MyParent4 myParent4 = new MyParent4();
        //只会输出一次
//        MyParent4 myParent4 = new MyParent4();
//        MyParent4 myParent41 = new MyParent4();
        //class MyParent4
//        System.out.println(myParent4.getClass());
//        MyParent4[] myParent4s = new MyParent4[2];
//        System.out.println(myParent4s.getClass());
//        MyParent4[][] myParent4s1 = new MyParent4[1][1];
//        System.out.println(myParent4s1.getClass());
        //class [Lcom.jsun999.example.demo.MyParent4;
        //[L   动态生成的数组类型 父类型是Object
        //[[L  动态生成的二维数组 父类型是Object
//        System.out.println(myParent4s.getClass());
//        System.out.println(111);
//        int[] ints = new int[1];
//        System.out.println(ints.getClass());
//        System.out.println(ints.getClass().getSuperclass());
     }
}

class MyParent4{
     static {
         System.out.println("MyParent4 static block");
     }
}