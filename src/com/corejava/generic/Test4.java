package com.corejava.generic;

import com.thinkinginjava.annotations.PasswordUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test4
{

    public static void main(String[] args)
    {
//        DecimalFormat df = new DecimalFormat("#.#");//格式化小数
//        String rate = df.format(3 / (float) 10 * 100) + "%";
//
//        String ss = "192 8800 ";
//
//        String string = ss.trim();
//
//        System.out.println(string);

        BigDecimal d3 = new BigDecimal("1234500");
        BigDecimal d4 = d3.stripTrailingZeros();
        System.out.println(d3.scale()); // 0
        System.out.println(d4.scale()); // -2

    }
}
