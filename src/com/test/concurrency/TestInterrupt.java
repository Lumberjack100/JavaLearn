package com.test.concurrency;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestInterrupt {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");// 格式化时间

    public static void main(String[] args) throws IOException {


        System.out.println("现在时间：" + sdf.format(new Date())); // 输出已经格式化的现在时间（24小时制）

        TestInterrupt test = new TestInterrupt();
        MyThread thread = test.new MyThread();
        thread.start();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(sdf.format(new Date()) + " 进入睡眠状态");
                Thread.currentThread().sleep(10000);
                System.out.println(sdf.format(new Date()) + " 睡眠完毕");
            } catch (InterruptedException e) {
                System.out.println(sdf.format(new Date()) + " 得到中断异常");
            }
            System.out.println(sdf.format(new Date()) + " run方法执行完毕");
        }
    }
}
