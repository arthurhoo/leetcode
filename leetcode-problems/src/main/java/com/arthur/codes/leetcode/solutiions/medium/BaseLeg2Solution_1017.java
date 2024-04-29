package com.arthur.codes.leetcode.solutiions.medium;

/**
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 *
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出："110"
 * 解释：(-2)2 + (-2)1 = 2
 * 示例 2：
 *
 * 输入：n = 3
 * 输出："111"
 * 解释：(-2)2 + (-2)1 + (-2)0 = 3
 * 示例 3：
 *
 * 输入：n = 4
 * 输出："100"
 * 解释：(-2)2 = 4
 *
 *
 * 提示：
 *
 * 0 <= n <= 109
 * @author: huhao
 * @create: 2024/4/28
 */
public class BaseLeg2Solution_1017 {
    // 整数以32位表示
    public String baseNeg2(int n) {
        if(0>n || n>Integer.MAX_VALUE){
            return "";
        }
        if(n==0){
            return "0";
        }

        StringBuilder result = new StringBuilder();
        int templeResult = 0;
        for(int i=0;i<32;i++){
            int temp = n & 0x0001;
            n = n>>1;
            if(0 == temp){
                continue;
            }
            for(int j=0;j<i;j++){
                temp *= (-2);
            }
            templeResult += temp;
        }

        templeResult


        return result.toString();

    }
}
