package com.arthur.codes.leetcode.solutiions;

/**
 * @author: huhao
 * @create: 2024/1/4
 */

/**
 * 两整数之和
 * 给你两个整数 a 和 b ，不使用 运算符+ 和-，计算并返回两整数之和。
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 *
 * 输入：a = 2, b = 3
 * 输出：5
 *
 * 提示：
 *
 * -1000 <= a, b <= 1000

 */
public class SumOfTwoInteger {
    /**
     * 加法结果可以分为两部分，进位和非进位部分
     * 进位部分：只有当两个数都是1时，才会发生进位，进位部分的值是10，因此进位部分可以看成是两个数的按位与的结果左移一位 (a&b) << 1
     * 非进位部分：异或运算就是不进位的加法 a^b
     *
     * 利用递归思想
     * @param a
     * @param b
     * @return
     */
    public static int sum(int a, int b){
        if(a<-1000 || a>1000 || b<-1000 || b>1000){
            throw new IllegalArgumentException("参数错误");
        }
        while(b != 0){
            int carray = (a&b)<<1;
            a = a ^ b;
            b = carray;
        }


        return a;
    }

    public static void main(String[] args) {
        System.out.println(sum(1,2));
        System.out.println(sum(-1,2));

    }
}
