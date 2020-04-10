package com.thinkinginjava.concurrency.booksource;

public class BasicThread {
    public static void main(String[] args)
    {

        new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }
}
