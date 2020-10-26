package com.arthur.java.multithread;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author: Arthur Hu
 * @date: 2020/10/25 下午10:57
 * Description:
 */
public class CallableTask implements Callable<String> {
    private String t="run";

    @Override
    public String call() throws Exception {
        String result = t+"_"+new Date();
        System.out.println(result);
        return result;
    }
}
