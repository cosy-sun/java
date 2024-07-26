package com.cosy.sun.algorithm.cuacua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 下图中，每个方块代表一个像素，每个像素用其行号和列号表示。
 * 为简化处理，多段线的走向只能是水平、竖直、斜向45度。
 * 上图中的多段线可以用下面的坐标串表示：(2, 8), (3, 7), (3, 6), (3, 5), (4, 4), (5, 3), (6, 2), (7, 3), (8, 4), (7, 5)。
 * 但可以发现，这种表示不是最简的，其实只需要存储6个蓝色的关键点即可，它们是线段的起点、拐点、终点，而剩下4个点是冗余的。
 * 现在，请根据输入的包含有冗余数据的多段线坐标列表，输出其最简化的结果。
 * 输入描述：
 * 2 8 3 7 3 6 3 5 4 4 5 3 6 2 7 3 8 4 7 5
 * 1、所有数字以空格分隔，每两个数字一组，第一个数字是行号，第二个数字是列号；
 * 2、行号和列号范围为[0,64)，用例输入保证不会越界，考生不必检查；
 * 3、输入数据至少包含两个坐标点。
 * 输出描述：
 * 2 8 3 7 3 5 6 2 8 4 7 5
 * 压缩后的最简化坐标列表，和输入数据的格式相同。
 * 补充说明：
 * 输出的坐标相对顺序不能变化。
 * 示例1
 * 输入：
 * 2 8 3 7 3 6 3 5 4 4 5 3 6 2 7 3 8 4 7 5
 * 输出：
 * 2 8 3 7 3 5 6 2 8 4 7 5
 * 说明：
 * 如上图所示，6个蓝色像素的坐标依次是（2,8）、（3,7）、（3,5）、（6,2）、（8,4）、（7,5）。
 * 将他们按顺序出即可。
 */
public class D50 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[][] arr = new int[split.length/ 2][2];
        for (int i = 0; i < split.length / 2; i++) {
            arr[i][0] = Integer.parseInt(split[i * 2]);
            arr[i][1] = Integer.parseInt(split[i * 2+1]);
        }

        List<String> list = new ArrayList<>();
        int x = arr[0][0], y = arr[0][1];
        list.add(x + " " + y);
        int tmpDiffX = 0, tmpDiffY = 0;
        for (int i = 1; i < arr.length; i++) {
            int tmpx = arr[i][0] - x;
            int tmpy = arr[i][1] - y;
            if (tmpDiffX == 0 && tmpDiffY == 0) {
                tmpDiffX = tmpx;
                tmpDiffY = tmpy;
            } else {
                if (tmpx != tmpDiffX || tmpy != tmpDiffY) {
                    list.add(arr[i-1][0] + " " + arr[i-1][1]);
                    tmpDiffX = tmpx;
                    tmpDiffY = tmpy;
                }
            }
            x = arr[i][0];
            y = arr[i][1];
        }
        list.add(x + " " + y);

        String collect = list.stream().collect(Collectors.joining(" "));
        System.out.println(collect);

    }

}
