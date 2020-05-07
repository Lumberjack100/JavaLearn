package com.thinkinginjava.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1
{
    public static void main(String[] args)
    {
//        Integer x = 127;
//        Integer y = 127;
//        Integer m = 99999;
//        Integer n = 99999;
//        System.out.println("x == y: " + (x == y)); // true
//        System.out.println("m == n: " + (m == n)); // false
//        System.out.println("x.equals(y): " + x.equals(y)); // true
//        System.out.println("m.equals(n): " + m.equals(n)); // true

        List<String> tempList = new ArrayList<>();
        List<String> tempList2 = new ArrayList<>();
        m(tempList, tempList2);
    }

    @SafeVarargs
    static void m(List<String>... stringLists)
    {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!

        String dd = "";
    }

}
