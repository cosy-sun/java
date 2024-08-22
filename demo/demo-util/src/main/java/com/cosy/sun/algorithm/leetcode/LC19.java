package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;

public class LC19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0, head);
        ListNode first = head;
        ListNode second = tmp;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return tmp.next;
    }


}
