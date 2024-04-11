package com.cosy.sun.jdk.algorithm.leetcode;

public class LC208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("sunzhenhua");
        boolean sunzhenhua = trie.search("sunzhenhua");
        boolean sun = trie.search("sun");
        trie.insert("sun");
        boolean sun1 = trie.search("sun");
        System.out.println("");
    }

    static class Trie{

        private Trie[] child;
        private boolean isEnd;

        public Trie() {
            this.child = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int i1 = c - 'a';
                if(node.child[i1] == null) {
                    node.child[i1] = new Trie();
                }
                node = node.child[i1];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie trie = searchPrefix(word);
            return trie != null && trie.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int i1 = c - 'a';
                Trie trie = node.child[i1];
                if(trie == null) {
                    return null;
                }
                node = trie;
            }
            return node;
        }
    }

}
