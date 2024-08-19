package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.leetcode.bean.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为
 * 回文链表
 * 。如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：false
 */
public class LC234 {

    public boolean isPalindRome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode slow = findSlow(head);
        ListNode listNode = LC206.reverseList(slow.next);
        return jdgEqual(head, listNode);
    }

    private static boolean jdgEqual(ListNode head, ListNode listNode) {
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
