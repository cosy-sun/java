package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.leetcode.bean.ListNode;

public class LC21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode res = new ListNode();
        ListNode tmp = res;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                res.next = l1;
            l1 = l1.next;
            } else {
                res.next = l2;
            l2 = l2.next;
            }
            res = res.next;
        }
        res.next = l1 == null ? l2 : l1;
        return tmp.next;
    }

}
