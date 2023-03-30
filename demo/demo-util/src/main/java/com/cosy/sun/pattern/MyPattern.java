package com.cosy.sun.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPattern {

    private static final String REGEX_1 = "([A-Z]+)([a-z]+)";
    private static final String REGEX_2 = "([A-Z]+)(?=[a-z]+)";
    private static final String REGEX_3 = "([A-Z]+)(?![a-z]+)";
    private static final String REGEX_4 = "(?<=[a-z]{3})([A-Z]+)";
    private static final String REGEX_5 = "(?<![a-z]{3})([A-Z]+)";



    public boolean match(String str, String regex) {
        Pattern implementation = Pattern.compile(regex);
        Matcher matcher = implementation.matcher(str);
        while(matcher.find()) {
            int i = matcher.groupCount();
            for(int j =0; j<= i; j ++) {
                System.out.println(matcher.group(j));
            }
        }
        return matcher.matches();
    }

    public static void main(String[] args) {
        MyPattern myPattern = new MyPattern();
        boolean match = myPattern.match("ABCabc", MyPattern.REGEX_1);
        System.out.println(match);
        System.out.println("------");
        boolean match1 = myPattern.match("ABCabc", MyPattern.REGEX_2);
        System.out.println(match1);
        System.out.println("------");
        boolean match2 = myPattern.match("ABCabc", MyPattern.REGEX_3);
        System.out.println(match2);
        System.out.println("------");
        boolean match3 = myPattern.match("abcABC", MyPattern.REGEX_4);
        System.out.println(match3);
        System.out.println("------");
        boolean match4 = myPattern.match("abcABC", MyPattern.REGEX_5);
        System.out.println(match4);
        System.out.println("------");
    }

}
