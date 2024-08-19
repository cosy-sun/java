package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;

public class LC160 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode tmp = new ListNode(0, listNode);
        for (int i = 1; i < 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        
        ListNode listNode2 = new ListNode(1);
        ListNode tmp2 = new ListNode(0, listNode2);
        for (int i = 5; i < 7; i++) {
            listNode2.next = new ListNode(i);
            listNode2 = listNode2.next;
        }

        ListNode intersectionNode = getIntersectionNode(tmp.next, tmp2.next);
        System.out.println(intersectionNode);
    }
    
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (headA.val != headB.val) {
            headA = headA == null ? tmpB : headA.next;
            headB = headB == null ? tmpA : headB.next;
        }
        return headA;
    }
}
