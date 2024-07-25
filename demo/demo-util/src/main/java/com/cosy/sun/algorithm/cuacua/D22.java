package com.cosy.sun.algorithm.cuacua;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 小明来到某学校当老师，需要将学生按考试总分或单科分数进行排名，你能帮帮他吗？
 *
 * 输入描述：
 *
 * 第1行输入两个整数，学生人数n和科目数量m。0<n<100,0<m<10
 *
 * 第2行输入m个科目名称，彼此之间用空格隔开。科目名称只由英文字母构成，单个长度不超过10个字符。科目的出现顺序和后续输入的学生成绩一一对应。不会出现重复的科目名称。
 *
 * 第3行开始的n行，每行包含一个学生的姓名和该生m个科目的成绩（空格隔开），学生不会重名。学生姓名只由英文字母构成，长度不超过10个字符。成绩是0~100的整数，依次对应第2行中输入的科目。
 *
 * 第n+2行，输入用作排名的科目名称。若科目不存在，则按总分进行排序。
 *
 * 输出描述：
 *
 * 输出一行，按成绩排序后的学生名字，空格隔开。成绩相同的按照学生姓名字典顺序排序。
 *
 * 补充说明：
 *
 *  收起
 *
 * 示例1
 *
 * 输入：
 *
 * 3 2
 * yuwen shuxue
 * fangfang 95 90
 * xiaohua 88 95
 * minmin 100 82
 * shuxue
 * 输出：
 *
 * xiaohua fangfang minmin
 * 说明：
 *
 * 按shuxue成绩排名，依次是xiaohua、fangfang、minmin
 */
public class D22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] ms = sc.nextLine().split(" ");
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            String name = split[0];
            int[] arr = new int[m];
            for (int j = 1; j <= m; j++) {
                String s1 = split[j];
                int i1 = Integer.parseInt(s1);
                arr[j - 1] = i1;
            }
            map.put(name, arr);
        }


        String s = sc.nextLine();
        Set<String> set = new TreeSet<>((o1, o2)-> {
            String[] split = o1.split("-");
            String[] split1 = o2.split("-");
            if (Integer.parseInt(split[1]) != Integer.parseInt(split1[1])) {
                return Integer.parseInt(split1[1]) - Integer.parseInt(split[1]);
            } else {
                return split[0].compareTo(split1[0]);
            }
        });
        if (s != null && !s.isEmpty()) {
            int index = 0;
            boolean flag = false;
            for (; index < m; index++) {
                if (ms[index].equals(s)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (Map.Entry<String, int[]> entry : map.entrySet()) {
                    String key = entry.getKey();
                    int[] arr = entry.getValue();
                    int i = arr[index];
                    String setStr = key + "-" + i;
                    set.add(setStr);
                }
            } else {
                for (Map.Entry<String, int[]> entry : map.entrySet()) {
                    String key = entry.getKey();
                    int[] arr = entry.getValue();
                    int sum = 0;
                    for (int i = 0; i < arr.length; i++) {
                        sum += arr[i];
                    }
                    String setStr = key + "-" + sum;
                    set.add(setStr);
                }
            }

        }
        String collect = set.stream().map(item -> item.split("-")[0]).collect(Collectors.joining(" "));

        System.out.println(collect);

    }

}
