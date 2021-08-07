package com.java.liangfwDS.Test;

import sun.applet.Main;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2021/6/19 15:42
 */
public class Test1 {

    public static void main(String[] args) {
        String tem="1";
        String[] split = tem.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);

        }
    }
}
