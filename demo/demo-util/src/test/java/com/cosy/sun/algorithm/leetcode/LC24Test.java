package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;
import com.cosy.sun.util.DemoUtilUtils;
import org.junit.jupiter.api.Test;

public class LC24Test {

    @Test
    public void swapPairsTest() {
        ListNode listNode = new ListNode(1);
        ListNode tmp = new ListNode(0, listNode);
        for (int i = 2; i < 6; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        DemoUtilUtils.singleLinkedTostring(tmp.next);
        ListNode listNode1 = LC24.swapPairs(tmp.next);
        DemoUtilUtils.singleLinkedTostring(listNode1);
    }
}