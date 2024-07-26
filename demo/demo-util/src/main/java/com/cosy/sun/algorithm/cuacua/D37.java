//package com.cosy.sun.algorithm.cuacua;
//
//import java.util.Scanner;
//import java.util.stream.Stream;
//
///**
// * 从前有个村庄，村民们喜欢在各种田地上插上小旗子，旗子上标识了各种不同的数字。某天集体村民决定将覆盖相同数字的最小矩阵形的土地的分配给为村里做出巨大贡献的村民，请问，此次分配土地，做出贡献的村民中最大会分配多大面积？
// * 输入描述：
// * 第一行输入m和n，m代表村子的土地的长，n代表土地的宽
// * 第二行开始输入地图上的具体标识
// * 输出描述：
// * 输出需要分配的土地面积，即包含相同数字旗子的最小矩阵中的最大面积。
// * 补充说明：
// * 旗子上的数字为1-500，土地边长不超过500
// * 未插旗子的土地用0标识
// * 示例1
// * 输入：
// * 3 3
// * 1 0 1
// * 0 0 0
// * 0 1 0
// * 输出：
// * 9
// * 说明：
// * 土地上的旗子为1，其坐标分别为(0,0)，(2,1)以及(0,2)，为了覆盖所有旗子，矩阵需要覆盖的横坐标为0和2，纵坐标为0和2，所以面积为9，即(2-0+1)*(2-0+1)=9。
// */
//public class D37 {
//
//
//    /**
//     * 遍历土地
//     * 每个数字的最大/最小行， 最大/最小列
//     * 然后计算面积， 选择最小的，
//     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int[] params = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int a = params[0];
//        int b = params[1];
//        int[] nums = new int[501];
//        int[] max_row = new int[501];
//        int[] max_col = new int[501];
//        int[] min_row = new int[501];
//
//        for (int i = 0; i < 501; i++) {
//            min_row[i] = 502;
//        }
//        int[] min_col = new int[501];
//        for (int i = 0; i < 501; i++) {
//            min_col[i] = 502;
//        }
//
//        for (int i = 0; i < a; ++i) {
//            for (int j = 0; j < b; ++j) {
//                int c = in.nextInt();
//                nums[c] = 1;
//                max_row[c] = Math.max(max_row[c], i);
//                max_col[c] = Math.max(max_col[c], j);
//                min_row[c] = Math.min(min_row[c], i);
//                min_col[c] = Math.min(min_col[c], j);
//            }
//        }
//        int max_area = 0;
//        for (int i = 1; i < 501; i++) {
//            int c = nums[i];
//            if (nums[i] == 1) {
//                max_area = Math.max(max_area, (max_row[i] - min_row[i] + 1) * (max_col[i] - min_col[i] + 1));
//            }
//        }
//        System.out.println(max_area);
//    }
//
//}
