package com.cosy.sun.algorithm.cuacua;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在一款虚拟游戏中生活，你必须进行投资以增强在虚拟游戏中的资产以免被淘汰出局。现有一家Bank，它提供有若干理财产品m，风险及投资回报不同，你有N（元）进行投资，能接受的总风险值为X。
 *
 * 你要在可接受范围内选择最优的投资方式获得最大回报。
 *
 * 说明：
 *
 * 在虚拟游戏中，每项投资风险值相加为总风险值；
 *
 * 在虚拟游戏中，最多只能投资2个理财产品；
 *
 * 在虚拟游戏中，最小单位为整数，不能拆分为小数；
 *
 * 投资额*回报率=投资回报
 *
 * 输入描述：
 *
 * 第一行：产品数(取值范围[1, 20])，总投资额(整数，取值范围[1, 10000])，可接受的总风险(整数，取值范围[1, 200])
 *
 * 第二行：产品投资回报率序列，输入为整数，取值范围[1,60]
 *
 * 第三行：产品风险值序列，输入为整数，取值范围[1,100]
 *
 * 第四行：最大投资额度序列，输入为整数，取值范围[1,10000]
 *
 * 输出描述：
 *
 * 每个产品的投资额序列
 *
 * 补充说明：
 *
 * 在虚拟游戏中，每项投资风险值相加为总风险值；
 *
 * 在虚拟游戏中，最多只能投资2个理财产品；
 *
 * 在虚拟游戏中，最小单位为整数，不能拆分为小数；
 *
 * 投资额*回报率=投资回报
 *
 * 示例1
 *
 * 输入：
 *
 * 5 100 10 
 *
 * 10 20 30 40 50 
 *
 * 3 4 5 6 10 
 *
 * 20 30 20 40 30
 *
 * 输出：
 *
 * 0 30 0 40 0
 *
 * 说明：
 *
 * 投资第二项30个单位，第四项40个单位，总的投资风险为两项相加为4+6=10
 */
public class D13 {

    private static String x = "";
    private static String y = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int productNum = sc.nextInt();
        int totalAmt = sc.nextInt();
        int risk = sc.nextInt();
        int[] inComs = extracted(productNum, sc);
        int[] risks = extracted(productNum, sc);
        int[] maxAmt = extracted(productNum, sc);

        int maxIncom = 0;

        for (int i = 0; i < productNum - 1; i++) {
            for (int j = i + 1; j < productNum; j++) {
                int compoentRisk = risks[i] + risks[j];
                if (compoentRisk > risk) {
                    continue;
                }
                int tmpIncom = 0;
                if (inComs[i] >= inComs[j]) {
                    maxIncom = getMaxIncom(totalAmt, maxAmt, i, j, inComs, maxIncom);
                } else {
                    maxIncom = getMaxIncom(totalAmt, maxAmt, j, i, inComs, maxIncom);
                }

            }

        }

        int[] res = new int[productNum];
        if (StringUtils.isNotBlank(x)) {
            String[] split = x.split("-");
            res[Integer.parseInt(split[0])] = Integer.parseInt(split[1]);
        }
        if (StringUtils.isNotBlank(y)) {
            String[] split = y.split("-");
            res[Integer.parseInt(split[0])] = Integer.parseInt(split[1]);
        }

        System.out.println(Arrays.toString(res));
    }

    private static int getMaxIncom(int totalAmt, int[] maxAmt, int i, int j, int[] inComs, int maxIncom) {
        int tmpIncom;
        if (totalAmt >= maxAmt[i]) {
            int i1 = totalAmt - maxAmt[i];
            if (i1 > maxAmt[j]) {
                i1 = maxAmt[j];
            }
            tmpIncom = maxAmt[i] * inComs[i] + i1 * inComs[j];
            if (maxIncom < tmpIncom) {
                x = i + "-" + maxAmt[i];
                y = j + "-" + i1;
                maxIncom = tmpIncom;
            }
        } else {
            tmpIncom = totalAmt * inComs[i];
            if (maxIncom < tmpIncom) {
                x = i + "-" + totalAmt;
                y = "";
                maxIncom = tmpIncom;
            }
        }
        return maxIncom;
    }

    private static int[] extracted(int productNum, Scanner sc) {
        int[] res = new int[productNum];
        for (int i = 0; i < productNum; i++) {
            res[i] = sc.nextInt();
        }
        return res;
    }

}
