package com.cosy.sun.jdk.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC22 {

    public List<String> generaterParenthesis(int n) {
        return generate(n);
    }

    List[] cache = new ArrayList[100];

    private List<String> generate(int n) {
        if(cache[n] != null) {
            return cache[n];
        }

        List<String> ans = new ArrayList<>();
        if(n == 0) {
            ans.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generate(i)) {
                    for (String right : generate(n -i -1)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

}
