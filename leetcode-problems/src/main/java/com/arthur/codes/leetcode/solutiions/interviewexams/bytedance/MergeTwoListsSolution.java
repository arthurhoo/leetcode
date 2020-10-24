package com.arthur.codes.leetcode.solutiions.interviewexams.bytedance;

/**
 * @author: Arthur Hu
 * @date: 2019/4/7 下午12:24
 * Description:
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class MergeTwoListsSolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newList = null;


        ListNode p = l1;
        ListNode q = l2;

        if(l1 == null && l2 != null){
            newList = l2;
            return newList;
        }

        if(l2==null && l1 != null){
            newList = l1;

            return newList;
        }

        if(l1 == null && l2==null){
            return newList;
        }

        if(p.val <= q.val){
            newList = p;
            p = p.next;
        }else{
            newList = q;

            q=q.next;
        }


        ListNode newListCur = newList;


        while(p != null && q != null){

            if(p.val < q.val){
                newListCur.next = p;
                p = p.next;
            }else{
                newListCur.next = q;
                q = q.next;
            }

            newListCur = newListCur.next;
        }

        if(p == null){
            newListCur.next = q;
        }else if(q == null){
            newListCur.next = p;
        }


        return newList;
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

        ListNode l2 = new ListNode(1);

        l2.next = new ListNode(3);

        l2.next.next = new ListNode(4);

        MergeTwoListsSolution mergeTwoListsSolution = new MergeTwoListsSolution();

        ListNode result = mergeTwoListsSolution.mergeTwoLists(l1,l2);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
  }



}
