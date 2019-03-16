package com.arthur.codes.leetcode.solutiions.bytedance;

/**
 *
 * @author: Arthur Hu
 * @date: 2019/1/26 上午11:55
 * Description:
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class MinStack {


    private Node top=null;

    private Node minNode = null;

    MinStack(){}

    public void push(int x) {

        Node newNode = new Node(x);
        newNode.setNext(top);
        top = newNode;

        if(minNode == null){
            minNode = newNode;
        }else{
            Node cursor = minNode;

            if(cursor.getValue() > x){
                newNode.setBigger(cursor);
                minNode = newNode;
                return;
            }

            while(cursor.getBigger() != null){
                if(cursor.getBigger().getValue() >= x){
                    newNode.setBigger(cursor.getBigger());
                    cursor.setBigger(newNode);

                    return;

                }

                cursor = cursor.getBigger();
            }

            cursor.setBigger(newNode);
        }

    }

    public void pop() {

        Node valueCursor = minNode;

        Node topCursor = top;

        top = top.getNext();


        if(valueCursor==topCursor){
            minNode = topCursor.getBigger();
            return;
        }


        while (valueCursor != null){
            if(valueCursor.getBigger() == topCursor){
                valueCursor.setBigger(topCursor.getBigger());
                break;
            }

            valueCursor = valueCursor.getBigger();
        }

    }

    public int top() {

        return top.getValue();
    }

    public int getMin() {

        return minNode.getValue();
    }






    private class Node{
        int value;
        Node next;
        Node bigger;

        Node(int value){
            this.value = value;
            this.next = null;
            this.bigger = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getBigger() {
            return bigger;
        }

        public void setBigger(Node bigger) {
            this.bigger = bigger;
        }
    }


    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);

        minStack.push(-3);


        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());



    }

}
