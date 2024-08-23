package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;
import org.junit.jupiter.api.Test;

public class LC148Test {

    @Test
    public void sortListTest() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(-1);
        ListNode l3 = new ListNode(8);
        ListNode l4 = new ListNode(10);
        ListNode l5 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode listNode = LC148.sortList(l1);
        System.out.println(listNode);
    }
}