package com.jsun999.example.demo;

import com.sun.crypto.provider.AESKeyGenerator;

public class MyTest19 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        //java -Djava.ext.dirs=./ com.jsun999.example.demo.MyTest19
        //将java.ext.dirs系统属性设为当前目录则找不到类
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
