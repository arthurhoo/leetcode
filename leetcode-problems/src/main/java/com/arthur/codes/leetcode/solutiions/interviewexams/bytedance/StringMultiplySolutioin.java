package com.arthur.codes.leetcode.solutiions.interviewexams.bytedance;

/**
 * @author: Arthur Hu
 * @date: 2019/3/19 下午7:17
 * Description:
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 说明：
 * num1 和 num2 的长度小于110。
    num1 和 num2 只包含数字 0-9。
    num1 和 num2 均不以零开头，除非是数字 0 本身。
    不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class StringMultiplySolutioin {


    public String multiply(String num1, String num2) {

        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        int length1 = num1.length();

        int length2 = num2.length();

        int[] a = new int[length1+length2];

        return "";
    }
}
