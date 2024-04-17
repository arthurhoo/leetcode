package com.arthur.codes.leetcode.solutiions.easy;

import java.util.*;

/**
 * @author: huhao
 * @create: 2024/4/16
 */
public class DisapearNumbersSolution_448 {

    // 空间换时间
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length <1 || nums.length > (int)Math.pow(10,5)){
            return result;
        }
        int n = nums.length;

        boolean badNum = Arrays.stream(nums).anyMatch(i -> !(i>=1 && i<=n));
        if(badNum){
            return result;
        }

        HashMap<Integer, Integer> diction = new HashMap<>();
        for(int i=1;i<=n;i++){
            diction.put(i,0);
        }
        Arrays.stream(nums).forEach(item -> {
            diction.merge(item,1,(a,b) -> Integer.sum(a,b));
        });

        for(Map.Entry<Integer,Integer> entry: diction.entrySet()){
            if(entry.getValue() ==0){
                result.add(entry.getKey());
            }
        }

        return result;


    }


    /**
     * 官方题解思路实现
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums){
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length <1 || nums.length > (int)Math.pow(10,5)){
            return result;
        }
        int n = nums.length;

        boolean badNum = Arrays.stream(nums).anyMatch(i -> !(i>=1 && i<=n));
        if(badNum){
            return result;
        }
        // 因为元素个数为n以及每个值范围在[1,n], 将hash表缩减为n数组，利用下标表达值，进一步利用原数组
        // 用不在范围[1,n]的数表示下标所代表的值是否存在，这个过程中数组真是的值不重要了，原来的数组被下标所表达
        int interval = n;
        for(int i=0;i<n;i++){
            int index = (nums[i]-1)%n;
            nums[index] += interval;
        }
        for (int i = 0 ; i<n;i++){
            if(nums[i] < n){
                result.add(i+1);
            }
        }
        return result;
    }
}
