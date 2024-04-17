package com.arthur.codes.leetcode.solutiions.easy;

/**
 * @author: huhao
 * @create: 2024/4/16
 */
public class TwoSumSolution_653 {

    int minVal = (int) -Math.pow(10,5);
    int maxVal = (int)Math.pow(10,5);

    public boolean findTarget(TreeNode root, int k) {
        if(root == null || k < minVal || k>maxVal){
            return false;
        }

        return inOrderTraversal(root,k);

    }

    public boolean inOrderTraversal(TreeNode root, int k){
        if(root == null){
            return false;
        }
        if(null != root.left){
            return         inOrderTraversal(root.left,k);

        }
        int temple = k - root.val;
        if(search(root,temple) != null){
            return true;
        }

        return inOrderTraversal(root.right,k);
    }

    public TreeNode search(TreeNode node, int k){
        if(null == node || node.val == k){
            return node;
        }

        if(node.val > k){
            return search(node.left,k);
        }
        return search(node.right,k);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
