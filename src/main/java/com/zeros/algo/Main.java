package com.zeros.algo;
import com.zeros.algo.collections.*;

public class Main {

    public static void main(String[] args) {
        Timer.start();



//        Sort & search
//        QuickSort.run();

//	     System.out.println(" \nB search : " + LowerBound.search(QuickSort.sort(new int[]{1,2,2,4,6,8}),2));
//       System.out.println(" \nB search : " + UpperBound.search(QuickSort.sort(new int[]{1,2,2,4,6,8}),2));


//        Custom Priority Queue
//        PriorityQueueEx.run();

//        tree.run();

//        Graph.run();

//        Trie.run();

//         BST.run();

//        DirectedGraph.run();

        BloomFilterEx.run();
        Timer.stop();
    }
}
