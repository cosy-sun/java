package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;

public class LC24 {
    
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode temp = preHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return preHead.next;
    }
    
}
