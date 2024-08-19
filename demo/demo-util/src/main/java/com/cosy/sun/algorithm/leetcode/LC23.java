package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;

public class LC23 {

    public static ListNode mergeManyLists(ListNode[] l1) {
        if(l1.length == 0) {
            return null;
        }
        if(l1.length == 1) {
            return l1[0];
        }
        ListNode res = l1[0];
        for (int i = 1; i < l1.length; i++) {
            res = mergeTwoLists(res, l1[i]);
        }
        return res;
    }

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
