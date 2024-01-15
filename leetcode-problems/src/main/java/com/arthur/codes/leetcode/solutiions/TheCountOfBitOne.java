package com.arthur.codes.leetcode.solutiions;

/**
 * @author: huhao
 * @create: 2024/1/2
 */

/**
 * 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 3 中，输入表示有符号整数 -3。
 *
 * 示例 1：
 *
 * 输入：n = 00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：n = 00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：n = 11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 *
 * 提示：
 *
 * 输入必须是长度为 32 的 二进制串 。
 */

/**
 * 该题目其实就是求字符串的汉明重量
 */
public class TheCountOfBitOne {

    //求汉明重量方法1，遍历，O(n)，一般不用
    public static int hanmingWeight1(int n){
        int result = 0;
        //利用位移进行遍历
        for(int i=0;i<32;i++){
            result += (n >>> i) & 1;
        }


        return result;
    }

    /**
     * SWAR算法
     * 分组分治思想，https://zhuanlan.zhihu.com/p/165968167
     * @param n
     * @return
     */
    public static int hanmingWeightSWAR(int n){

        //0x5 = 0101, 与运算获取位1的位；先获取奇数组的1的数量，在获取偶数组的1数量，然后相加得到1bit宽度的两组合并结果
        n = (n & 0x55555555) + ((n>>>1)&0x55555555);
        // 0x3= 0011, 2bit为宽度分组，重复上述思想
        n = (n&0x33333333) + ((n>>>2)&0x33333333);
        // Step3 对8组4bit宽度分组统计,0xf=1111
        n = (n&0x0f0f0f0f) + ((n>>>4)&0x0f0f0f0f);
        // step4 对4组8bit数进行统计
        n = (n&0x00ff00ff) + ((n>>>8)&0x00ff00ff);
        // step5 对2组16bit分组进行统计合并
        n = (n&0x0000ffff) + ((n>>>16)&0x0000ffff);

        return n;

    }

    public static void main(String[] args) {
        System.out.println(hanmingWeight1(3));
        System.out.println(hanmingWeightSWAR(3));
        System.out.println(hanmingWeightSWAR(-3));


    }

}
