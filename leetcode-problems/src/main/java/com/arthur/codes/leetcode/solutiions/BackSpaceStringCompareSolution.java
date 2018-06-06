package com.arthur.codes.leetcode.solutiions;

/**
 * @author: Arthur Hu
 * @date: 2018/6/6 上午10:41
 * Description:
 */

import org.junit.Assert;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 *Example 1:

 Input: S = "ab#c", T = "ad#c"
 Output: true
 Explanation: Both S and T become "ac".
 Example 2:

 Input: S = "ab##", T = "c#d#"
 Output: true
 Explanation: Both S and T become "".
 Example 3:

 Input: S = "a##c", T = "#a#c"
 Output: true
 Explanation: Both S and T become "c".
 Example 4:

 Input: S = "a#c", T = "b"
 Output: false
 Explanation: S becomes "c" while T becomes "b".


 Note:

 1 <= S.length <= 200
 1 <= T.length <= 200
 S and T only contain lowercase letters and '#' characters.
 */
public class BackSpaceStringCompareSolution {




    public static void main(String[] args){
        String s = "ab#c";
        String t = "ad#c";

        BackSpaceStringCompareSolution backSpaceStringCompareSolution = new BackSpaceStringCompareSolution();

       Assert.assertTrue(backSpaceStringCompareSolution.compareStr(s, t));

       s="ab##";
       t="c#d#";

       Assert.assertTrue(backSpaceStringCompareSolution.compareStr(s,t));

       s = "xywrrmp";
       t = "xywrrmu#p";

        System.out.println(backSpaceStringCompareSolution.compareStr(s,t));


    }


    public boolean compareStr(String s, String t){

        if(null == s || null == t){
            return false;
        }

        if(s.length() < 1 || s.length()>200 || t.length()<1 || t.length()>200){
            return false;
        }

        String sNew = buildString(s);
        String tNew = buildString(t);


        return sNew.equals(tNew)? true:false;
    }


    private String buildString(String s){
        if(!s.contains("#")){
            return s;
        }


        String newString = s;

        char[] chars = newString.toCharArray();

        int lastBackspace = -1;


        for(int i=0; i< chars.length; i++){
            if(chars[i] == '#'){

                chars[i] = '*';

                lastBackspace = i;

                if(i>0){
                    if(chars[i-1] != '*'){
                        chars[i-1] = '*';
                    }else{
                        for(int j=lastBackspace;j>=0;j--){
                            if(chars[j]!='*'){
                                chars[j] = '*';
                                break;
                            }
                        }
                    }

                }
            }
        }

        char[] newChars = new char[chars.length];


        int j = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i] != '*'){
                newChars[j] = chars[i];
                j++;
            }
        }



        return new String(newChars,0,j);
    }
}
