package com.cosy.sun.algorithm.cuacua;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 幼儿园组织活动，老师布置了一个任务：每个小朋友去了解与自己同一个小区的小朋友还有几个。我们将这些数量汇总到数组garden中。
 * 请根据这些小朋友给出的信息，计算班级小朋友至少来自几个小区？
 * 输入描述：
 * 输入：garden[] = {2, 2, 3}
 * 说明：
 * garden数组长度最大为999
 * 每个小区的小朋友数量最多1000人，也就是garden[i]的范围为[0,999]
 * 输出描述：
 * 输出：7
 * 补充说明：
 * 示例1
 * 输入：
 * 2 2 3
 * 输出：
 * 7
 * 说明：
 * 解释：
 * 第一个小朋友反馈有两个小朋友和自己同一小区，即此小区有3个小朋友
 * 第二个小朋友反馈有两个小朋友和自己同一小区，即此小区有3个小朋友。
 * 这两个小朋友，可能是同一小区的，且此小区的小朋友只有3个人。
 * 第三个小区反馈还有3个小朋友与自己同一小区，则这些小朋友只能是另外一个小区的。这个小区有4个小朋友。
 */
public class D24 {

    // 计算一共多少个小朋友
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]) + 1;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int j : arr) {
            map.merge(j, 1, Integer::sum);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key < value) {
                int i = value / key;
                if (value % key == 0) {
                    res += i * key;
                } else {
                    res += (i + 1) * key;
                }
            } else {
                res += key;
            }
        }

        System.out.println(res);

    }

}
