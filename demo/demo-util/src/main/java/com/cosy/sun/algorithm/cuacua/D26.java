package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 现有N个任务需要处理，同一时间只能处理一个任务，处理每个任务所需要的时间固定为1。
 * 每个任务都有最晚处理时间限制和积分值，在最晚处理时间点之前处理完成任务才可获得对应的积分奖励。
 * 可用于处理任务的时间有限，请问在有限的时间内，可获得的最多积分。
 * 输入描述：第一行为一个数N，表示有N个任务，1<=N<=100
 *                   第二行为一个数T，表示可用于处理任务的时间。1<=T<=100
 *                   接下来N行，每行两个空格分隔的整数(SLA和V)，SLA表示任务的最晚处理时间，V表  示任务对应的积分。1<=SLA<=100, 0<=V<=100000
 * 输出描述：可获得的最多积分
 * 示例
 *  示例1
 * 输入：4
 *            3
 *            1 2 
 *            1 3
 *            1 4
 *            1 5
 * 输出：5
 * 说明：虽然有3个单位的时间用于处理任务，可是所有任务在时刻1之后都无效。
 *           所以在第1个时间单位内，选择处理有5个积分的任务。1-3时无任务处理。
 */
public class D26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int taskCount = sc.nextInt();
        int time = sc.nextInt();
        sc.nextLine();
        Set<String> set = new TreeSet<>((s1, s2) -> {
            String[] split = s1.split(" ");
            String[] split1 = s2.split(" ");
            int s01 = Integer.parseInt(split[0]);
            int s02 = Integer.parseInt(split1[0]);
            int s11 = Integer.parseInt(split[1]);
            int s12 = Integer.parseInt(split1[1]);
            if (s01 != s02) {
                return s02 - s01;
            } else {
                return s12 - s11;
            }
        });
        for (int i = 0; i < taskCount; i++) {
            set.add(sc.nextLine());
        }
        int total = 0;
        String tmp = "";
        for (String s : set) {
            if (time == 0) {
                break;
            }
            String[] split = s.split(" ");
            String s1 = split[0];
            String s2 = split[1];
            if (!tmp.equals(s1)) {
                total += Integer.parseInt(s2);
                tmp = s1;
                time -- ;
            }
        }
        System.out.println(total);

    }

}
