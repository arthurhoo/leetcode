package com.arthur.codes.leetcode.solutiions.designpattern;

/**
 * @author: Arthur Hu
 * @date: 2019/3/18 下午5:58
 * Description:
 */
public class Singleton {

    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton(){}

    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }


    public static void main(String[] args){
        Singleton a = Singleton.getInstance();

        Singleton b = Singleton.getInstance();

        if(a == b){
            System.out.println("It is a singleton instance.");
        }
    }
}
