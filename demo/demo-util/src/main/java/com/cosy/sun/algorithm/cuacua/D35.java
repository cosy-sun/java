package com.cosy.sun.algorithm.cuacua;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 公司用一个字符串来表示员工的出勤信息：
 * absent：缺勤
 * late：迟到
 * leaveearly：早退
 * present：正常上班
 * 现需根据员工出勤信息，判断本次是否能获得出勤奖，能获得出勤奖的条件如下：
 * 缺勤不超过一次；没有连续的迟到/早退；任意连续7次考勤，缺勤/迟到/早退不超过3次
 * 输入描述：
 * 用户的考勤数据字符串，记录条数 >= 1；输入字符串长度<10000；不存在非法输入
 * 如：
 * 2
 * present
 * present absent present present leaveearly present absent
 * 输出描述：
 * 根据考勤数据字符串，如果能得到考勤奖，输出"true"；否则输出"false"，对于输入示例的结果应为：
 * true false
 * 示例1
 * 输入：
 * 2
 * present
 * present present
 * 输出：
 * true true
 * 说明：
 */
public class D35 {

    /**
     * absent：缺勤
     *
     * late：迟到
     *
     * leaveearly：早退
     *
     * present：正常上班
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        Boolean[] res = new Boolean[count];
        for (int i = 0; i < count; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            res[i] = valid(split);
        }

        String collect = Arrays.stream(res).map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect);

    }

    private static Boolean valid(String[] split) {
        int absentCnt = 0;
        boolean continueCnt = false;

        for (int i = 0; i < split.length; i++) {
            String str = split[i];

            if (str.equals("absent")) {
                absentCnt ++;
            }
            if (absentCnt > 1) {
                return false;
            }

            if (i > 0 && i < split.length - 1) {
                continueCnt = StringUtils.equalsAny(str, "leaveearly", "late")
                        && (StringUtils.equalsAny(split[i - 1], "leaveearly", "late")
                        || StringUtils.equalsAny(split[i + 1], "leaveearly", "late"));
            } else if (i == 0 && split.length > 1) {
                continueCnt = StringUtils.equalsAny(str, "leaveearly", "late")
                        && StringUtils.equalsAny(split[i + 1], "leaveearly", "late");
            } else if (i == split.length -1 && split.length > 1) {
                continueCnt = StringUtils.equalsAny(str, "leaveearly", "late")
                        && StringUtils.equalsAny(split[i - 1], "leaveearly", "late");
            }
            if (continueCnt) {
                return false;
            }

            int tmpCnt = 0;
            if (i <= split.length - 7) {
                for (int j = i; j < split.length; j++) {
                    String strs = split[j];
                    tmpCnt += StringUtils.equalsAny(strs, "leaveearly", "late", "absent")? 1 : 0;
                }
            }
            if (tmpCnt > 3) {
                return false;
            }

        }

        return true;
    }
}
