//: concurrency/E06_SleepingTask2.java
// {Args: 5}
/****************** Exercise 6 *****************
 * Create a task that sleeps for a random amount
 * of time between 1 and 10 seconds, then displays
 * its sleep time and exits. Create and run a quantity
 * (given on the command line) of these tasks.
 ***********************************************/
package com.answer;
import java.util.*;
import java.util.concurrent.*;

class SleepingTask2 implements Runnable {
  private static Random rnd = new Random();
  private final int sleep_time = rnd.nextInt(10) + 1;
  public void run() {
    try {
      TimeUnit.SECONDS.sleep(sleep_time);
    } catch(InterruptedException e) {
      System.err.println("Interrupted: " + e);
    }
    System.out.println(sleep_time);
  }
}

public class E06_SleepingTask2 {
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool();

    for(int i = 0; i < 5; i++)
      exec.execute(new SleepingTask2());
    Thread.yield();
    exec.shutdown();
  }
} /* Output: (Sample)
1
1
2
6
10
*///:~
