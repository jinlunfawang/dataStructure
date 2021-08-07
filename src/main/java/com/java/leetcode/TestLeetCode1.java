package com.java.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2020/9/15 19:16
 */
public class TestLeetCode1 {

    /**
     * @param
     * @return 1.两个指针
     */
    @Test
    public void testString() {
        /**
         * deleteCopyString
         * hello, welcome to xiaomi
         */
      System.out.println((11+3*8)/4%3);
    }

    public boolean kuohao(String s) {

        Stack<Character> ns = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put('}','{');
        hashMap.put(']','[');
        for (int i = 0; i < s.length(); i++) {
            char tmp=s.charAt(i);
            if(tmp=='('||tmp=='{'||tmp=='['){
                ns.push(s.charAt(i));
            }else {
                char tem=hashMap.get(tmp);
                if(ns.isEmpty()){
                    return false;

                }if(tem!=ns.pop()){
                    return false;
                }
            }

        }
        return ns.isEmpty();

    }


        /**
         * 1 转为数组
         * 2.遍历数组 看arratlist是否包含 没有就添加
         * 2.new set 放到set中
         * @param str
         * @return
         */

    public String deleteCopyString(String str) {
        if(str.isEmpty()) return "";
        char[] chars = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        list.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if(!list.contains(chars[i])){
                list.add(chars[i]);
            }

        }
        String str1="";
        for (int i = 0; i < list.size(); i++) {
            str1+=list.get(i);
        }
        return str1;

    }
}
