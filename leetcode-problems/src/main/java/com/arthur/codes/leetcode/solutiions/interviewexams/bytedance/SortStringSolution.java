package com.arthur.codes.leetcode.solutiions.interviewexams.bytedance;

import java.util.Arrays;

/**
 * @author: Arthur Hu
 * @date: 2019/3/19 下午5:26
 * Description:
 */
public class SortStringSolution {

    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

     换句话说，第一个字符串的排列之一是第二个字符串的子串。

     示例1:

     输入: s1 = "ab" s2 = "eidbaooo"
     输出: True
     解释: s2 包含 s1 的排列之一 ("ba").


     示例2:

     输入: s1= "ab" s2 = "eidboaoo"
     输出: False

     输入的字符串只包含小写字母
     两个字符串的长度都在 [1, 10,000] 之间

     思路：https://www.cnblogs.com/MrSaver/p/9638279.html

     * @param s1
     * @param s2
     * @return
     */

    public boolean checkInclusion(String s1, String s2) {

        /**
         * 此题字符串只有小写字母，可以通过
         */

        if(s1 == null || s2==null){
            return false;
        }

        if(s1.length() > s2.length()){
            return false;
        }

        if(s1.length() < 1 || s1.length()>10000 || s2.length() < 1 || s2.length() > 10000){

            return false;
        }


        int[] s1Hash = new int[26];

        int[] s2Hash = new int[26];


        for(char c:s1.toCharArray()){
            s1Hash[c-'a']++;
        }

        for(int j=0;j<s2.length();j++){
            if(j >= s1.length()){
                --s2Hash[s2.charAt(j-s1.length())-'a'];  //先将上一个循环内的数组值清空
            }

            s2Hash[s2.charAt(j)-'a']++;

            if(Arrays.equals(s2Hash,s1Hash)){
                return true;
            }
        }

        return false;


    }



}
