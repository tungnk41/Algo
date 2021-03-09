package com.zeros.algo.collections;

public class BST extends BinaryTree {

    private TreeNode root;
    BST(){
    }

    public BST(int[] arrayInit){
        for(int i= 0;i <arrayInit.length; i++){
            insert(arrayInit[i]);
        }
    }


    @Override
    protected boolean insert(int value){
        if(root == null){
            root = new TreeNode(value);
        }
        else {
            TreeNode current = root;
            TreeNode parent = null;
            while (current != null){
                if(current.value < value){
                    parent = current;
                    current = current.right;
                }
                else if(current.value > value){
                    parent = current;
                    current = current.left;
                }else{
                    return false;
                }
            }

            if(parent.value < value){
                parent.right = new TreeNode(value);
            }
            if (parent.value > value){
                parent.left = new TreeNode(value);
            }
        }
        return true;
    }
    public static void run(){
        BST tree = new BST(new int[]{5,2,8,1,3,7,9});
        tree.preOrder(tree.root);
    }
}
