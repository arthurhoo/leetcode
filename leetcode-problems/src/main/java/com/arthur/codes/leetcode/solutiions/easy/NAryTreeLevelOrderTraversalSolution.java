package com.arthur.codes.leetcode.solutiions.easy;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Arthur Hu
 * @date: 2018/7/25 下午1:08
 * Description: https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 */


public class NAryTreeLevelOrderTraversalSolution {

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


    public static void main(String[] args){
        NAryTreeLevelOrderTraversalSolution nAryTreeLevelOrderTraversalSolution = new NAryTreeLevelOrderTraversalSolution();

        String text = "{\"$id\":\"1\",\"children\":[{\"$id\":\"2\",\"children\":[{\"$id\":\"5\",\"children\":[],\"val\":5},{\"$id\":\"6\",\"children\":[],\"val\":6}],\"val\":3},{\"$id\":\"3\",\"children\":[],\"val\":2},{\"$id\":\"4\",\"children\":[],\"val\":4}],\"val\":1}\n";
        Node root = JSON.parseObject(text,Node.class);


        List<List<Integer>> result = nAryTreeLevelOrderTraversalSolution.levelOrder(root);

        System.out.println(result);

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
