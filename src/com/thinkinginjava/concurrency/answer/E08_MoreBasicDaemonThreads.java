package com.thinkinginjava.concurrency.answer;//: concurrency/com.test.E08_MoreBasicDaemonThreads.java

import com.thinkinginjava.concurrency.booksource.LiftOff;

import java.util.concurrent.TimeUnit;

/****************** Exercise 8 *****************
 * Modify MoreBasicThreads.java so that all the
 * threads are daemon threads, and verify that the
 * program ends as soon as main() is able to exit.
 ***********************************************/

public class E08_MoreBasicDaemonThreads {
  public static void main(String[] args) {
    for(int i = 0; i < 5; i++) {
      Thread t = new Thread(new LiftOff());
      t.setDaemon(true);
      t.start();
    }
    System.out.println("Waiting for LiftOff");
  }
} /* Output: (Sample)
Waiting for com.test.LiftOff
*///:~
