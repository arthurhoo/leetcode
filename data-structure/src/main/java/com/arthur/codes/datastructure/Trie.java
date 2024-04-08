package com.arthur.codes.datastructure;

/**
 * Trie（前缀树）是一种树形数据结构，用于高效存储和检索字符串集合。
 * 它的主要特点是每个节点都代表一个字符串的字符，并且从根节点到任意一个节点的路径构成的字符串都是该节点代表的字符串的前缀。
 * Trie 树的典型应用包括自动补全、拼写检查和字符串搜索等。
 * @author: huhao
 * @create: 2024/3/13
 */
public class Trie {
    public class TrieNode {
        // 存储当前节点的子节点
        public TrieNode[] children;
        // 标记当前节点是否是一个单词的结束
        public boolean isEnd;

        // 构造函数，初始化 TrieNode
        public TrieNode() {
            children = new TrieNode[26]; // 假设只包含小写字母
            isEnd = false;
        }

    }
    public TrieNode root;

    // 初始化 Trie 树的根节点
    public Trie() {
        root = new TrieNode();
    }

    // 向 Trie 树中插入一个单词
    public void insert(String word) {
        TrieNode node = root;
        // 遍历单词中的每个字符
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // 计算当前字符在 children 数组中的索引
            int index = ch - 'a';
            // 如果当前节点的子节点中没有该字符，则创建一个新的节点
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            // 移动到下一个节点
            node = node.children[index];
        }
        // 将最后一个节点标记为单词的结束
        node.isEnd = true;
    }

    // 检查 Trie 树中是否包含一个单词
    public boolean search(String word) {
        TrieNode node = root;
        // 遍历单词中的每个字符
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            // 如果当前节点的子节点中没有该字符，则说明 Trie 树中不存在该单词
            if (node.children[index] == null) {
                return false;
            }
            // 移动到下一个节点
            node = node.children[index];
        }
        // 检查最后一个节点是否标记为单词的结束
        return node.isEnd;
    }

    // 检查 Trie 树中是否存在以指定前缀开头的单词
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        // 遍历前缀中的每个字符
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            // 如果当前节点的子节点中没有该字符，则说明 Trie 树中不存在以该前缀开头的单词
            if (node.children[index] == null) {
                return false;
            }
            // 移动到下一个节点
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 输出 true
        System.out.println(trie.search("app"));     // 输出 false
        System.out.println(trie.startsWith("app")); // 输出 true

        trie.insert("app");
        System.out.println(trie.search("app"));     // 输出 true
    }
}




