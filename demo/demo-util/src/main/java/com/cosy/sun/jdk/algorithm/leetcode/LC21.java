package com.cosy.sun.jdk.algorithm.leetcode;

import com.cosy.sun.jdk.algorithm.leetcode.bean.ListNode;

public class LC21 {

    public static void main(String[] args) {
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


        ListNode listNode1 = mergeTwoLists(listNode, listNode21);

        System.out.println(listNode1);

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
