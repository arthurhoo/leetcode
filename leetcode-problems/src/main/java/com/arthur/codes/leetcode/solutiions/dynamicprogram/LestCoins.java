package com.arthur.codes.leetcode.solutiions.dynamicprogram;

/**
 *
 * 如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
 *
 * @author: Arthur Hu
 * @date: 2019/3/13 下午5:45
 * Description:
 */
public class LestCoins {

    int[] coins = {1,3,5};

    public int numberOfLeastCoins(int money){
        int numberOfCoins = 0;

        if(money == 0){
            return numberOfCoins;
        }


        for(int i=0; i<3;i++){
            if(money-coins[i] > 0){
                int a = numberOfLeastCoins(money-coins[i])+1;
                if(a < numberOfCoins && a > 0){
                    numberOfCoins = a;
                }
            }
        }

        return numberOfCoins;

    }




    private int min(int a, int b,int c){

        int minor = a;


        if(a > b && b>0){
            minor = b;
        }

        if(minor > c && c >0){
            minor = c;
        }

        return minor;

    }


    public static void main(String[] args){
        LestCoins lestCoins = new LestCoins();

        int result = lestCoins.numberOfLeastCoins(11);

        System.out.println(result);

         result = lestCoins.numberOfLeastCoins(4);

        System.out.println(result);
    }

}
