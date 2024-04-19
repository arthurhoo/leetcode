package com.arthur.codes.leetcode.solutiions.medium;

import java.util.HashMap;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * <p>
 * 不允许修改 链表。
 *
 *
 *
 * @author: huhao
 * @create: 2024/4/17
 */
public class CircleLinkedSolution_142 {

    // 开始入环的节点的特点是，两个节点的next指针指向它
    // 利用额外空间存储环节点，然后检查哪一个节点的next在环中，此节点的next就是入环节点
    // 这里要特别注意head为入环节点的场景
    public ListNode detectCycle(ListNode head) {
        if (null == head || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode meetPoint = fast;

        HashMap<ListNode, Integer> circleNodes = new HashMap<>();
        while (meetPoint.next != slow) {
            circleNodes.put(meetPoint, 1);
            meetPoint = meetPoint.next;
        }
        circleNodes.put(meetPoint, 1);

        if (circleNodes.containsKey(head)) {
            return head;
        }
        ListNode nextPoint = head.next;

        while (!circleNodes.containsKey(nextPoint)) {
            nextPoint = nextPoint.next;
        }
        return nextPoint;
    }


    /**
     * 不借助额外空间的算法
     *
     * @param head
     * @return
     */
    public ListNode detectCycle_2(ListNode head) {
        if (null == head || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        boolean isLoop = false;
        while ( fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isLoop = true;
                break;
            }

        }
        if (isLoop) {
            slow = head;
            while (slow != fast) {
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
        }
    }
}

