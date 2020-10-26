package com.arthur.java.multithread;

import java.util.concurrent.TimeUnit;

/**
 * @author: Arthur Hu
 * @date: 2020/10/26 下午8:22
 * Description:
 */
public class ThreadShutdownCase {


    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread oneCountThread = new Thread(one,"OneCountThread");
        oneCountThread.start();
        TimeUnit.SECONDS.sleep(1);
        oneCountThread.interrupt();

        Runner two = new Runner();
        Thread twoCountThread = new Thread(two,"TwoCountThread");
        twoCountThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.stop();

    }


    private static class Runner implements Runnable{

        private long i;
        private volatile boolean run=true;

        @Override
        public void run() {

            while (run && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println(Thread.currentThread().getName()+" count i = "+i);
        }

        public void stop(){
            run = false;
        }
    }
}
