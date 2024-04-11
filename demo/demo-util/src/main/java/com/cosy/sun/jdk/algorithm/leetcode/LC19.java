package com.cosy.sun.jdk.algorithm.leetcode;

import com.cosy.sun.jdk.algorithm.leetcode.bean.ListNode;

public class LC19 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode tmp = new ListNode(0, listNode);
        for (int i = 1; i < 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ListNode listNode1 = removeNthFromEnd(tmp.next, 3);
        System.out.println(listNode1);
    }

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
        ListNode ans = tmp.next;
        return ans;
    }


}
