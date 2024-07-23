package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 有一个字符串数组words和一个字符串chars。
 *
 * 假如可以用chars中的字母拼写出words中的某个“单词”（字符串），那么我们就认为你掌握了这个单词。
 *
 * words的字符仅由 a-z 英文小写字母组成。 例如: abc
 *
 * chars 由 a-z 英文小写字母和 “?”组成。其中英文问号“?”表示万能字符，能够在拼写时当做任意一个英文字母。 例如： "?" 可以当做 "a"等字母。
 *
 * 注意：每次拼写时，chars中的每个字母和万能字符都只能使用一次。
 *
 * 输出词汇表words中你掌握的所有单词的个数。 没有掌握任何单词，则输出0。
 *
 * 输入描述：
 *
 * 第1行输入数组words的个数，记为N。
 *
 * 从第2行开始到第N+1行依次输入数组words的每个字符串元素。
 *
 * 第N+2行输入字符串chars。
 *
 * 输出描述：
 *
 * 输出一个整数，表示词汇表words中你掌握的单词个数。
 *
 * 补充说明：
 *
 * 注意：
 *
 * 1 <= words.length <= 100
 *
 * 1 <= words[i].length, chars.length <= 100
 *
 * 所有字符串中都仅包含小写英文字母、英文问号
 *
 * 示例1
 *
 * 输入：
 *
 * 4
 *
 * cat
 *
 * bt
 *
 * hat
 *
 * tree
 *
 * atach??
 *
 * 输出：
 *
 * 3
 *
 * 说明：
 *
 * 可以拼写字符串"cat"、"bt"和"hat"
 */

public class D16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wordNum = Integer.parseInt(sc.nextLine());
        String[] words = new String[wordNum];
        for (int i = 0; i < wordNum; i++) {
            words[i] = sc.nextLine();
        }
        String chars = sc.nextLine();
        int res = 0;
        for (String word : words) {
            res += master(word, chars) ? 1 : 0;
        }
        System.out.println(res);

    }

    private static boolean master(String word, String chars) {
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if (chars.contains(String.valueOf(w))) {
                chars = chars.replaceFirst(String.valueOf(w), "0");
            } else if (chars.contains("?")) {
                chars = chars.replaceFirst("\\?", "0");
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
