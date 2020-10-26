package com.arthur.java.multithread;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author: Arthur Hu
 * @date: 2020/10/25 下午10:48
 * Description:
 */
public class CallableUsageTest {


    public static void main(String[] args){
        CallableTask callableTask = new CallableTask();
        Thread t = new Thread(new FutureTask<String>(callableTask));
        t.start();
    }

}
