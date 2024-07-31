package com.cosy.sun.algorithm.cuacua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 有一个总空间为100字节的堆，现要从中新申请一块内存，内存分配原则为优先紧接着前一块已使用内存分配空间足够且最接近申请大小的空闲内存。
 * 输入描述：
 * 输入：
 * 第1行是1个整数，表示期望申请的内存字节数；
 * 第2到N行是用空格分割的两个整数，表示当前已分配的内存的情况，每一行表示一块已分配的连续内存空间，每行的第1和第2个整数分别表示偏移地址和内存块大小，如：
 * 0 1
 * 3 2
 * 表示0偏移地址开始的1个字节和3偏移地址开始的2个字节已被分配，其余内存空闲。
 * 输出描述：
 * 输出:
 * 若申请成功，输出申请到内存的偏移；若申请失败，输出-1。
 * 补充说明：
 * 1.若输入信息不合法或无效，则申请失败。
 * 2.若没有足够的空间供分配，则申请失败。
 * 3.堆内存信息有区域重叠或有非法值等都是无效输入。
 * 示例1
 * 输入：
 * 1
 * 0 1
 * 3 2
 * 输出：
 * 1
 * 说明：
 * 堆中已使用的两块内存是偏移从0开始1字节和偏移从3开始的2字节，空闲的两块内存是偏移从1开始2个字节和偏移从5开始95字节，根据分配原则，新申请的内存应从1开始分配1个字节，所以输出偏移为1.
 */
public class D29 {

    static class Block implements Comparable<Block> {
        int start;
        int size;

        Block(int start, int size) {
            this.start = start;
            this.size = size;
        }

        // 用于对内存块进行排序
        @Override
        public int compareTo(Block other) {
            return this.start - other.start;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int requestSize = scanner.nextInt(); // 读取期望申请的内存大小

        if (requestSize <= 0 || requestSize > 100) {
            System.out.println(-1); // 请求大小不合法
            scanner.close();
            return;
        }

        ArrayList<Block> usedBlocks = new ArrayList<>();
        while (scanner.hasNext()) {
            int start = scanner.nextInt();
            int size = scanner.nextInt();

            if (start < 0 || size <= 0 || start + size > 100) {
                System.out.println(-1); // 块的起始地址或大小不合法
                scanner.close();
                return;
            }
            usedBlocks.add(new Block(start, size));
        }
        scanner.close();

        // 检查内存块是否重叠
        Collections.sort(usedBlocks);
        for (int i = 1; i < usedBlocks.size(); i++) {
            if (usedBlocks.get(i).start < usedBlocks.get(i - 1).start + usedBlocks.get(i - 1).size) {
                System.out.println(-1); // 内存块重叠
                return;
            }
        }

        // 寻找合适的空闲内存块
        ArrayList<Block> freeBlocks = new ArrayList<>();
        int currentEnd = 0;
        for (Block block : usedBlocks) {
            if (block.start > currentEnd) {
                freeBlocks.add(new Block(currentEnd, block.start - currentEnd));
            }
            currentEnd = block.start + block.size;
        }

        if (currentEnd < 100) {
            freeBlocks.add(new Block(currentEnd, 100 - currentEnd));
        }

        // 选择最合适的空闲块
        int bestFitStart = -1;
        int minSizeDiff = Integer.MAX_VALUE;
        for (Block block : freeBlocks) {
            if (block.size >= requestSize && block.size - requestSize < minSizeDiff) {
                bestFitStart = block.start;
                minSizeDiff = block.size - requestSize;
            }
        }

        System.out.println(bestFitStart); // 输出最合适的起始位置或-1
    }


}
