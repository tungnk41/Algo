package com.zeros.algo.collections;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree(){

    }

    public BinaryTree(int[] arrayInit){
        for(int i= 0;i <arrayInit.length; i++){
            insert(arrayInit[i]);
        }
    }

    protected boolean insert(int value){
        if(root == null){
            root = new TreeNode(value);
        }else{
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left == null){
                    node.left = new TreeNode(value);
                    break;
                }
                if (node.right == null){
                    node.right = new TreeNode(value);
                    break;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }

    protected int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        else {
            return 1 + Math.max(depth(root.left),depth(root.right));
        }
    }
    protected int depth(){
        return depth(root);
    }
    protected int size(){
        return size(root);
    }
    protected int size(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
    }
    protected boolean search(int value){
        return search(root, value);
    }
    private boolean search(TreeNode root,int value){
        if(root == null){
            return false;
        }
        if(root.value == value){
            return true;
        }

        return search(root.left,value) || search(root.right,value);
    }

    protected void bfs(){
        bfs(root);
    }
    protected void bfs(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if(node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }
    protected void inOrder(){
        inOrder(root);
    }
    protected void preOrder(){
        preOrder(root);
    }
    protected void postOrder(){
        postOrder(root);
    }
    protected void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }
    protected void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    protected void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

///////////////////////////////////////////////////////////////////////////////////////
    public static void run(){
        BinaryTree tree = new BinaryTree(new int[]{5,2,8,1,3,7,9});
        /*
                5
            2      8
          1  3   7  9

         */
//        tree.bfs();
        //tree.preOrder();
        System.out.println(tree.search(5));

    }
}
