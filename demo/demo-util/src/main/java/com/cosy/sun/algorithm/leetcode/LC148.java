package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;

public class LC148 {

    public static ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null) {
            if(fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        ListNode tmp = new ListNode();
        ListNode pre = tmp;

        while(left != null && right != null) {
            if(left.val < right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }

        pre.next = left != null ? left : right;

        return tmp.next;

    }

}
