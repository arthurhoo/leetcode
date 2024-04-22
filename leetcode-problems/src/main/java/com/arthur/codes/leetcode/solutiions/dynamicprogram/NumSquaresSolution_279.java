package com.arthur.codes.leetcode.solutiions.dynamicprogram;

import java.util.Arrays;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * 提示：
 *
 * 1 <= n <= 104
 * @author: huhao
 * @create: 2024/4/19
 */
public class NumSquaresSolution_279 {

    /**
     * 以下解释是chatGPT的解释，我觉得有道理
     * 这个问题可以使用动态规划来解决。我们可以使用一个数组 dp[] 来存储从 1 到 n 的每个数的最少完全平方数数量。对于每个数 i
     * ，我们遍历所有小于等于 i 的完全平方数 jj，并计算 dp[i-jj] + 1 的值，然后选择最小的作为 dp[i] 的值。
     * 问：这种解法的时间复杂度是多少
     * 答：O(sqrt(n))
     * 问：我想问的是，为什么状态转移方程中，dp[i-jj] + 1 会作为一个参考量
     * 答：在状态转移方程中，dp[i-jj] + 1 的含义是：<u></u>当前数 i 减去一个完全平方数 jj 后的剩余值所需的最少完全平方数数量，再加上 1（表示当前使用的完全平方数 jj）。
     *     这样设计的原因是，我们要求的是和为 i 的最少完全平方数数量，那么如果当前数 i 可以被一个完全平方数 jj 所减去，那么 dp[i-jj] + 1 就是一个候选解。我们需要遍历所有小于等于 i 的完全平方数 jj，并选择其中最小的 dp[i-jj] + 1
     *     作为当前状态 dp[i] 的值，这样可以保证最终得到的 dp[i] 是符合题目要求的最优解</u>。
     * 问：也就是dp数组理存储的都是当前这个数的最少平方数个数是吗
     * 答：是的，dp数组中存储的是每个数的最少完全平方数数量。
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {

        int[] squares = new int[n+1];
        Arrays.fill(squares,Integer.MAX_VALUE);
        squares[0] = 0;
        for(int i=1; i< squares.length;i++){
//            squares[i] = i; //最坏的情况，每个数都由 1 的平方组成
            for(int j=1;j*j <= i;j++){
               squares[i] = Math.min(squares[i], squares[i-j*j]+1); //squares[i-j*j]+,是因为当前平方数需要算进来
            }
        }
        return squares[n];
    }

    public static void main(String[] args) {
        NumSquaresSolution_279 numSquaresSolution279 = new NumSquaresSolution_279();
        int result = numSquaresSolution279.numSquares(12);
        System.out.println(result);
    }
}
