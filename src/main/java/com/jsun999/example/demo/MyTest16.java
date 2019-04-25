package com.jsun999.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16 extends ClassLoader{
    private String classLoaderName;
    private String fileExtentsion = ".class";
    public MyTest16(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent,String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "["+ this.classLoaderName+"]";
    }

    @Override
    protected Class<?> findClass(String className) {
        byte[] data = this.loadClassData(className);
        return this.defineClass(className,data,0,data.length);
    }
    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try{
            is = new FileInputStream(new File(className + this.fileExtentsion));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while(-1 !=(ch=is.read())){
                baos.write(ch);
            }
            data = baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                is.close();
                baos.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = classLoader.loadClass("com.jsun999.example.demo.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyTest16 loader1 = new MyTest16("loader1");
        test(loader1);
    }


}
