package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;
import com.cosy.sun.util.DemoUtilUtils;
import org.junit.jupiter.api.Test;

class LC19Test {

    @Test
    void testRemoveNthFromEnd() {
        ListNode listNode = new ListNode(1);
        ListNode tmp = new ListNode(0, listNode);
        for (int i = 1; i < 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        DemoUtilUtils.singleLinkedTostring(tmp.next);
        ListNode listNode1 = LC19.removeNthFromEnd(tmp.next, 3);
        DemoUtilUtils.singleLinkedTostring(listNode1);
    }

}
