package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;
import org.junit.jupiter.api.Test;

public class LC2Test {

    @Test
    public void addToNumbersTest() {

        ListNode l1 = new ListNode(9);
        ListNode l2 = l1.next = new ListNode(2);
        ListNode l3 = l2.next = new ListNode(3);


        ListNode l21 = new ListNode(1);
        ListNode l22 = l21.next = new ListNode(2);
        ListNode l23 = l22.next = new ListNode(3);
        ListNode l24 = l23.next = new ListNode(4);

        ListNode listNode = LC2.addToNumbers(l1, l21);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}