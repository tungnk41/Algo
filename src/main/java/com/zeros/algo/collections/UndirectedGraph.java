package com.zeros.algo.collections;

import java.util.*;

public class UndirectedGraph {
    private int V; //Number vertex
    private List<List<Integer>> adjList;

    public UndirectedGraph(List<List<Integer>> adjList){
        this.adjList = adjList;
        V = adjList.size();
    }

    boolean bfs(int startNode,int search){
        boolean[] visisted = new boolean[V];
        Arrays.fill(visisted,false);

        Queue<Integer> queue = new LinkedList<>();
        visisted[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()){
            int node = queue.poll();
            if(node == search){
                System.out.print("\nFound Node: " + node);
                return true;
            }
            System.out.print(" Node: " + node);
            for (int neighbour : adjList.get(node)){
                if(!visisted[neighbour]){
                    visisted[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }

        return false;
    }

    boolean dfs(int startNode, int search){
        boolean[] visisted = new boolean[V];
        return dfs(startNode,visisted,search);
    }

    boolean dfs(int node, boolean[] visisted, int search){
        visisted[node] = true;
        if(node == search){
            System.out.print("\nFound Node: " + node);
            return true;
        }

        System.out.print(" Node: " + node);
        for(int neighbour : adjList.get(node)){
            if(!visisted[neighbour]){
                boolean result = dfs(neighbour,visisted,search);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }

    public static void run(){
        List<List<Integer>> adjList = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(0,2,3),
                Arrays.asList(0,1,4),
                Arrays.asList(1,4,5),
                Arrays.asList(2,3,5),
                Arrays.asList(3,4)
        );
        UndirectedGraph graph = new UndirectedGraph(adjList);
        graph.bfs(0,3);
    }
}
