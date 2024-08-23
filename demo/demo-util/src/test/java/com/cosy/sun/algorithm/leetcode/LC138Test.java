package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.ListNode;
import com.cosy.sun.util.DemoUtilUtils;
import org.junit.jupiter.api.Test;

public class LC138Test {

    @Test
    public void copyRandomListTest() {
        ListNode list1 = new ListNode(1);
        ListNode list2 = list1.next = new ListNode(2);
        ListNode list3 = list2.next = new ListNode(3);
        ListNode list4 = list3.next = new ListNode(4);
        ListNode list5 = list4.next = new ListNode(5);

        list1.random = null;
        list2.random = list1;
        list3.random = list1;
        list4.random = list1;
        list5.random = list1;

        DemoUtilUtils.singleLinkedTostring(list1);
        ListNode ListNode = LC138.copyRandomList(list1);
        DemoUtilUtils.singleLinkedTostring(ListNode);
    }
}