package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;

import java.util.HashMap;

public class LC142 {

    public static ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        int i = 0;
        ListNode node = head;
        ListNode res = null;
        while(node != null) {
            if(!map.containsKey(node)) {
                map.put(node, i ++);
            } else {
                res = node;
                break;
            }
            node = node.next;
        }
        return res;

    }

}
