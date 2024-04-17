package com.arthur.codes.leetcode.solutiions.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 *
 * 提示：
 *
 * 1 <= n <= 45
 * @author: huhao
 * @create: 2024/4/16
 */
public class ClimStairs70Solution {

    Map<Integer,Integer> cache = new HashMap<>();

    // 递归思想，找到子问题，子问题为每次爬1步或2步，分情况讨论
    // 子问题找对是关键

    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(cache.get(n) != null){
            return cache.get(n);
        }else {
            int temple = climbStairs(n-1)+climbStairs(n-2);
            cache.putIfAbsent(n,temple);
            return temple;
        }

    }




}
