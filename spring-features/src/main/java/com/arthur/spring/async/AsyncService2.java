package com.arthur.spring.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author: Arthur Hu
 * @date: 2020/11/8 下午5:38
 * Description:
 */
@Component
public class AsyncService2 {
    @Async
    public void asyncPrintHello() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("async2 success.");
    }
}
