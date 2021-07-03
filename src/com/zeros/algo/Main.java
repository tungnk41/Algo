package com.zeros.algo;
import com.zeros.algo.*;
import com.zeros.algo.collections.*;
import com.zeros.algo.sort.QuickSort;


public class Main {

    public static void main(String[] args) {
        Timer.start();



        //Sort & search
//	    int[] array = {1,2,3,4,5,6,7,8,-1,-2,-6};
//
//	    for(int i : QuickSort.sort(array)){
//	        System.out.print(i + " ");
//        }

	    // System.out.println(" \nB search : " + LowerBound.search(array,70));
        // System.out.println(" \nB search : " + UpperBound.search(array,70));


        //Custome Priority Queue
        // JPriorityQueue queue = new JPriorityQueue();
        // queue.run();


//        BinaryTree tree = new BinaryTree();
//        tree.run();

//        Graph.run();

//        Trie.run();

        // BST.run();

        DirectedGraph.run();
        Timer.stop();
    }
}
