package com.cosy.sun.algorithm.cuacua;

import java.util.*;

/**
 *为了达到新冠疫情精准防控的需要，为了避免全员核酸检测带来的浪费，需要精准圈定可能被感染的人群。
 * 现在根据传染病流调以及大数据分析，得到了每个人之间在时间、空间上是否存在轨迹的交叉。
 * 现在给定一组确诊人员编号（X1, X2, X3, .... Xn）,在所有人当中，找出哪些人需要进行核酸检测，输出需要进行核酸检测的人数。（注意：确诊病例自身不需要再做核酸检测）
 * 需要进行核酸检测的人，是病毒传播链条上的所有人员，即有可能通过确诊病例所能传播到的所有人。
 * 例如：A是确诊病例，A和B有接触、B和C有接触、C和D有接触、D和E有接触，那么B\C\D\E都是需要进行核酸检测的人。
 * 输入描述：
 * 第一行为总人数N
 * 第二行为确诊病例人员编号（确诊病例人员数量<N），用逗号分割
 * 第三行开始，为一个N*N的矩阵，表示每个人员之间是否有接触，0表示没有接触，1表示有接触。
 * 输出描述：
 * 整数：需要做核酸检测的人数
 * 补充说明：
 * 人员编号从0开始
 * 0<N<100
 * 示例1
 * 输入：
 * 5
 * 1,2
 * 1,1,0,1,0
 * 1,1,0,0,0
 * 0,0,1,0,1
 * 1,0,0,1,0
 * 0,0,1,0,1
 * 输出：
 * 3
 * 说明：
 * 编号为1、2号的人员，为确诊病例。
 * 1号与0号有接触，0号与3号有接触。
 * 2号与4号有接触。
 * 所以，需要做核酸检测的人是0号、3号、4号，总计3人需要进行核酸检测。
 */
public class D41 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim()); // 读取并解析总人数

        String[] infectedInput = scanner.nextLine().split(",");
        Set<Integer> infected = new HashSet<>(); // 使用 Set 存储确诊病例编号，避免重复
        for (String s : infectedInput) {
            infected.add(Integer.parseInt(s.trim())); // 转换并添加确诊病例编号
        }

        int[][] contacts = new int[N][N]; // 接触矩阵
        for (int i = 0; i < N; i++) {
            String[] line = scanner.nextLine().split(","); // 分割每行的输入
            for (int j = 0; j < N; j++) {
                contacts[i][j] = Integer.parseInt(line[j].trim()); // 将输入填入接触矩阵
            }
        }
        scanner.close();

        Set<Integer> toTest = new HashSet<>(); // 需要进行核酸检测的人员集合
        boolean[] visited = new boolean[N]; // 访问标记数组

        // 初始化访问队列，使用 LinkedList 实现 Queue 接口
        Queue<Integer> queue = new LinkedList<>();
        for (int index : infected) {
            visited[index] = true; // 标记确诊病例为已访问
        }

        // 遍历确诊病例，将与之直接接触的未访问个体加入队列
        for (int index : infected) {
            for (int j = 0; j < N; j++) {
                if (contacts[index][j] == 1 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                    toTest.add(j); // 记录需要测试的人员
                }
            }
        }

        // 广度优先搜索，探索所有通过接触可传播到的个体
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int j = 0; j < N; j++) {
                if (contacts[current][j] == 1 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                    toTest.add(j); // 记录需要测试的人员
                }
            }
        }

        // 输出需要进行核酸检测的人数
        System.out.println(toTest.size());
    }

}
