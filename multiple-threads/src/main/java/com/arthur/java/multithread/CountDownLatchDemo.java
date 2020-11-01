package com.arthur.java.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Arthur Hu
 * @date: 2020/11/1 上午10:04
 * Description:
 */
public class CountDownLatchDemo {

    private CountDownLatch countDownLatch;

    private int start = 10;
    private int mid = 100;
    private int end = 200;

    private volatile int tempResult1, tempResult2;

    private int add(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }


    private int sum(int a, int b) {
        return a + b;
    }

    public void calculate(){
        countDownLatch = new CountDownLatch(2);

        Thread thread1 = new Thread(()->{
            try{
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : 开始执行");
                tempResult1 = add(start, mid);
                System.out.println(Thread.currentThread().getName() +
                        " : calculate ans: " + tempResult1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }

        });


        Thread thread2 = new Thread(()->{
           try{
               // 确保线程3先与1，2执行，由于countDownLatch计数不为0而阻塞
               Thread.sleep(100);
               System.out.println(Thread.currentThread().getName() + " : 开始执行");
               tempResult2 = add(mid + 1, end);
               System.out.println(Thread.currentThread().getName() +
                       " : calculate ans: " + tempResult2);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }finally {
               countDownLatch.countDown();
           }
        });


        Thread thread3 = new Thread(()->{
           try{
               System.out.println(Thread.currentThread().getName() + " : 开始执行");
               countDownLatch.await();
               int ans = sum(tempResult1, tempResult2);
               System.out.println(Thread.currentThread().getName() +
                       " : calculate ans: " + ans);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });

        thread3.start();
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        countDownLatchDemo.calculate();
        Thread.sleep(1000);
    }





}
