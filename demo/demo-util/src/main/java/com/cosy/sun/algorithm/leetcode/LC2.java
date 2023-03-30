package com.cosy.sun.algorithm.leetcode;

import com.alibaba.fastjson.JSONObject;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 */
public class LC2 {

    public static void main(String... args) {
        LC2 add = new LC2();
        int a = 123;
        int b = 234;
        ele ele = add.addTwoNumber(add.parseInt(a), add.parseInt(b));
        System.out.println(JSONObject.toJSONString(ele));
    }

    class ele {
        ele last;
        ele pre;
        int value;
    }

    public ele addTwoNumber(ele a, ele b) {
        int i = parseEle(a);
        int i1 = parseEle(b);
        int i2 = i + i1;
        ele ele = parseInt(i2);
        return ele;
    }

    private ele parseInt(int i2) {
        String s = Integer.valueOf(i2).toString();
        char[] chars = s.toCharArray();
        ele e = new ele();
        ele last = new ele();
        for (int i = chars.length - 1; i > -1; i--) {
            ele ele = new ele();
            ele.value = Integer.valueOf(String.valueOf(chars[i]));
            if (i != chars.length - 1) {
                e.pre = ele;
            } else {
                e = ele;
                last = ele;
                ele.last = last;
            }
            if(i == 0) {
                ele.pre = new ele();
            }
            e = ele;
            e.last = last;
        }
        return e;
    }

    private int parseEle(ele e) {
        ele last = e.last;
        StringBuilder builder = new StringBuilder();
        while (last.pre != null) {
            int a = last.value;
            last = last.pre;
            builder.append(a);
        }
        Integer integer = Integer.valueOf(builder.toString());
        return integer;
    }


}
