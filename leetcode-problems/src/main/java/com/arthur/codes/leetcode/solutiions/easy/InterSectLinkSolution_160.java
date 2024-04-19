package com.arthur.codes.leetcode.solutiions.easy;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @author: huhao
 * @create: 2024/4/17
 */
public class InterSectLinkSolution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(null == headA || null == headB){
            return null;
        }
        ListNode tail = null, aPr = headA,bPr = headB;

        boolean isIntersect = false;

        while (aPr.next != null ){
            aPr = aPr.next;
        }
        tail = aPr;
        tail.next = headB;
        ListNode startNode = getStartNodeInCircle(headA);
        tail.next = null;
        return startNode;

    }

    private ListNode getStartNodeInCircle(ListNode head){
        if(null == head || head.next==null || head.next.next == null){
            return null;
        }
        boolean isLoop = false;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isLoop = true;
                break;
            }
        }
        if(isLoop){
            slow = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
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
