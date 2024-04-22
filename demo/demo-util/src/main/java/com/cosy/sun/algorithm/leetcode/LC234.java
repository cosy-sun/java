package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.leetcode.bean.ListNode;

public class LC234 {

    public boolean isPalindRome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode slow = findSlow(head);
        ListNode listNode = reverseList(slow.next);

        ListNode p1 = head;
        ListNode p2 = listNode;
        while(p1 != null && p2 != null) {
            if(p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
    
    private ListNode findSlow(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(slow.next != null
                && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
