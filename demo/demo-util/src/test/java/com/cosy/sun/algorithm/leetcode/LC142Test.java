package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;
import org.junit.jupiter.api.Test;

public class LC142Test {

    @Test
    public void detectCycleTest() {
        ListNode head = new ListNode(1);
        ListNode node2 = head.next = new ListNode(2);
        ListNode node3 = node2.next = new ListNode(3);
        ListNode node4 = node3.next = new ListNode(4);
        ListNode node5 = node4.next = new ListNode(5);
        node5.next = node2;
        ListNode listNode = LC142.detectCycle(head);
        System.out.println(listNode);
    }
}