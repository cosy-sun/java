package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * “吃货”和“馋嘴”两人到披萨店点了一份铁盘（圆形）披萨，并嘱咐店员将披萨按放射状切成大小相同的偶数扇形小块。但是粗心服务员将披萨切成了每块大小都完全不同奇数块，且肉眼能分辨出大小。
 * 由于两人都想吃到最多的披萨，他们商量了一个他们认为公平的分法：从“吃货”开始，轮流取披萨。除了第一块披萨可以任意选取以外，其他都必须从缺口开始选。
 * 他俩选披萨的思路不同。“馋嘴”每次都会选最大块的披萨，而且“吃货”知道“馋嘴”的想法。
 * 已知披萨小块的数量以及每块的大小，求“吃货”能分得的最大的披萨大小的总和。
 * 输入描述：
 * 第1行为一个正整数奇数N，表示披萨小块数量。3 <= N < 500。
 * 接下来的第2行到第N+1行（共N行），每行为一个正整数，表示第i块披萨的大小。1 <= i <= N。披萨小块从某一块开始，按照一个方向依次顺序编号为1~N。每块披萨的大小范围为[1, 2147483647]。
 * 输出描述：
 * “吃货”能分得的最大的披萨大小的总和。
 * 补充说明：
 * 示例1
 * 输入：
 * 5
 * 8
 * 2
 * 10
 * 5
 * 7
 * 输出：
 * 19
 * 说明：
 * 此例子中，有5块披萨。每块大小依次为8、2、10、5、7。按照如下顺序拿披萨，可以使“吃货”拿到最多披萨：
 * 1、“吃货”拿大小为10的披萨
 * 2、“馋嘴”拿大小为5的披萨
 * 3、“吃货”拿大小为7的披萨
 * 4、“馋嘴”拿大小为8的披萨
 * 5、“吃货”拿大小为2的披萨
 * 至此，披萨瓜分完毕，“吃货”拿到的披萨总大小为10+7+2=19。
 */
public class D33 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }

        }
        int sum = 0;
        int pre  = maxIndex - 1;
        if (pre < 0) {
            pre = count - 1;
        }
            for (int j = maxIndex; j < count; ) {
                sum += arr[j];

                if (j == pre) {
                    break;
                }
                if (j == count - 1) {
                    j += 2 - count;
                } else {
                    j += 2;
                }
            }

        System.out.println(sum);

    }

}
