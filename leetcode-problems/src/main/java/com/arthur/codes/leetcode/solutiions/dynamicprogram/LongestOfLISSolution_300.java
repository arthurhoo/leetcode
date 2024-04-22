package com.arthur.codes.leetcode.solutiions.dynamicprogram;

/**
 * @author: huhao
 * @create: 2024/4/20
 */
public class LongestOfLISSolution_300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] lengths = new int[nums.length]; // 记录当前数字之前的子序列最长长度
        lengths[0] = 1;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                continue;
            }
            int itemNum = lengths[i-1]; //前面子序列最大长度
            int temple = 0; // 当前元数比多少个前面元数大
            for(int j=0; j<i;j++){

                if(nums[i] > nums[j]){
                    temple++;

                }
            }
            if(temple >= itemNum){
                lengths[i] = lengths[i-1]+1;
            }else{
                lengths[i] = lengths[i-1];
            }
        }

        return lengths[nums.length-1];
    }

    public static void main(String[] args) {
        int[] input = new int[]{7,7,7,7,7,7,7};
        LongestOfLISSolution_300 longestOfLISSolution300 = new LongestOfLISSolution_300();
        int result = longestOfLISSolution300.lengthOfLIS(input);
        System.out.println(result);

        input = new int[]{-2,-1};
        result = longestOfLISSolution300.lengthOfLIS(input);
        System.out.println(result);
    }
}
