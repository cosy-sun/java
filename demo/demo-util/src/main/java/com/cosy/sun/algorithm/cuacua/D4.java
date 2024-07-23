package com.cosy.sun.algorithm.cuacua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 某个开源社区希望将最近热度比较高的开源项目出一个榜单，推荐给社区里面的开发者。对于每个开源项目，开发者可以进行关注(watch)、收藏(star)、fork、提issue、提交合并请求(MR)等。
 *
 * 数据库里面统计了每个开源项目关注、收藏、fork、issue、MR的数量，开源项目的热度根据这5个维度的加权求和进行排序。
 *
 * H = Wwatch X#watch + Wstar X#star +Wfork X#fork +Wissue X#issue +Wmr X#mr H表示热度值，Wwatch、Wstar、Wfork、Wissue、Wmr分别表示5个统计维度的权重，#watch、#star、#fork、#issue、#mr分别表示5个统计维度的统计值。
 *
 * 榜单按照热度值降序排序，对于热度值相等的，按照项目名字转换为全小写字母后的字典序排序（'a','b','c',...,'x','y','z')。
 *
 * 输入描述：
 *
 * 第一行输入为N，表示开源项目的个数，0<N<=100。
 *
 * 第二行输入为权重值列表，一共5个整型值，分别对应关注、收藏、fork、issue、MR的权重，权重取值0<W<=50。
 *
 * 第三行开始接下来的N行为开源项目的统计维度，每一行的格式为：
 *
 * name nr_watch nr_star nr_fork nr_issue nr_mr
 *
 * 其中name为开源项目的名字，由英文字母组成，长度<=50
 *
 * ，其余5个整型值分别为该开源项目关注、收藏、fork、issue、MR的数量，数量取值0<nr<=1000。
 *
 * 输出描述：
 *
 * 按照热度降序，输出开源项目的名字，对于热度值相等的，按照项目名字转换为全小写字母后的字典序排序（'a'>'b'>'c'>...>'x'>'y'>'z')。
 *
 * 补充说明：
 *
 *  收起
 *
 * 示例1
 *
 * 输入：
 *
 * 4
 * 8 6 2 8 6
 * camila 66 70 46 158 80
 * victoria 94 76 86 189 211
 * anthony 29 17 83 21 48
 * emily 53 97 1 19 218
 * 输出：
 *
 * victoria
 * camila
 * emily
 * anthony
 * 说明：
 *
 * 排序热度值计算：
 *
 * camila: 66*8 + 70*6 + 46*2 + 158*8 + 80*6 = 2784
 *
 * victoria: 94*8 + 76*6 + 86*2 + 189*8 + 211*6 = 4158
 *
 * anthony: 29*8 + 17*6 + 83*2 + 21*8 + 48*6 = 956
 *
 * emily: 53*8 + 97*6 + 1*2 + 19*8 + 218*6 = 2468
 *
 * 根据热度值降序，得到结果。

 */
public class D4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        TreeMap<Integer, List<String>> map = new TreeMap<>(
                (o1, o2) -> o2 - o1
        );
//        sc.nextLine();
//        sc.nextLine();
        for (int i = 0; i < count; i++) {
            String name = sc.next();

            int sum = 0;
            for (int j = 1; j < 6; j++) {
                sum += Integer.parseInt(sc.next()) * arr[j - 1];
            }
            List<String> strings = map.get(sum);
            if (strings == null) {
                strings = new ArrayList<>();
            }
                strings.add(name);
            map.put(sum, strings);
        }
        map.forEach( (k, v) ->{

            int size = v.size();
            if (size == 1) {
                System.out.println(v);
            } else {
                v.sort((o1, o2) -> {
                    String s1 = o1.substring(0, 1);
                    String s2 = o2.substring(0, 1);
                    return s1.compareTo(s2);
                });
                v.forEach(System.out::println);
            }

                }
        );

        }
        
}
