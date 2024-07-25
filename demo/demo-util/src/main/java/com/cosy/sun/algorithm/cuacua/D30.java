package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 某个产品当前迭代周期内有N个特性（ F1,F2,.......FN）需要进行覆盖测试，每个特性都被评估了对应的优先级，特性使用其ID作为下标进行标识。
 * 设计了M个测试用例（T1,T2......,TM ），每个用例对应了一个覆盖特性的集合，测试用例使用其ID作为下标进行标识，测试用例的优先级定义为其覆盖的特性的优先级之和。
 * 在开展测试之前，需要制定测试用例的执行顺序，规则为：优先级大的用例先执行，如果存在优先级相同的用例，用例ID小的先执行。
 * 输入描述：
 * 第一行输入为N和M，N表示特性的数量，M表示测试用例的数量， 0＜N≤100,
 * 0＜M≤100 之后N行表示特性ID=1到特性ID=N的优先级。
 * 再接下来M行表示测试用例ID=1到测试用例ID=M关联的特性的ID的列表。
 * 输出描述：
 * 按照执行顺序（优先级从大到小）输出测试用例的ID，每行一个ID。
 * 测试用例覆盖的ID不重复。
 * 示例1
 * 输入：5 4
 *            1
 *            1
 *            2
 *            3
 *            5
 *           1 2 3
 *           1 4
 *           3 4 5
 *           2 3 4
 * 输出：3
 *            4
 *            1
 *            2
 * 说明：测试用例的优先级计算如下：
 *           T1=Pf1+Pf2+Pf3=1+1+2=4
 *           T2=Pf1+Pf4=1+3=4
 *           T3=Pf3+Pf4+Pf5=2+3+5=10
 *           T4=Pf2+Pf3+Pf4=1+2+3=6
 * 按照优先级从小到大，以及相同优先级，ID小的先执行的规则，执行顺序为T3,T4,T1,T2
 */
public class D30 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int funcCount = sc.nextInt();
        int testCount = sc.nextInt();
        int[] funcArr = new int[funcCount];
        for (int i = 0; i < funcCount; i++) {
            funcArr[i] = sc.nextInt();
        }

        sc.nextLine();
        Set<String> testSet = new TreeSet<>((o1, o2) -> {
            String s = o1.split(" ")[0];
            String o = o2.split(" ")[0];
            String s1 = o1.split(" ")[1];
            String s2 = o2.split(" ")[1];
            if (Integer.parseInt(o) != Integer.parseInt(s)) {
                return Integer.parseInt(o) - Integer.parseInt(s);
            } else {
                return Integer.parseInt(s1) - Integer.parseInt(s2);
            }
        });
        for (int i = 0; i < testCount; i++) {
            String[] tests = sc.nextLine().split(" ");
            int optimeize = 0;
            for (int j = 0; j < tests.length; j++) {
                optimeize += funcArr[Integer.parseInt(tests[j]) - 1];
            }
            int i1 = i + 1;
            testSet.add(optimeize + " " + i1);
        }
        testSet.forEach(item -> {
            String s = item.split(" ")[1];
            System.out.println(s);
        });
    }

}
