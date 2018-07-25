package com.arthur.codes.leetcode.solutiions.medium;

/**
 * @author: Arthur Hu
 * @date: 2018/6/7 下午2:56
 * Description:
 */


import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 Note:

 The same word in the dictionary may be reused multiple times in the segmentation.
 You may assume the dictionary does not contain duplicate words.
 Example 1:

 Input: s = "leetcode", wordDict = ["leet", "code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".
 Example 2:

 Input: s = "applepenapple", wordDict = ["apple", "pen"]
 Output: true
 Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 Note that you are allowed to reuse a dictionary word.
 Example 3:

 Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 Output: false
 */
public class WordBreakSolution {


    private List<String> dicts;

    boolean[] status;

    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args){
        WordBreakSolution wordBreakSolution = new WordBreakSolution();

        List<String> dicts = new ArrayList<>();

        dicts.add("leet");
        dicts.add("code");

        boolean finds = wordBreakSolution.wordBreak("leetcode", dicts);

        Assert.assertTrue(finds);


        dicts.clear();

        /**
         * "catsandog"
         ["cats","dog","sand","and","cat"]
         */

        dicts.add("cats");
        dicts.add("dog");
        dicts.add("sand");
        dicts.add("and");
        dicts.add("cat");

        finds = wordBreakSolution.wordBreak("catsandog",dicts);

        Assert.assertFalse(finds);

        dicts.clear();
        /**
         * "aaaaaaa"
         ["aaaa","aa"]
         */
        dicts.add("aaaa");
        dicts.add("aaa");

        finds = wordBreakSolution.wordBreak("aaaaaaa",dicts);

        Assert.assertTrue(finds);

    }




}
