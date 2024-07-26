package com.cosy.sun.algorithm.cuacua;

import java.io.IOException;
import java.util.Scanner;

/**
 *黑白图像常采用灰度图的方式存储，即图像的每个像素填充一个灰阶值，256阶灰度图是一个灰阶值取值范围为0-255的灰阶矩阵，0表示全黑、255表示全白，范围内的其他值表示不同的灰度。但在计算机中实际存储时，会使用压缩算法，其中一种压缩格式和描述如下：
 * 10 10 255 34 0 1 255 8 0 3 255 6 0 5 255 4 0 7 255 2 0 9 255 21
 * 1、所有数值以空格分隔
 * 2、前两个数分别表示矩阵的行数和列数
 * 3、从第三个数开始，每两个数一组，每组第一个数是灰阶值，第二个数表示该灰阶值从左到右，从上到下（可理解为将二维数组按行存储在一维矩阵中）的连续像素个数。比如题目所述例子，“255 34”表示有连续34个像素的灰阶值是255。
 * 如此，图像软件在打开此格式灰度图的时候，就可以根据此算法从压缩数据恢复出原始灰度图矩阵。
 * 请从输入的压缩数恢复灰度图原始矩阵，并返回指定像素的灰阶值。
 * 输入描述：
 * 10 10 255 34 0 1 255 8 0 3 255 6 0 5 255 4 0 7 255 2 0 9 255 21
 * 3 4
 * 输入包括两行，第一行是灰度图压缩数据，第二行表示一个像素位置的行号和列号，如：0 0 表示左上角像素。
 * 输出描述：
 * 0
 * 输入数据表示的灰阶矩阵的指定像素的灰阶值。
 * 补充说明：
 * 1、系统保证输入的压缩数据是合法有效的，不会出现数据越界、数值不合法等无法恢复的场景；
 * 2、系统保证输入的像素坐标是合法的，不会出现不在矩阵中的像素；
 * 3、矩阵的行和列数范围为：(0,100]；
 * 4、灰阶值取值范围：[0, 255]；
 * 示例1
 * 输入：
 * 10 10 56 34 99 1 87 8 99 3 255 6 99 5 255 4 99 7 255 2 99 9 255 21
 * 3 4
 * 输出：
 * 99
 * 说明：
 * 将压缩数据恢复后的灰阶矩阵第3行第4列的像素灰阶值是99.
 */
public class D47 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String zipData = sc.nextLine();
        int x = sc.nextInt();
        int y = sc.nextInt();

        String[] split = zipData.split(" ");

        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        int[][] ints = unZip(arr);

        System.out.println(ints[x][y]);

    }

    private static int[][] unZip(int[] arr) {
        int row = arr[0];
        int col = arr[1];
        int[] oneArr = new int[row * col];
        int tmpIndex = 0;
        for (int i = 2; i < arr.length; i+=2) {
            int i1 = arr[i];
            int i2 = arr[i + 1];
            for (int j = tmpIndex; j < tmpIndex + i2; j++) {
                oneArr[j] = i1;
            }
            tmpIndex += i2;
        }

        int[][] ints = new int[row][col];
        int k = 0;
        for (int i = 0; i < oneArr.length; i+=col) {
            int[] tmp = new int[col];
            System.arraycopy(oneArr,i,tmp,0,col);
            ints[k++] = tmp;
        }
        return ints;
    }

}
