package com.zeros.algo.collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JPriorityQueue {
    PriorityQueue<Integer> iQueue;
    PriorityQueue<String> sQueue;
    Comparator<String> sComparator;
    public JPriorityQueue(){
        sComparator = new StringComparator();

        /*
        * a : item need add to queue
        * b : another item has already added in queue
        * (a,b) : a will be added back b if Comparator return positive value, Compiler will know a > b, Min Queue
        * (a,b) : a will be added front b if  Comparator return negative value Compiler will know a < b, Max Queue
        *
        * */
        iQueue = new PriorityQueue<>((a,b) -> b-a);
        sQueue = new PriorityQueue<>(sComparator);

    }

    public void run(){
        iQueue.add(2);
        iQueue.add(3);
        iQueue.add(5);
        System.out.println(" peak " + iQueue.peek());

        sQueue.add("abc");
        sQueue.add("abcd");
        sQueue.add("abcdf");
        System.out.println(" s peak : " + sQueue.peek());

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
