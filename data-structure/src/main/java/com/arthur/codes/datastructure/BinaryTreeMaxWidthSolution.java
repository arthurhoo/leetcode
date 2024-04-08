package com.arthur.codes.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: huhao
 * @create: 2024/4/7
 */
public class BinaryTreeMaxWidthSolution {

//    public static class TreeNode{
//        private int val;
//        private TreeNode leftChild;
//        private TreeNode rightChild;
//
//        public TreeNode(int val){
//            this.val = val;
//            leftChild = null;
//            rightChild = null;
//        }
//
//        public TreeNode(int val, TreeNode left, TreeNode right){
//            this(val);
//            this.leftChild = left;
//            this.rightChild = right;
//        }
//
//        public int getVal(){
//            return this.val;
//        }
//    }

    public static class Pair<K,V>{
        private K key;
        private V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static int widthOfBinaryTree(BinaryTree.TreeNode root){
        int width = 0;
        if(null == root){
            return width;
        }
        Pair<BinaryTree.TreeNode,Integer> rootPair = new Pair<>(root,1);
        ArrayList<Pair<BinaryTree.TreeNode,Integer>> traversalList = new ArrayList<>();

       traversalList.add(rootPair);

        while (!traversalList.isEmpty()) {
            ArrayList<Pair<BinaryTree.TreeNode, Integer>> levelNodeList = new ArrayList<>();

            for(Pair<BinaryTree.TreeNode,Integer> pair:traversalList ){
                //利用满二叉树的性质进行计算index
                BinaryTree.TreeNode node = pair.getKey();
                Integer index = pair.getValue();
                if(null != node.getLeftChild()){
                    Pair<BinaryTree.TreeNode,Integer> left = new Pair<>(node.getLeftChild(),index * 2);
                    levelNodeList.add(left);
                }
                if(null != node.getRightChild()){
                    Pair<BinaryTree.TreeNode,Integer> right = new Pair<>(node.getRightChild(),index * 2+1);
                    levelNodeList.add(right);
                }
            }
            int levelWidth = traversalList.get(traversalList.size()-1).getValue() - traversalList.get(0).getValue()+1;
            width = width < levelWidth? levelWidth:width;
            traversalList = levelNodeList;

        }


        return width;
    }

    public static int calLevelWidth(LinkedList<BinaryTree.TreeNode> treeNodesList){
        int size = treeNodesList.size();
        int startIndex = 0;
        int endIndex = size-1;

        Iterator<BinaryTree.TreeNode> first = treeNodesList.iterator();
        Iterator<BinaryTree.TreeNode> last = treeNodesList.descendingIterator();

        while (first.hasNext()){
            BinaryTree.TreeNode element = first.next();
            if(null != element){
                startIndex = treeNodesList.indexOf(element);
                break;
            }
        }
        while (last.hasNext()){
            BinaryTree.TreeNode element = last.next();
            if(null != element){
                endIndex = treeNodesList.indexOf(element);
                break;
            }
        }

        return endIndex-startIndex+1;
    }

    public static void main(String[] args) {
        Integer arr[]= {1,3,2,5,3,8,9};

        BinaryTree<Integer> tree = new BinaryTree<>();

        System.out.printf("== 依次添加: ");
        for(int i=0; i<arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }
        System.out.println();
        BinaryTree.TreeNode root = tree.getRoot();
        System.out.printf("根节点：%d",root.getValue());
        System.out.println();
        int width = widthOfBinaryTree(root);
//        LinkedList<BinaryTree.TreeNode> temp = new LinkedList<>();
//        temp.add(null);
//        temp.add(null);
//        temp.add(new BinaryTree.TreeNode<>(2));
//
//        temp.add(null);
//        temp.add(null);
//        temp.add(null);
//
//        temp.add(new BinaryTree.TreeNode<>(3));
//
//        temp.add(null);

        System.out.println("宽度为："+width);
    }


}
