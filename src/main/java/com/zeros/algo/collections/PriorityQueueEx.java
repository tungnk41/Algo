package com.zeros.algo.collections;
import kotlin.Pair;

import java.util.*;

public class PriorityQueueEx {
    PriorityQueue<Integer> intQueue;
    PriorityQueue<String> strQueue;
    public PriorityQueueEx(){

        /*
        * a : item need add to queue
        * b : another item has already added in queue
        * (a,b) : a will be added back b if Comparator return positive value, Compiler will know a > b, Min Queue
        * (a,b) : a will be added front b if  Comparator return negative value Compiler will know a < b, Max Queue
        *
        * */
        intQueue = new PriorityQueue<>((a,b) -> b-a);
        strQueue = new PriorityQueue<>(new Comparator<String>() {
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
        });

        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer,Integer>>(){

            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                if(p1.getSecond() >  p2.getSecond()){
                    return -1;
                }
                if(p1.getSecond() < p2.getSecond()){
                    return 1;
                }
                return 0;
            }
        });
    }

    public static void run(){
//        PriorityQueueEx priorityQueueEx = new PriorityQueueEx();
//
//        priorityQueueEx.intQueue.add(2);
//        priorityQueueEx.intQueue.add(3);
//        priorityQueueEx.intQueue.add(5);
//        System.out.println(" peak " + priorityQueueEx.intQueue.peek());
//
//        priorityQueueEx.strQueue.add("abc");
//        priorityQueueEx.strQueue.add("abcd");
//        priorityQueueEx.strQueue.add("abcdf");
//        System.out.println(" str peak : " + priorityQueueEx.strQueue.peek());



        int[] nums = new int[]{1,1,1,2,2,3,3,3,3};
        int k = 3;




        int[] answer = new int[k];

        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(Integer num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(entry.getKey());
            if(pq.size() > k){
                pq.poll();
            }
        }

        for(int i = k-1; i >= 0;i--){
            answer[i] = pq.poll();
        }



        System.out.println(Arrays.toString(answer));

    }

}
