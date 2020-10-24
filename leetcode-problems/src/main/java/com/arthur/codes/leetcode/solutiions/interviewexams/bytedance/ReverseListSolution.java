package com.arthur.codes.leetcode.solutiions.interviewexams.bytedance;

/**
 * @author: Arthur Hu
 * @date: 2019/4/7 下午1:31
 * Description:
 */
public class ReverseListSolution {

    public ListNode reverseList(ListNode head) {

        if(null == head){
            return null;

        }

        ListNode prev = head;
        ListNode current = prev.next;

        if(current == null){
            return head;
        }

        ListNode next = current.next;

        while (next != null){
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }

        current.next = prev;

        head.next = null;

        return current;

    }

     static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ReverseListSolution reverseListSolution = new ReverseListSolution();

        ListNode result = reverseListSolution.reverseList(l1);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
