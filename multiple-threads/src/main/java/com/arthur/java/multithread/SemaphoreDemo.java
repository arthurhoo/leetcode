package com.arthur.java.multithread;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: Arthur Hu
 * @date: 2020/11/1 上午11:52
 * Description:
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(2);


    static class Student implements Runnable{

        private String name;
        private Semaphore semaphore;
        private int type;

        Student(String name, Semaphore semaphore, int type){
            this.name = name;
            this.semaphore = semaphore;
            this.type = type;
        }



        @Override
        public void run() {

            switch (type){
                case 0:
                    //打饭时间
                    //这个学生很有耐心，它会一直排队直到打到饭
                    this.semaphore.acquireUninterruptibly();
                    //进行打饭
                    try {
                        Thread.sleep(RandomUtils.nextLong(1000, 3000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //将打饭机会让后后面的同学
                    semaphore.release();
                    System.out.println(name+"终于打到饭了");
                    break;
                case 1:
                    try{
                        if(semaphore.tryAcquire(RandomUtils.nextInt(6000,16000), TimeUnit.MILLISECONDS)){

                            try{
                                Thread.sleep(RandomUtils.nextLong(1000,3000));
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            semaphore.release();
                            System.out.println(name+"终于打到饭了");
                        }else{
                            System.out.println(name+"回宿舍吃泡面");
                        }
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                    }
                    break;
                case 2:
                    //排队
                    try {
                        semaphore.acquire();
                        //进行打饭
                        try {
                            Thread.sleep(RandomUtils.nextLong(1000, 3000));
                        } catch (InterruptedException e) {
                            //e.printStackTrace();
                        }
                        //将打饭机会让后后面的同学
                        semaphore.release();
                        //打到了饭
                        System.out.println(name + " 终于打到了饭.");
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                        //被叫去聚餐，不再打饭
                        System.out.println(name + " 全部聚餐，不再打饭.");
                    }
                    break;
                default:
                    break;
            }


        }
    }


    public static void main(String[] args) throws InterruptedException {

        //101班的学生
        Thread[] students101 = new Thread[5];
        for (int i = 0; i < 20; i++) {
            //前10个同学都在耐心的等待打饭
            if (i < 10) {
                new Thread(new Student("打饭学生" + i, SemaphoreDemo.semaphore, 0)).start();
            } else if (i >= 10 && i < 15) {//这5个学生没有耐心打饭，只会等1000毫秒
                new Thread(new Student("泡面学生" + i, SemaphoreDemo.semaphore, 1)).start();
            } else {//这5个学生没有耐心打饭
                students101[i - 15] = new Thread(new Student("聚餐学生" + i, SemaphoreDemo.semaphore, 2));
                students101[i - 15].start();
            }
        }
        //
        Thread.sleep(5000);
        for (int i = 0; i < 5; i++) {
            students101[i].interrupt();
        }
    }
}
