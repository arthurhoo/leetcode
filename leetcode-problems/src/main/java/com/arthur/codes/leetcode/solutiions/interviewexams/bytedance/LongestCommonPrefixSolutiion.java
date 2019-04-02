package com.arthur.codes.leetcode.solutiions.interviewexams.bytedance;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author: Arthur Hu
 * @date: 2019/3/18 下午7:35
 * Description:
 */
public class LongestCommonPrefixSolutiion {

    /**
     * 示例 1:

     输入: ["flower","flow","flight"]
     输出: "fl"
     示例 2:

     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。

     所有输入只包含小写字母 a-z 。
     */


    /**
     * Horizonal Scan
     * @param strs
     * @return
     */

    public String longestCommonPrefixHorizon(String[] strs) {

        if(null == strs || strs.length == 0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }

        String commonPrefix= strs[0];
        int j;
        for (int i=1 ;i < strs.length;i++){

            if(strs[i]== null || strs[i].length()==0){
                return "";
            }

            j = 0;

            while(j < strs[i].length()){

                if( j>=commonPrefix.length()){
                    break;
                }

                if( j<commonPrefix.length() && strs[i].charAt(j) != commonPrefix.charAt(j)){

                    if(commonPrefix.length() > j){
                        commonPrefix = strs[i].substring(0,j);
                    }
                    break;

                }

                j++;

                if(j >= strs[i].length() && j<commonPrefix.length()){
                    commonPrefix = strs[i];
                }
            }


        }


        return commonPrefix ;

    }


    /**
     * Vertical Scan
     * @param strs
     */

    public String commonPrefixVertical(String[] strs){
        if(null == strs || strs.length == 0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }


        for(int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);

            for(int j=1;j<strs.length;j++){
                if(i== strs[j].length() || strs[j].charAt(i) != c){
                    return strs[j].substring(0,i);
                }
            }
        }


        return strs[0];

    }



    public static void main(String[] args){


        LongestCommonPrefixSolutiion t= new LongestCommonPrefixSolutiion();



        String[] strs = {"abab","aba",""};


        String common = t.longestCommonPrefixHorizon(strs);


        System.out.println(common);


    }








}


