package com.cosy.sun.algorithm.cuacua;

public class Discard12 {

    public static void main(String[] args) {
        convert("abcdef-wd-ys-uj@-sabc", 4);
    }

    public static void convert(String str, int k) {
        String[] split = str.split("-");
        StringBuilder builder = new StringBuilder();
        builder.append(split[0]).append('-');
        int length = split[0].length() + 1;
        int count = 0;
        String substring = str.substring(length);
        String newStr = substring.replaceAll("-", "");
        int i = 0;
        for (; i < newStr.length() - k; i +=k) {
            String substring1 = newStr.substring(i, i + k);
            String c = c(substring1);
            builder.append(c).append("-");
        }
        builder.append(newStr.substring(i));
        System.out.println(builder);
    }

    public static String c(String str) {
        int upper = 0, lower = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isUpperCase(c)) {
                upper ++;
            }
            if (Character.isLowerCase(c)) {
                lower ++;
            }
        }
        return upper > lower ? str.toUpperCase() : upper == lower ? str : str.toLowerCase();
    }

}
