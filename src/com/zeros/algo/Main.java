package com.zeros.algo;
import com.zeros.algo.collections.*;


public class Main {

    public static void main(String[] args) {
        Timer.start();
        /* Sort & search
	    int[] array = {10,20,20,20,20,30,30,40};

	    for(int i : QuickSort.sort(array)){
	        System.out.print(i + " ");
        }

	    System.out.println(" \nB search : " + LowerBound.search(array,70));
        System.out.println(" \nB search : " + UpperBound.search(array,70));
        */


        /*Custome Priority Queue
        JPriorityQueue queue = new JPriorityQueue();
        queue.run();
        */

//        BinaryTree tree = new BinaryTree();
//        tree.run();

//        Graph.run();

//        Trie.run();

        BST.run();
        Timer.stop();
    }
}
