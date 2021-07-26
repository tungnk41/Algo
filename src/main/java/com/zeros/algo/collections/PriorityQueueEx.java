package com.zeros.algo.collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueEx {
    PriorityQueue<Integer> intQueue;
    PriorityQueue<String> strQueue;
    Comparator<String> strComparator;
    public PriorityQueueEx(){
        strComparator = new StringComparator();

        /*
        * a : item need add to queue
        * b : another item has already added in queue
        * (a,b) : a will be added back b if Comparator return positive value, Compiler will know a > b, Min Queue
        * (a,b) : a will be added front b if  Comparator return negative value Compiler will know a < b, Max Queue
        *
        * */
        intQueue = new PriorityQueue<>((a,b) -> b-a);
        strQueue = new PriorityQueue<>(strComparator);

    }

    public static void run(){
        PriorityQueueEx priorityQueueEx = new PriorityQueueEx();

        priorityQueueEx.intQueue.add(2);
        priorityQueueEx.intQueue.add(3);
        priorityQueueEx.intQueue.add(5);
        System.out.println(" peak " + priorityQueueEx.intQueue.peek());

        priorityQueueEx.strQueue.add("abc");
        priorityQueueEx.strQueue.add("abcd");
        priorityQueueEx.strQueue.add("abcdf");
        System.out.println(" str peak : " + priorityQueueEx.strQueue.peek());

    }

    private class StringComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            //Min queue
            if(s1.length() > s2.length()){
                return 1;
            }
            if(s1.length() < s2.length()) {
                return -1;
            }
            return 0;
        }
    }
}
