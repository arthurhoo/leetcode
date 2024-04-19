package com.arthur.codes.leetcode.solutiions.easy;

import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: huhao
 * @create: 2024/4/18
 */
public class QueueInStackSolution_232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(2);
        myQueue.push(3);
        System.out.printf("%d,",myQueue.pop());
        System.out.printf("%d,",myQueue.pop());

    }

}

class MyQueue {

   private Lock lock;
    private Stack<Integer> inStack;
   private Stack<Integer> outStack;
   private int size = 0;


    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
        this.size = outStack.size();
        this.lock = new ReentrantLock();
    }

    public void push(int x) {
        inStack.push(x);
        size++;
    }

    public int pop() {
        int element;
        lock.lock();
        try{
            if(outStack.empty()){
                transferElements();
            }
            element = outStack.pop();
            size--;
        }finally {
            lock.unlock();
        }
        return element;
    }
    private void transferElements(){
        lock.lock();
        try{
            while (!inStack.empty()){
                Integer element = inStack.pop();
                outStack.push(element);
            }
        }finally {
            lock.unlock();
        }
    }

    public int peek() {
        if(outStack.empty()){
            transferElements();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return size==0? true:false;
    }
}
