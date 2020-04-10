package com.thinkinginjava.concurrency.booksource;

public class MainThread
{
    public static void main(String[] args)
    {
        LiftOff launch = new LiftOff();
        launch.run();
        System.out.println("Waiting for LiftOff");
    }
}


