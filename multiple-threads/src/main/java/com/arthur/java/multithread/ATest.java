package com.arthur.java.multithread;

/**
 * @author: Arthur Hu
 * @date: 2021/7/25 2:31 下午
 * Description:
 */
public class ATest<T> {

    public String toSringFunction(T arg){
        return arg.toString();
    }

    public static void main(String[] args) {
        ATest<String> aTest = new ATest<>();
        String result = aTest.toSringFunction("hello");
        System.out.println(result);

        ATest<Integer> bTest = new ATest<>();
        result = bTest.toSringFunction(new Integer(100));

        System.out.println(result);;
    }
}
