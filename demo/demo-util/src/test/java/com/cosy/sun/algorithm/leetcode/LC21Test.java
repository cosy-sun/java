package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;
import org.junit.jupiter.api.Test;

public class LC21Test {

    @Test
    public void testMergeTwoLists() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode4;

        ListNode listNode21 = new ListNode(1);
        ListNode listNode23 = new ListNode(3);
        ListNode listNode24 = new ListNode(4);

        listNode21.next = listNode23;
        listNode23.next = listNode24;
        LC21.mergeTwoLists(listNode, listNode21);
    }
}
