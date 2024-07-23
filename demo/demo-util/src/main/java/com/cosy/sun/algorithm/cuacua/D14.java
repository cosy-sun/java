package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 程序员小明打了一辆出租车去上班。出于职业敏感，他注意到这辆出租车的计费表有点问题，总是偏大。
 *
 * 出租车司机解释说他不喜欢数字4，所以改装了计费表，任何数字位置遇到数字4就直接跳过，其余功能都正常。
 *
 * 比如：
 *
 * 1.     23再多一块钱就变为25；
 *
 * 2.     39再多一块钱变为50；
 *
 * 3.     399再多一块钱变为500；
 *
 * 小明识破了司机的伎俩，准备利用自己的学识打败司机的阴谋。
 *
 * 给出计费表的表面读数，返回实际产生的费用。
 *
 * 输入描述：
 *
 * 只有一行，数字N，表示里程表的读数。
 *
 * (1<=N<=888888888)。
 *
 * 输出描述：
 *
 * 一个数字，表示实际产生的费用。以回车结束。
 *
 * 示例1
 *
 * 输入：
 *
 * 5
 *
 * 输出：
 *
 * 4
 *
 * 说明：
 *
 * 5表示计费表的表面读数。
 *
 * 4表示实际产生的费用其实只有4块钱。
 */
public class D14 {

    static int count=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.valueOf(in.nextLine());
        init(n);
        System.out.println(count);

    }
    static void init(int max){
        int idx=max;
        while(idx>0){
            idx = check(idx);
            count++;
            idx--;
        }

    }
    static int check(int num){
        int res =num;
        String str = String.valueOf(num).replace("4","3");
        return Integer.valueOf(str);
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int price = sc.nextInt();
//        sc.close();
//
//        int pri = 0, i = 1;
//        for (; pri != price; i ++) {
//            pri ++;
//            pri += excessiveAmt(i);
//            if (pri == price) {
//                System.out.println(i);
//                break;
//            }
//        }
//
//    }
//
//    public static int excessiveAmt(int gl) {
//        int i = 0;
//        int tmp = gl;
//        int res = 0;
//        while (tmp > 0) {
//
//            int i1 = tmp % 10;
//            tmp = tmp /10;
//            if (i1 == 4) {
//                res += (int) Math.pow(i1, i);
//            }
//            i ++;
//        }
//        return res;
//    }

}
