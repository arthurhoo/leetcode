package com.arthur.codes.leetcode.solutiions;

/**
 * 215. 数组中的第 K 个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * @author: huhao
 * @create: 2023/12/11
 */
public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k){
        if(null == nums || nums.length > 100000 || k< 1 || k >nums.length){
            return -1;
        }

        int[] sortedK = new int[k];
        for (int i =0; i< sortedK.length;i++){
            sortedK[i] = -10000;
        }
        int j = 0;
        for (int i = 0; i< nums.length;i++){
            j = (j+1) % k;
            if(nums[i] > sortedK[j]){
                sortedK[j] = nums[i];
            }
        }

        int minNum = sortedK[0];
        for(int i = 0; i<k;i++){
            if(sortedK[i] < minNum){
                minNum = sortedK[i];
            }
        }

        return minNum;

    }

    public static void main(String[] args) {
        int[] input1 = new int[]{5,2,4,1,3,6,0};
        int result1 = findKthLargest(input1,4);
        System.out.println(result1);
        int[] input2 = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(input2,4));
    }
}
