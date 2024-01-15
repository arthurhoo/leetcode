package com.arthur.codes.leetcode.solutiions;

import java.util.HashMap;
import java.util.Map;

/**
 * 405. 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * 注意:
 *
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 * 输入:
 * 26
 * 输出:
 * "1a"
 * 示例 2：
 * 输入:
 * -1
 * 输出:
 * "ffffffff"
 *
 *
 * @author: huhao
 * @create: 2024/1/2
 */

/**
 * 对非十进制的转换一般考虑用二进制作为中间转换
 * 位运算 + 分组换算
 * 将长度为 32 的二进制转换为 16进制数，本质是对长度为 32的二进制数进行分组，每 4个一组二进制 (1111)2表示 15，则使用长度为 4 的二进制可以表示 0-15。
 *
 * 同时，由于我们是直接对长度为 32的二进制进行分组转算（4个为一组，共 8组），而长度为 32 的二进制本身就是使用补码规则来表示的，因此我们无须额外处理「补码」问题。
 *
 * 具体的，我们将 num与 15 = (1111)2 进行 & 运算，然后对 num 进行无符号右移 4 位来实现每 4位处理（逻辑右移高位补0）。
 *
 * 作者：宫水三叶
 */
public class ConvertToHexadecimal {
    private static final int N_SYSTEM=16;
    private static final Map<Integer,Character> dictionary = new HashMap<>();

    static {
        dictionary.put(10,'a');
        dictionary.put(11,'b');
        dictionary.put(12,'c');
        dictionary.put(13,'d');
        dictionary.put(14,'e');
        dictionary.put(15,'f');
    }



    public static String toHex(int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while(num != 0){
            // 15为0xf, 与运算之后保留低4位
            int hexGroupValue = num & 15;
            // 转换对应字符的ASCII码
            char c = (char)(hexGroupValue+'0');
            if(hexGroupValue > 9){
                c = dictionary.get(hexGroupValue);
            }
            result.append(c);
            // 逻辑右移，最高位补0
            num >>>=4;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));


    }
}
