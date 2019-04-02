package com.arthur.codes.datastructure;

/**
 * Binary Tree Example (AVL)
 *
 * @author: Arthur Hu
 * @date: 2019/3/16 下午5:35
 * Description:
 */
public class BinaryTree<T extends Comparable<T>> {

    private TreeNode<T> root = null;


    /**
     * Node class of Binary Tree
     * @param <V>
     */
    static class TreeNode<V extends Comparable<V>>{


        private V value;

        private TreeNode<V> leftChild;

        private TreeNode<V> rightChild;

        int height;


        public TreeNode(V value){
            this(value,null,null);
        }

        public TreeNode(V value, TreeNode<V> leftChild, TreeNode<V> rightChild){
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.height = 1;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public TreeNode<V> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode<V> leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode<V> getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode<V> rightChild) {
            this.rightChild = rightChild;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }


    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }


    /**
     * Get Height of node
     */

    public int heightNode(TreeNode<T> node){
        if(node != null){
            node.getHeight();
        }

        return 0;
    }


    /**
     * Gets height of tree
     */

    public int height(){
        return heightNode(root);
    }

    public int maxHeight(int a,int b){
       return a>b? a:b;
    }





    /**
     * Rotates the smallest sub tree which is not AVL any more in Left Left Case
     *
     * right rotates
     *
     * @Params subTreeRoot
     * @Return the new sub tree root node
     *
     */

    public TreeNode<T> rightRotation(TreeNode<T> subTreeRoot){
        TreeNode<T> node = subTreeRoot.getLeftChild();

        subTreeRoot.setLeftChild(node.getRightChild());

        node.setRightChild(subTreeRoot);

        int subTreeRootHeight = maxHeight(heightNode(subTreeRoot.getLeftChild()),heightNode(subTreeRoot.getRightChild()))+1;

        subTreeRoot.setHeight(subTreeRootHeight);

        int nodeHeight = maxHeight(heightNode(node.rightChild),heightNode(node))+1;

        node.setHeight(nodeHeight);

        return node;

    }

    /**
     * left rotates
     */

    public TreeNode<T> leftRotation(TreeNode<T> subTreeRoot){
        TreeNode<T> node = subTreeRoot.getRightChild();

        subTreeRoot.setRightChild(node.getLeftChild());

        node.setLeftChild(subTreeRoot);

        // update the height
        subTreeRoot.setHeight(maxHeight(heightNode(subTreeRoot.getLeftChild()),heightNode(subTreeRoot.getRightChild()))+1);

        node.setHeight(maxHeight(heightNode(node.getLeftChild()),heightNode(node))+1);

        return node;
    }


    /**
     * Gets balance factor of Node n
     */
    public  int getBalanceFactor(TreeNode<T> node){
        if(node == null){
            return 0;
        }

        return heightNode(node.getLeftChild())-heightNode(node.getRightChild());
    }


    /**
     * insert a node into tree
     */

    public TreeNode<T> insertNode(TreeNode<T> tree, T key){

        if(null == tree){
            tree = new TreeNode<>(key);

            return tree;

        }

        if(key.compareTo(tree.getValue()) < 0){
            tree.leftChild = insertNode(tree.leftChild,key);
        }else if(key.compareTo(tree.getValue()) > 0){
            tree.rightChild = insertNode(tree.rightChild, key);
        }else {
            return tree;
        }

        /**
         * update height of this ancestor node
         */

        tree.setHeight(maxHeight(heightNode(tree.leftChild),heightNode(tree.rightChild)) + 1);

        int balance = getBalanceFactor(tree);

        if(balance >= 0 && balance <= 1){
            return tree;
        }

        if(balance > 1 && key.compareTo(tree.getLeftChild().getValue())<0){
            /**
             * LL
             */

            return rightRotation(tree);

        }else if(balance > 1 && key.compareTo(tree.getLeftChild().getValue()) > 0){
            /**
             * LR
             */

            tree.leftChild = leftRotation(tree.leftChild);

            return rightRotation(tree);


        }else if(balance < -1 && key.compareTo(tree.getRightChild().getValue()) < 0){
            /**
             * RL
             */

            tree.rightChild = rightRotation(tree.rightChild);
            return leftRotation(tree);

        }else if(balance < -1 && key.compareTo(tree.getRightChild().getValue()) > 0){
            /**
             *  RR
             */

            return leftRotation(tree);

        }

        return tree;



    }


    public void insert(T key){
        this.root = insertNode(this.root,key);
    }

    /**
     *  preorder
     */

    public void preOrder(TreeNode<T> root){
        if(root != null){
            System.out.println(root.value);
            preOrder(root.leftChild);
            preOrder(root.rightChild);

        }
    }

    public void midOrder(TreeNode<T> root){
        if(root != null){
            midOrder(root.getLeftChild());
            System.out.println(root.value);
            midOrder(root.rightChild);
        }
    }

    public void postOrder(TreeNode<T> root){
        if(root != null){
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.println(root.value);
        }
    }


    /**
     * Test
     */

    public static void main(String[] args) {
        int arr[]= {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};

        BinaryTree<Integer> tree = new BinaryTree<>();

        System.out.printf("== 依次添加: ");
        for(int i=0; i<arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }

        System.out.printf("\n== 前序遍历: ");
        tree.preOrder(tree.getRoot());

        System.out.printf("\n== 中序遍历: ");
        tree.midOrder(tree.getRoot());

        System.out.printf("\n== 后序遍历: ");
        tree.postOrder(tree.getRoot());
        System.out.printf("\n");

        System.out.printf("== 高度: %d\n", tree.height());








//
//        /* Constructing tree given in the above figure */
//        tree.root = tree.insertNode(tree.root, 10);
//        tree.root = tree.insertNode(tree.root, 20);
//        tree.root = tree.insertNode(tree.root, 30);
//        tree.root = tree.insertNode(tree.root, 40);
//        tree.root = tree.insertNode(tree.root, 50);
//        tree.root = tree.insertNode(tree.root, 25);
//
//        /* The constructed AVL Tree would be
//             30
//            /  \
//          20   40
//         /  \     \
//        10  25    50
//        */
//        System.out.println("Preorder traversal" +
//                " of constructed tree is : ");
//        tree.postOrder(tree.root);
    }

}
