package com.arthur.codes.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @create: 2024/4/7
 */
public class BinaryTree2<T>  {

    private TreeNode<T> root;

    public static class TreeNode<T>{
        private T val;
        private TreeNode<T> leftChild;
        private TreeNode<T> rightChild;

        public TreeNode(T val){
            this.val = val;
            leftChild = null;
            rightChild = null;
        }

        public TreeNode(T val, TreeNode<T> left, TreeNode<T> right){
            this(val);
            this.leftChild = left;
            this.rightChild = right;
        }

        public T getVal(){
            return this.val;
        }
    }

    public BinaryTree2(T data){
        this.root = new TreeNode<>(data);
    }



    public List<T> preOrderTraversal(TreeNode<T> root){
        List<T> valueList = new ArrayList<>();

        preOrderTraversalHandler(root,valueList);
        return valueList;
    }

    private void preOrderTraversalHandler(TreeNode<T> node, List<T> valueList){
        if(null != node){
            valueList.add(node.getVal());
            preOrderTraversalHandler(node.leftChild,valueList);
            preOrderTraversalHandler(node.rightChild,valueList);
        }
    }


}
