package com.arthur.java.multithread;

import java.util.UUID;

/**
 * simulate the trace context within threadlocal class.
 * @author: Arthur Hu
 * @date: 2020/11/1 下午8:43
 * Description:
 */
public class ThreadLocalDemo {
    private static final ThreadLocal<String> traceIdHolder = new ThreadLocal<String>(){
        @Override
        protected String initialValue(){
            return UUID.randomUUID().toString().replaceAll("-","");
        }
    };

    public static void setTraceId(String traceId){
        traceIdHolder.set(traceId);
    }
    public static String getTraceId(){
        return traceIdHolder.get();
    }
    public static void removeTraceId()
    {
        traceIdHolder.remove();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            ThreadLocalDemo.setTraceId("123");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"_"+ ThreadLocalDemo.getTraceId());
        });

        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"_"+ ThreadLocalDemo.getTraceId());
        });

        thread1.start();
        thread2.start();
    }


}
