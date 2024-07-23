package com.cosy.sun.algorithm.cuacua;

import java.util.*;

/**
 * XX市机场停放了多架飞机，每架飞机都有自己的航班号CA3385，CZ6678，SC6508等，航班号的前2个大写字母(或数字）代表航空公司的缩写，后面4个数字代表航班信息。但是XX市机场只有一条起飞用跑道，调度人员需要安排目前停留在机场的航班有序起飞。为保障航班的有序起飞，调度员首先按照航空公司的缩写（航班号前2个字母）对所有航班进行排序，同一航空公司的航班再按照航班号的后4个数字进行排序最终获得安排好的航班的起飞顺序。请编写一段代码根据输入的航班号信息帮助调度员输出航班的起飞顺序。
 *
 * 说明：
 *
 * 1、航空公司缩写排序按照从特殊符号$ & *, 0~9，A~Z排序；
 *
 * 输入描述：第一行输入航班信息，多个航班号之间用逗号（“，”）分隔，输入的航班号不超过100个例如：
 *
 * CA3385,CZ6678,SC6508,DU7523,HK4456,MK0987
 *
 * 备注：航班号为6位长度，后4位为纯数字，不考虑存在后4位重复的场景
 *
 * 输出描述：
 *
 * CA3385,CZ6678,DU7523,HK4456,MK0987,SC6508
 *
 * 补充说明：
 *
 * 示例1
 *
 * 输入：
 *
 * CA3385,CZ6678,SC6508,DU7523,HK4456,MK0987
 *
 * 输出：
 *
 * CA3385,CZ6678,DU7523,HK4456,MK0987,SC6508
 *
 * 说明：
 *
 * 输入目前停留在该机场的航班号，输出为按照调度排序后输出的有序的航班号
 */
public class D20 {

    private static final HashMap<String, Integer> map = new HashMap<>();
    static {
        map.put("$",1);
        map.put("&",2);
        map.put("*",3);
        map.put("0",11);
        map.put("1",12);
        map.put("2",13);
        map.put("3",14);
        map.put("4",15);
        map.put("5",16);
        map.put("6",17);
        map.put("7",18);
        map.put("8",19);
        map.put("9",20);
        map.put("A",21);
        map.put("B",22);
        map.put("C",23);
        map.put("D",24);
        map.put("E",25);
        map.put("F",26);
        map.put("G",27);
        map.put("H",28);
        map.put("I",29);
        map.put("J",30);
        map.put("K",31);
        map.put("L",32);
        map.put("M",33);
        map.put("N",34);
        map.put("O",35);
        map.put("P",36);
        map.put("Q",37);
        map.put("R",38);
        map.put("S",39);
        map.put("T",40);
        map.put("U",41);
        map.put("V",42);
        map.put("W",43);
        map.put("X",44);
        map.put("Y",45);
        map.put("Z",46);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(",");
        Set<String> set = new TreeSet<>((o1, o2) -> {
            int o11 = map.get(o1.substring(0, 1));
            int o21 = map.get(o2.substring(0, 1));
            int o12 = map.get(o1.substring(1, 2));
            int o22 = map.get(o2.substring(1, 2));
            int int1 = Integer.parseInt(o1.substring(2, 6));
            int int2 = Integer.parseInt(o2.substring(2, 6));
            if (o11 - o21 != 0) {
                return o11 - o21;
            } else if (o12-o22 != 0) {
                return o12-o22;
            } else {
                return int1-int2;
            }

        });
        set.addAll(Arrays.asList(arr));
        String collect = String.join(",", set);
        System.out.println(collect);
    }

}
