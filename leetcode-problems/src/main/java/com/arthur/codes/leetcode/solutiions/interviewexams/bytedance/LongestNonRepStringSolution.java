package com.arthur.codes.leetcode.solutiions.interviewexams.bytedance;

import java.util.HashSet;

/**
 * @author: Arthur Hu
 * @date: 2019/3/18 下午6:24
 * Description:
 */
public class LongestNonRepStringSolution {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

     示例 1:

     输入: "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:

     输入: "bbbbb"
     输出: 1
     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:

     输入: "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */


    public int lengthOfLongestSubstringWithWindow(String s) {
        int maxLength = 0;

        if(s == null || s.length()==0){
            return maxLength;
        }

        if(s.length() == 1){
            maxLength = 1;

            return maxLength;
        }


        HashSet<Character> characterHashSet = new HashSet<>();

        int i = 0, j=i;

        int length = s.length();

        while(i<length && j < length){

            if(!characterHashSet.contains(s.charAt(j))){
                characterHashSet.add(s.charAt(j));
                j++;

                maxLength = Math.max(maxLength, j-i);

            }else{
                characterHashSet.remove(s.charAt(i));
                i++;
            }

        }

        return maxLength;
    }


    public static void main(String[] args){
        String a = "abcabcbb";

        LongestNonRepStringSolution longestNonRepStringSolution = new LongestNonRepStringSolution();

        int aResult = longestNonRepStringSolution.lengthOfLongestSubstringWithWindow(a);

        System.out.println(aResult);

        int[] b = new int[25];

        System.out.println(b[24]);
    }

}
