package com.test.concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock2 {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");// 格式化时间

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        TestLock2 test = new TestLock2();
        MyThread thread1 = new MyThread(test);
        MyThread thread2 = new MyThread(test);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("现在时间：" + sdf.format(new Date())); // 输出已经格式化的现在时间（24小时制）

//        thread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();   //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        try {
            System.out.println(sdf.format(new Date()) + thread.getName() + "得到了锁");
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - startTime >= 3000)
                    break;
                //插入数据

//                System.out.println(sdf.format(new Date()));
            }
        } finally {
            System.out.println(sdf.format(new Date()) + Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(sdf.format(new Date()) + thread.getName() + "释放了锁");
        }
    }
}

class MyThread extends Thread {
    private TestLock2 test = null;

    public MyThread(TestLock2 test) {
        this.test = test;
    }

    @Override
    public void run() {

        try {
            test.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断");
        }
    }
}
