package com.arthur.codes.leetcode.solutiions.interviewexams.bytedance;

/**
 * @author: Arthur Hu
 * @date: 2019/4/7 下午1:52
 * Description:
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class AddTwoNumbersInLinksSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null || l1 == null){
            return null;
        }

        ListNode result = null, resultCur = null;

        ListNode p = l1, q=l2;

        int carry = 0;

        int temple = 0;

        while(null != p && null != q){
             temple = p.val + q.val + carry;

             carry = temple / 10;

            int remainder = temple % 10;
            if(result == null){
                result = new ListNode(remainder);
                resultCur = result;
            }else{
                resultCur.next = new ListNode(remainder);
                resultCur = resultCur.next;
            }

            p = p.next;
            q=q.next;

        }



        while (p != null){

            temple = p.val+carry;

            carry = temple / 10;

            int remainder = temple % 10;

            resultCur.next = new ListNode(remainder);

            resultCur = resultCur.next;

            p = p.next;
        }

        while (q != null){
            temple = q.val+carry;

            carry = temple / 10;

            int remainder = temple % 10;

            resultCur.next = new ListNode(remainder);

            resultCur = resultCur.next;

            q = q.next;
        }

        if(carry > 0){
            resultCur.next = new ListNode(carry);
        }

        return result;



    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}