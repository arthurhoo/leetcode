package com.arthur.codes.leetcode.solutiions.medium;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * @author: huhao
 * @create: 2024/4/18
 */
public class DecodeStringSolution_394 {

    public String decodeString(String s) {
        char[] encodedCharArray = s.toCharArray();
        StringBuilder result = new StringBuilder();
        StringBuilder sub = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < encodedCharArray.length) {
            int repeat = 1;
            // 遇到']'就开始出栈知道第二次遇见'['或者栈空，此时的字符串作为一个单位缓存
            if (encodedCharArray[i] != ']') {
                stack.push(encodedCharArray[i]);
                i++;
                continue;
            }
            StringBuilder temple = new StringBuilder();
            StringBuilder numFactor = new StringBuilder();
            while (!stack.empty() && stack.peek() != '[') {
                temple.append(stack.pop());
            }
            stack.pop();
            while (!stack.empty() && stack.peek() != '[' && isNumber(stack.peek())){
               numFactor.append(stack.pop());
            }
            if(numFactor.length() > 0){
                repeat = Integer.valueOf(numFactor.reverse().toString());
                StringBuilder templeRepeat = new StringBuilder();
                for(int k=0; k<repeat;k++){
                    templeRepeat.append(temple);
                }

                temple = templeRepeat.reverse();
            }
            for(int k=0;k<temple.length();k++){
                stack.push(temple.charAt(k));
            }

            i++;
        }

        while (!stack.empty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();

    }

    private boolean isNumber(char c) {
        if (c - '0' >= 0 && c - '9' <= 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String input = "2[abc]3[cd]ef";
        DecodeStringSolution_394 decodeStringSolution394 = new DecodeStringSolution_394();
        System.out.println(decodeStringSolution394.decodeString(input));
        input = "3[a2[c]]";
        System.out.println(decodeStringSolution394.decodeString(input));
    }

}
