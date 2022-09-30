package com.corejava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest2 {
    public static void main(String[] args) {
        // 1. 获取Student类的Class对象
        Class studentClass = Student.class;

        // 2.1 通过Class对象获取Constructor类对象，从而调用无参构造方法
        // 注：构造函数的调用实际上是在newInstance()，而不是在getConstructor()中调用
        try {
            Object mObj1 = studentClass.getConstructor().newInstance("Carson");

            String ss = "";

        } catch (Exception e) {
            e.printStackTrace();
        }
        Class c1 = boolean.class;
        System.out.println(c1.getCanonicalName());

        // 2.2 通过Class对象获取Constructor类对象（传入参数类型），从而调用有参构造方法
//        Object mObj2 = studentClass.getConstructor(String.class).newInstance("Carson");
    }

}
