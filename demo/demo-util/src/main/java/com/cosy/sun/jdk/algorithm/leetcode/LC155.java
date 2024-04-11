package com.cosy.sun.jdk.algorithm.leetcode;

public class LC155 {

    public static void main(String[] args) {
        LC155 lc155 = new LC155();
        lc155.push(2);
        lc155.push(0);
        lc155.push(3);
        lc155.push(0);
        int min1 = lc155.getMin();
        lc155.pop();
        int min2 = lc155.getMin();
        lc155.pop();
        int min3 = lc155.getMin();
        lc155.pop();
        int min4 = lc155.getMin();
        lc155.pop();
        System.out.println();
    }

    private Integer min;

    private int top = -1;

    private Object[] arr;

    public LC155() {
        arr = new Object[2];
        min = Integer.MAX_VALUE;
    }

    public synchronized <T> void push(T ele) {
        expansion();
        arr[++ top] = ele;
        min = (Integer) ele < min ? (Integer) ele : min;
    }

    private void expansion() {
        if(top + 1 > arr.length - 1) {
            Object[] tmp = new Object[arr.length * 2];
            System.arraycopy(arr, 0, tmp, 0, arr.length);
            arr = tmp;
        }
    }
    private void subCapacity() {
        if(arr.length / 2 - 1 >= top && arr.length > 2) {
            Object[] tmp = new Object[arr.length/2];
            System.arraycopy(arr, 0, tmp, 0, tmp.length);
            arr = tmp;
        }
    }

    public <T> T pop() {
        if(top - 1 >= -1) {
            T res = (T) arr[top];
            arr[top] = null;
            top --;
            subCapacity();
            if((Integer) res == min) {
                Integer x = Integer.MAX_VALUE;
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i] != null && (Integer) arr[i] < x) {
                        x = (Integer) arr[i];
                    }
                }
                min = x;
            }
            return res;
        } else {
            return null;
        }
    }


    public int top() {
        return (int) arr[top];
    }

    public int getMin() {
        return min;
    }

}
