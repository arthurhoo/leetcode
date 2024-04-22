package com.arthur.codes.leetcode.solutiions.dynamicprogram;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 * @author: huhao
 * @create: 2024/4/21
 */
public class MaxProductSolution_152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = Arrays.copyOf(nums, nums.length);
        int maxProduct = dp[0];
        int lastNegative = dp[0] < 0? 0:-1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i] = Math.max(dp[i], dp[i - 1] * nums[i]);
            } else {
                int templeProduct = nums[i];
                int maxPerRound = templeProduct;
                for (int j = i-1; j >=0; j--) {
                    templeProduct = templeProduct*nums[j] ;
                    if(templeProduct > maxPerRound){
                        maxPerRound = templeProduct;
                    }
                }
                dp[i] = Math.max(dp[i], maxPerRound);


                lastNegative = i;

            }

            maxProduct = Math.max(maxProduct, dp[i]);
        }
        return maxProduct;
    }
}
