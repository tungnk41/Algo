package com.zeros.algo.collections;

import java.util.HashMap;
import java.util.Map;

public class DSU {
    private Map<Integer,Integer> parent = new HashMap<>();
    private Map<Integer,Integer> rank = new HashMap<>();

    public void makeSet(int[] data){
        for(int element : data){
            parent.put(element,element);
            rank.put(element,0);
        }
    }

    public Integer find(int element){
        if(parent.get(element) == element){
            return element;
        }

        //Path compress
        return parent.put(element,find(parent.get(element)));
    }

    public void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);

        if(parentX != parentY){
            if(rank.get(parentX) < rank.get(parentY)){
                parent.put(parentX,parentY);
            }
            else if(rank.get(parentX) > rank.get(parentY)){
                parent.put(parentY,parentX);
            }
            else{
                parent.put(parentY,parentX);
                rank.put(parentX,rank.get(parentX)+1);
            }
        }
    }

    public static void run(){
        int[] data = {1,2,3,4,5};
        DSU dsu = new DSU();
        dsu.makeSet(data);
        dsu.union(1,4);
        dsu.union(3,4);
        dsu.union(4,5);
        dsu.union(1,5);
        System.out.println("##########");
        System.out.println(dsu.find(5));
        System.out.println(dsu.find(5));

    }
}
