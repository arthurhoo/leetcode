package com.arthur.codes.leetcode.solutiions;

/**
 * @author: huhao
 * @create: 2024/3/17
 */
public class TheSameSubstrInReverse_100248 {

    public boolean isSubstringPresent(String s) {
        if(null == s || s.length()<2){
            return false;
        }

        String reversStr = new StringBuffer(s).reverse().toString();

        for(int i=0,j=i+2; j<=s.length();i++,j=i+2){
            String subString = s.substring(i,j);
            if(reversStr.contains(subString)){
                return true;
            }
        }
        return false;

    }
}
