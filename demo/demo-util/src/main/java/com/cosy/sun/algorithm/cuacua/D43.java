package com.cosy.sun.algorithm.cuacua;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给定一段"密文"字符串s,其中字符都是经过"密码本"映射的，现需要将"密文"解密并且输出
 *    映射的规则 （'a'-'i')分别用('1'-'9')表示；('j'-'z')分别用('10*'-'26*')表示
 *    约束：映射始终唯一
 * 输入描述：
 * “密文”字符串
 * 输出描述：
 * 明文字符串
 * 补充说明：
 * 翻译后的文本的长度在100以内
 * 示例1
 * 输入：
 * 20*19*20*
 * 输出：
 * tst
 * 说明：
 */
public class D43 {

    private static final Map<String, String> map = new HashMap<String, String>();

    static {
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10*", "j");
        map.put("11*", "k");
        map.put("12*", "l");
        map.put("13*", "m");
        map.put("14*", "n");
        map.put("15*", "o");
        map.put("16*", "p");
        map.put("17*", "q");
        map.put("18*", "r");
        map.put("19*", "s");
        map.put("20*", "t");
        map.put("21*", "u");
        map.put("22*", "v");
        map.put("23*", "w");
        map.put("24*", "x");
        map.put("25*", "y");
        map.put("26*", "z");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Pattern pattern = Pattern.compile("\\d{2}\\*|\\d");

        Matcher matcher = pattern.matcher(str);
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            String group = matcher.group();
            builder.append(map.get(group));
        }

        System.out.println(builder);
    }

}
