package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 现代计算机系统中通常存在多级的存储设备，针对海量workload的优化的一种思路是将热点内存页优先放到快速存储层级，这就需要对内存页进行冷热标记。
 * 一种典型的方案是基于内存页的访问频次进行标记，如果统计窗口内访问次数大于等于设定阈值，则认为是热内存页，否则是冷内存页。
 * 对于统计窗口内跟踪到的访存序列和阈值，现在需要实现基于频次的冷热标记。内存页使用页框号作为标识。
 * 输入描述：
 * 第一行为输入为N，表示访存序列的记录条数，0＜N≤10000
 * 第二行为访存序列，空格间隔的N个内存页框号，页框号范围0-65535，同一页框号可能重复出现，出现的次数即为对应页框号的频次。第三行为热内存页的频次阈值T，正整数，范围1≤T≤10000
 * 输出描述：
 * 第一行输出标记为热内存的内存页个数，如果没有被标记为热内存的，则输出0。
 * 如果第一行>0，则接下来按照访问频次降序输出内存页框号，一行一个，频次一样的页框号，页框号小的排前面。
 * 补充说明：
 * 示例1
 * 输入：
 * 10
 * 1 2 1 2 1 2 1 2 1 2
 * 5
 * 输出：
 * 2
 * 1
 * 2
 * 说明：
 * 内存页1和内存页2均被访问了5次，达到了阈值5，因此热内存页有2个。内存页1和内存页2的访问频次相等，页框号小的排前面。
 */
public class D42 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Set<String> set = new TreeSet<>((String s1, String s2) -> {
            String s10 = s1.split("-")[0];
            String s11 = s1.split("-")[1];
            String s20 = s2.split("-")[0];
            String s21 = s2.split("-")[1];
            if (Integer.parseInt(s10) != Integer.parseInt(s20)) {
                return Integer.parseInt(s20) - Integer.parseInt(s10);
            } else {
                return Integer.parseInt(s11) - Integer.parseInt(s21);
            }
        });
        int[] arr = new int[65536];
        for (int i = 0; i < count; i++) {
            int pageNum = sc.nextInt();
            arr[pageNum] ++;
        }
        int limit = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= limit) {
                String str = arr[i] + "-" + i;
                set.add(str);
            }
        }

        System.out.println(set.size());
        set.forEach(item -> {
            String s = item.split("-")[1];
            System.out.println(s);
        });


    }

}
