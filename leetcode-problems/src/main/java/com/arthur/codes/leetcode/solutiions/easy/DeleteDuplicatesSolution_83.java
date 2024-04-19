package com.arthur.codes.leetcode.solutiions.easy;

import java.util.HashMap;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 * @author: huhao
 * @create: 2024/4/17
 */
public class DeleteDuplicatesSolution_83 {

    // 此方法增加了空间复杂度，注意题目中链表已经排序，说明如果有重复，一定是挨着的。
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null ) {
            return head;
        }
        ListNode prePoint=head, curPoint = prePoint.next;
        HashMap<Integer,Integer> nodeValueMap = new HashMap<>();
        nodeValueMap.put(head.val,1);

        while (curPoint != null){
            int value = curPoint.val;;
            nodeValueMap.merge(value,1,Integer::sum);
            if(nodeValueMap.get(value) > 1){
                // 删除当前节点
                prePoint.next = curPoint.next;
                curPoint = curPoint.next;
            }else{
                // 未重复，移动两个指针
                prePoint = prePoint.next;
                curPoint = curPoint.next;
            }
        }

        return head;

    }


    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        if(cur.val == cur.next.val){
            return deleteDuplicates(cur.next.next);
        }else{
            return deleteDuplicates(cur.next);
        }
    }

    /**
     * 递归操作是反向顺序的入站操作，可以从末位开始思考，即从栈顶开始考虑
     * @param head
     * @return
     */
    public ListNode deleteDuplicates_recursive(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates_recursive(head.next);
        return head.val == head.next.val? head.next:head;
    }
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
