package com.arthur.codes.leetcode.solutiions.interviewexams.bytedance;

/**
 * @author: Arthur Hu
 * @date: 2019/3/19 下午10:27
 * Description:
 */
public class ReverseWordSolution {

    public String reverseWords(String s) {
        if(s == null || s.length()==0){
            return "";
        }


        String s1 = s.trim();

        String[] tempArray = s1.split(" ");

        for(int i=0;i<tempArray.length/2;i++){
            String temp = tempArray[i];
            tempArray[i] = tempArray[tempArray.length-1-i];
            tempArray[tempArray.length-1-i] = temp;
        }


        StringBuffer sb = new StringBuffer();

        for(int j=0; j< tempArray.length;j++){
            if(!tempArray[j].isEmpty() && !tempArray[j].equals(" ")){
                sb.append(tempArray[j]).append(" ");
            }
        }


        String result = sb.toString().trim();

        return result;
    }


    public static void main(String[] args){
        ReverseWordSolution reverseWordSolution = new ReverseWordSolution();

        String s = "a good   example";

        System.out.println(reverseWordSolution.reverseWords(s));
    }
}
