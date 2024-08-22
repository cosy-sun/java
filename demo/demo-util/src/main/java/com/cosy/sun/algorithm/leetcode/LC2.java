package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 */
public class LC2 {

    public static ListNode addToNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode();
        ListNode ans = new ListNode();
        ans.next = tmp;
//        int cnt = 0;
        boolean flg = false;
        while (l1 != null || l2 != null) {
            int i1 = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (flg ? 1 : 0);
            if (i1 > 9) {
                tmp = tmp.next = new ListNode(i1 - 10);
                flg = true;
            } else {
                tmp = tmp.next = new ListNode(i1);
                flg = false;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
//            if (cnt == 0) {
//                ans.next = tmp;
//            }
//            cnt ++;
        }
        return ans.next.next;
    }

}
