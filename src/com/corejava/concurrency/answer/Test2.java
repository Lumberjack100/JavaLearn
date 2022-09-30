package com.corejava.concurrency.answer;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test2 {

    public static void main(String... args) throws ExecutionException, InterruptedException {
//        ExecutorService executor = Executors.newCachedThreadPool(); // 线程池
//        Future<String> future = executor.submit(() -> {
////            Thread.sleep(2000); // 模拟接口调用，耗时200ms
//            return "hello world";
//        });
//        // 在输出下面异步结果时主线程可以不阻塞的做其他事情
//        // TODO 其他业务逻辑
//        System.out.println("我先打印了");
//        System.out.println("异步结果:" + future.get()); //主线程获取异步结果
        // 或者通过下面轮询的方式
        // while(!future.isDone());


//        Test test = new Test();
//        test.calc();

        for (int i = 0; i < 1000; i++) {
            Thread th1 = new Thread(() -> {
                System.out.println(Singleton.getInstance().name);
            });
            th1.start();
        }

    }

}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}


