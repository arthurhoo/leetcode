package com.arthur.spring.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author: Arthur Hu
 * @date: 2020/11/8 下午4:27
 * Description:
 */
public class AsyncSimpleDemo {


    private AsyncService asyncService;
    private AsyncService2 asyncService2;

    public AsyncSimpleDemo(AsyncService asyncService,AsyncService2 asyncService2){
        this.asyncService = asyncService;
        this.asyncService2 = asyncService2;
    }

    public void testAsync() throws InterruptedException {
        System.out.println("start async");
        asyncService.asyncPrintHello();
        Thread.sleep(2000);
        System.out.println("end async");

    }
    public void testAsync2() throws InterruptedException {
        System.out.println("start async2");
        asyncService2.asyncPrintHello();
//        Thread.sleep(1000);
        System.out.println("end async2");

    }



    public static class AsyncService{

        @Async
        public void asyncPrintHello() throws InterruptedException {
            Thread.sleep(1000);
            System.out.println("async success.");
        }

    }
}
