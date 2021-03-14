package com.arthur.codes.spring.async;

import com.arthur.spring.async.AsyncService2;
import com.arthur.spring.async.AsyncSimpleDemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Arthur Hu
 * @date: 2020/11/8 下午5:12
 * Description:
 */

@SpringBootTest(classes = {AsyncSimpleDemo.class, AsyncSimpleDemo.AsyncService.class, AsyncService2.class})
@RunWith(SpringRunner.class)
public class AsyncSimpleDemoTest {

    @Autowired
    private AsyncSimpleDemo asyncSimpleDemo;

    @Test
    public void test() throws InterruptedException {

//        Thread.sleep(5000);
//        asyncSimpleDemo.testAsync();

        asyncSimpleDemo.testAsync2();
    }
}
