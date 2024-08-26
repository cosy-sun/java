package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

public class LC208Test {

    @Test
    public void test() {
        LC208.Trie trie = new LC208.Trie();
        trie.insert("sunzhenhua");
        boolean sunzhenhua = trie.search("sunzhenhua");
        boolean sun = trie.search("sun");
        trie.insert("sun");
        boolean sun1 = trie.search("sun");
        System.out.println("");
    }

}