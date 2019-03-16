package com.arthur.codes.leetcode.solutiions.easy;

import com.alibaba.fastjson.JSON;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Arthur Hu
 * @date: 2018/7/25 下午1:08
 * Description: https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 */


public class NAryTreeTraversalSolution {

    public List<List<Integer>> levelOrder(Node root) {

        LinkedList<List<Integer>> result = new LinkedList<>();

        if(root == null){
            return result;
        }


        LinkedList<Node> elements = new LinkedList<>();

        elements.offer(root);

        while (!elements.isEmpty()){
            LinkedList<Integer> currentLevel = new LinkedList<>();

            int length = elements.size();
            for(int i=0; i < length;i++){
                Node currentNode = elements.poll();
                currentLevel.offer(currentNode.val);

                for(Node cnode:currentNode.children){
                    elements.offer(cnode);
                }

            }

            result.offer(currentLevel);

        }


        return result;
    }


    /**
     * Post order
     * @param root
     * @return
     * Description: https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<Integer>();

        if(root == null){
            return result;
        }

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.empty()){
            Node current = stack.pop();
            result.addFirst(current.val);

            int childrenSize = current.children.size();
            if(childrenSize == 0){
                continue;
            }
            /**
             * This problem require print element from right to left so we should push element from left to right
             */
            for (int i = 0; i < childrenSize; i++){
                stack.push(current.children.get(i));
            }

        }



        return result;
    }





    public static void main(String[] args){
        NAryTreeTraversalSolution nAryTreeTraversalSolution = new NAryTreeTraversalSolution();

//        String text = "{\"$id\":\"1\",\"children\":[{\"$id\":\"2\",\"children\":[{\"$id\":\"5\",\"children\":[],\"val\":5},{\"$id\":\"6\",\"children\":[],\"val\":6}],\"val\":3},{\"$id\":\"3\",\"children\":[],\"val\":2},{\"$id\":\"4\",\"children\":[],\"val\":4}],\"val\":1}\n";
//        Node root = JSON.parseObject(text,Node.class);
//
//
//        List<List<Integer>> result = nAryTreeTraversalSolution.levelOrder(root);
//
//        System.out.println(result);

        String text2 = "{\"$id\":\"1\",\"children\":[{\"$id\":\"2\",\"children\":[{\"$id\":\"5\",\"children\":[],\"val\":5},{\"$id\":\"6\",\"children\":[],\"val\":6}],\"val\":3},{\"$id\":\"3\",\"children\":[],\"val\":2},{\"$id\":\"4\",\"children\":[],\"val\":4}],\"val\":1}";
        Node root2 = JSON.parseObject(text2,Node.class);
        List<Integer> result2 = nAryTreeTraversalSolution.postorder(root2);
        System.out.println(result2);

    }
}




class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
