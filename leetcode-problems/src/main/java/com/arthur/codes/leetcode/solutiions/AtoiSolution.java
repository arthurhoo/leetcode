//package com.arthur.codes.leetcode.solutiions;
//
///**
// * @author: Arthur Hu
// * @date: 2018/1/22 下午9:29
// * Description:
// */
//public class AtoiSolution {
//
//    public int myAtoi(String str) {
//        int integer = 0;
//
//        if(!verifyStr(str)){
//
//            throw new NumberFormatException();
//
//        }
//
//        int isPositive = 1;
//
//        char firstChar = str.charAt(0);
//
//        if(firstChar == 45){
//            isPositive = -1;
//        }
//
//
//        if(firstChar < '0' && firstChar>'9'){
//            str = str.substring(1);
//        }
//
//        int strLength = str.length();
//
//
//        if(strLength > 10){
//            throw new NumberFormatException();
//        }
//
//
//
//
//
//
//
////        Integer.MIN_VALUE;
//
//
//        return integer;
//    }
//
//
//    private boolean verifyStr(String str){
//        if(str == null || str.length()==0){
//            return false;
//        }
//
//        boolean result = false;
//
//        char firstChar = str.charAt(0);
//
//        if(firstChar < 49 && firstChar>57 && firstChar != 43 && firstChar!= 45){
//            return result;
//        }
//
//        for(int i =1; i < str.length();i++){
//            if(firstChar < 48 && firstChar>57){
//                return result;
//            }
//        }
//
//        result = true;
//
//        return result;
//    }
//
//}
