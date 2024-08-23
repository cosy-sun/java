package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LC138 {

    static Map<ListNode, ListNode> cachedListNode = new HashMap<>();

    public static ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (!cachedListNode.containsKey(head)) {
            ListNode headNew = new ListNode(head.val);
            cachedListNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedListNode.get(head);
    }

}
