package com.arthur.codes.leetcode.solutiions.medium;

/**
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 *
 * 输入：nums = [9], target = 3
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 *
 *
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 * @author: huhao
 * @create: 2024/4/22
 */
public class CombinationSumSolution_377 {

    /**
     * 这里每个元数可以重复取，我们想要的是方案数
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if(null == nums || nums.length == 0 || target < 1){
            return 0;
        }

        // dp[i] 表示选取的元数之和为i的方案数,dp[0]=1，只有不选的时候为0，因此只有一种方案，
        // 参见官方题解
        int[] dp = new int[target+1];

        dp[0] = 1;
        for(int i=1;i<=target;i++){

            for(int j = 0;j< nums.length;j++){
                if(nums[j] <= i){
                    dp[i] = dp[i-nums[j]]+dp[i];
                }

            }
        }

    return dp[target];
    }
}
