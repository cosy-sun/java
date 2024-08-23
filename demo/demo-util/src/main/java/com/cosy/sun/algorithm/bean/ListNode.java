package com.cosy.sun.algorithm.bean;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode random;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "," + (next != null ? next.val : "") + "," + (random!=null?random.val:"");
    }
}