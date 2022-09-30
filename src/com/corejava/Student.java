package com.corejava;

public class Student {
    // 无参构造函数
    public Student() {
        System.out.println("调用了无参构造函数");
    }

    // 有参构造函数
    public Student(String str) {
        System.out.println("调用了有参构造函数");
    }

    private String name;
}
