package com.jsun999.example.bytecode;

/**
 * 方法的动态分派
 *
 * 方法的动态分派涉及到一个重要概念：方法接收者。
 *
 * invokevirtual字节码指令的多态查找流程
 *
 * 比较方法重载(overload)与方法重写(overwrite),我们可以得到这样的结论：
 *
 * 方法重载是静态的，是编译期行为；方法重写是动态的，是运行期行为。
 */

public class MyTest6 {
    public static void main(String[] args) {
        Fruit orange = new Orange();
        Fruit apple = new Apple();
        orange.test();
        apple.test();
        apple = new Orange();
        apple.test();
        apple = orange;
        apple.test();
    }
}
class Fruit{
    public void test(){
        System.out.println("Fruit");
    }
}

class Apple extends Fruit{
    @Override
    public void test() {
        System.out.println("apple");
    }
}

class Orange extends Fruit{
    @Override
    public void test() {
        System.out.println("orange");
    }
}
