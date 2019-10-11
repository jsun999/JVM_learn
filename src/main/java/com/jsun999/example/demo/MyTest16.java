package com.jsun999.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
//删除class文件以加载
public class MyTest16 extends ClassLoader{
    private String classLoaderName;
    private String asf;
    private String fileExtentsion = ".class";
    public MyTest16(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent,String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent){
        super(parent);
    }

    public void setAsf(String asf) {
        this.asf = asf;
    }

    @Override
    public String toString() {
        return "["+ this.classLoaderName+"]";
    }

    @Override
    protected Class<?> findClass(String className) {
        System.out.println("findClass involed:"+className);
        System.out.println("class loader name:"+this.classLoaderName);
        byte[] data = this.loadClassData(className);
        return this.defineClass(className,data,0,data.length);
    }
    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        className = className.replace(".","/");
        try{
            is = new FileInputStream(new File(this.asf+className + this.fileExtentsion));
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
        System.out.println(object.getClass().getClassLoader());
    }
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
//        loader1.setPath("E:\\my_idea_project\\jvm_learn\\target\\classes\\");
        loader1.setAsf("C:\\Users\\jsun9\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.jsun999.example.demo.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());

        loader1 = null;
        clazz = null;
        object = null;

        System.gc();

        Thread.sleep(10000);
        loader1 = new MyTest16("loader1");
        loader1.setAsf("C:\\Users\\jsun9\\Desktop\\");
        clazz = loader1.loadClass("com.jsun999.example.demo.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);
        System.out.println();
//        MyTest16 loader2 = new MyTest16("loader2");
//        MyTest16 loader2 = new MyTest16(loader1,"loader2");
//        loader2.setAsf("C:\\Users\\jsun9\\Desktop\\");
//        Class<?> clazz2 = loader2.loadClass("com.jsun999.example.demo.MyTest1");
//        System.out.println("class:" + clazz2.hashCode());
//        Object object2 = clazz2.newInstance();
//        System.out.println(object2);
//        System.out.println();
//
//        MyTest16 loader3 = new MyTest16(loader2,"loader3");
//        loader3.setAsf("C:\\Users\\jsun9\\Desktop\\");
//        Class<?> clazz3 = loader3.loadClass("com.jsun999.example.demo.MyTest1");
//        System.out.println("class:" + clazz3.hashCode());
//        Object object3 = clazz3.newInstance();
//        System.out.println(object3);

    }
}