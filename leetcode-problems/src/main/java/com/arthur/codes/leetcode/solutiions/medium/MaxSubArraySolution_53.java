package com.arthur.codes.leetcode.solutiions.medium;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * @author: huhao
 * @create: 2024/4/19
 */
public class MaxSubArraySolution_53 {

    public int maxSubArray(int[] nums) {
        // 采用动态规划，
        // 状态转移应该为：dp[i]为包含I的前面连续子序列的最大和，这里dp[i] == max{dp[]i-1+data[i], data[i]}
        if(null == nums || nums.length==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for(int i = 1;i< nums.length;i++){
            dp[i] = nums[i];
            if(nums[i]+dp[i-1] > nums[i]){
                dp[i] = nums[i]+dp[i-1];
            }
        }
        return Arrays.stream(dp).max().getAsInt();

    }

    public static void main(String[] args) {
        int[] input= {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArraySolution_53 maxSubArraySolution53 = new MaxSubArraySolution_53();
        int result = maxSubArraySolution53.maxSubArray(input);
        System.out.println(result);
    }
}
