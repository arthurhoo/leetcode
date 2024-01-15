package com.arthur.codes.leetcode.solutiions;

import com.sun.xml.internal.ws.util.StringUtils;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: num = -7
 * 输出: "-10"
 *
 *
 * 提示：
 *
 * -107 <= num <= 107
 * @author: huhao
 * @create: 2024/1/1
 */
public class SeptinaryNumber {

    private static final int SEPTINARY=7;

    public static String convertToBase7(int num) {
        String result = "";
        if(num < -10000000 || num > 10000000){
            throw new IllegalArgumentException("输入超过限制");
        }
        boolean isNegative = num >= 0? false:true;
        if(num == 0){
            return "0";
        }
        // 负数求绝对值为所有位按位取反然后+1，即按位取反-（-1）。0和正数绝对值为本身
        int abs = (num ^ (num >> 31)) - (num >> 31);
        int quotient = abs;
        StringBuilder strResult  = new StringBuilder();
        while(quotient != 0){
            strResult.append(quotient % SEPTINARY);
            quotient = quotient / SEPTINARY;
        }
        if(isNegative){
            strResult.append("-");
        }
        return strResult.reverse().toString();
    }

    public static void main(String[] args) {
        String result = convertToBase7(-7);
        System.out.println(result);
        System.out.println(convertToBase7(2342343));
    }
}
