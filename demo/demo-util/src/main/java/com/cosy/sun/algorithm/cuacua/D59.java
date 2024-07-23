//package com.cosy.sun.algorithm.cuacua;
//
//import lombok.Data;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
///**
// * 悄悄话
// */
//public class D59 {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String[] split = s.split(" ");
//        int length = split.length;
//        int[] arr = new int[length];
//        for (int i = 0; i < length; i++) {
//            int i1 = Integer.parseInt(split[i]);
//            arr[i] = i1;
//        }
//        int sum = sum(arr);
//        System.out.println(sum);
//    }
//
//
//    public static int sum(int... req) {
//        int sum = 0;
//        Queue<Ele> queue = new LinkedList<>();
//        queue.offer(new Ele(req[0]));
//        int startIndex = 1;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            Ele poll = queue.poll();
//            for (; startIndex < 2 * size; startIndex++) {
//                int num = req[startIndex];
//                if (num != -1) {
//                    queue.offer();
//
//                }
//            }
//        }
//        return sum;
//
//    }
//
//
//    @Data
//    static class Ele {
//        int value;
//        Ele left;
//        Ele right;
//
//        public Ele(int value) {
//            this.value = value;
//        }
//    }
//
//}
