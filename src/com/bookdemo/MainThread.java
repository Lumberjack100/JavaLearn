package com.bookdemo;

import com.bookdemo.LiftOff;

public class MainThread
{
    public static void main(String[] args)
    {
        LiftOff launch = new LiftOff();
        launch.run();
        System.out.println("Waiting for LiftOff");
    }
}


