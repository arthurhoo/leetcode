package com.arthur.codes.leetcode.solutiions;

/**
 * @author: huhao
 * @create: 2024/1/5
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 624.数据列表中的最大距离
 * 给定 m 个数组，每个数组都已经按照升序排好序了。
 * 现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。
 * 两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。你的任务就是去找到最大距离
 * 示例 1：
 *
 * 输入：
 * [[1,2,3],
 *  [4,5],
 *  [1,2,3]]
 * 输出： 4
 * 解释：
 * 一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
 * 注意：
 *
 * 每个给定数组至少会有 1 个数字。列表中至少有两个非空数组。
 * 所有 m 个数组中的数字总数目在范围 [2, 10000] 内。
 * m 个数组中所有整数的范围在 [-10000, 10000] 内。
 */
public class LargestDistanceInArray {

    public int largestDistance1(List<List<Integer>> arrays){
        if(null == arrays || arrays.isEmpty() || arrays.size() < 2){
            throw new IllegalArgumentException("参数错误");
        }
        int result = 0;
        List<Integer> minArray = new ArrayList<>();
        List<Integer> maxArray = new ArrayList<>();
        for(int i=0;i<arrays.size();i++){
            for(int j=0;j < arrays.get(i).size();j++){
                int item = arrays.get(i).get(j);
                for(int k=i+1;k<arrays.size();k++){
                    for(int m=0;m<arrays.get(k).size();m++){
                        int distance = item - arrays.get(k).get(m);
                        distance = ((distance ^ (distance >> 31)) - (distance >> 31));
                        result = distance>result? distance:result;
                    }
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        LargestDistanceInArray largestDistanceInArray = new LargestDistanceInArray();
        int[][]  input = new int[][]{{1,2,3},{4,5},{1,2,3}};
        List<List<Integer>> arrays = Arrays.stream(input).map(l -> {
            return Arrays.stream(l).boxed()
                    .collect(Collectors.toList());
        }).collect(Collectors.toList());
        System.out.println(largestDistanceInArray.largestDistance1(arrays));
        input = new int[][]{{1,4},{0,5}};
        arrays = Arrays.stream(input).map(l -> {
            return Arrays.stream(l).boxed()
                    .collect(Collectors.toList());
        }).collect(Collectors.toList());
        System.out.println(largestDistanceInArray.largestDistance1(arrays));

    }
}
