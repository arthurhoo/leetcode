package com.arthur.codes.leetcode.solutiions.easy;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为
 * 回文链表
 * 。如果是，返回 true ；否则，返回 false 。
 * @author: huhao
 * @create: 2024/4/17
 */
public class ParlindromeLinkSolution_234 {
    public boolean isPalindrome(ListNode head) {
        if(null == head){
            return false;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            // 找出后半部分链表的头结点
            slow = slow.next;
        }
        fast = head;
        ListNode lastHalfHead = reversalLink(slow);
        boolean isParlindrome = false;
        while (lastHalfHead != null){
            if(lastHalfHead.val != fast.val){
                return isParlindrome;
            }
            lastHalfHead = lastHalfHead.next;
            fast = fast.next;
        }
        isParlindrome = true;
        // 可以再次反转回复数据
        return isParlindrome;

    }

    private  ListNode reversalLink(ListNode head){
        ListNode preNode = null, currentNode = head;
        while (currentNode != null){
            ListNode next = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = next;
        }
        return preNode;
    }
    private class ListNode {
        int val;
        ListNode next;


        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
