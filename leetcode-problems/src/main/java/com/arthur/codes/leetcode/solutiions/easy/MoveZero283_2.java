package com.arthur.codes.leetcode.solutiions.easy;

/**
 * @author: huhao
 * @create: 2024/4/16
 */
public class MoveZero283_2 {

    // 利用双指针，一个指向最近的0的位置，一个用于遍历数组进行赋值
    public void moveZeroes(int[] nums) {
        if(null == nums || nums.length<1 || nums.length > (int)Math.pow(10,4)){
            return;
        }
        int j=0;

        for(int i = 0; i< nums.length; i++){
            if(nums[i] !=0){
                nums[j] = nums[i];
                j++;
            }
        }

        // 此时j指向第一个0的位置，j及之后所有元数赋值为0
        while (j<nums.length){
            nums[j] = 0;
        }

    }
}
