package com.arthur.codes.leetcode.solutiions.dynamicplan;

/**
 * @author: Arthur Hu
 * @date: 2019/3/20 下午6:06
 * Description:
 *
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

    如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

    注意你不能在买入股票前卖出股票。

    https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1042/
 */


public class MaxProfitSolution_121 {


    /**
     *
     * 遍历数组，记录盈利和相应日期
     *
     * @param prices
     * @return
     */
    /**
     * 以下方法超出时间限制---暴力破解
     * @param prices
     * @return
     */
    public int maxProfit_invalid(int[] prices) {


        int maxProfit = 0;

        for(int i = 0; i<prices.length-1;i++){

            for(int j=i+1; j<prices.length; j++){
               int profit = prices[j] - prices[i];

               if(profit >0 && profit > maxProfit){

                   maxProfit = profit;
               }
            }
        }

        return maxProfit;

    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;



        return maxProfit;

    }


    public static void main(String[] args){
        MaxProfitSolution_121 maxProfitSolution121 = new MaxProfitSolution_121();

        int[] a = new int[]{7,1,5,3,6,4};

        System.out.println(maxProfitSolution121.maxProfit_invalid(a));

    }

}
