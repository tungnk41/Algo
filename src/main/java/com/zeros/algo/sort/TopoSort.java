package com.zeros.algo.sort;

import com.zeros.algo.collections.DirectedGraph;

import java.util.*;

public class TopoSort {
    private Map<String,Integer> indegreeTable = new HashMap<>(); // Vertex - indegree
    private Map<String,List<String>> graph = new HashMap<>();

    public TopoSort(DirectedGraph graph){
        this.graph = graph.exportGraphByName();
        createIndegreeTable();
    }

    public void createIndegreeTable(){
        for(Map.Entry<String, List<String>> entry : graph.entrySet()){
            if(!indegreeTable.containsKey(entry.getKey())){
                indegreeTable.put(entry.getKey(), 0);
            }
            for(String neighbour : entry.getValue()){
                indegreeTable.put(neighbour,indegreeTable.getOrDefault(neighbour,0) + 1);
            }
        }
    }

    public List<String> sort(){
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        for (Map.Entry<String,Integer> entry : indegreeTable.entrySet()){
            if(entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }

        if(queue.isEmpty()){
            System.out.println("Graph is not DAG");
            return result;
        }

        while (!queue.isEmpty()){
            String vertex = queue.poll();
            result.add(vertex);

            for (String neighbour : graph.get(vertex)){
                indegreeTable.put(neighbour,indegreeTable.get(neighbour)-1);
                if(indegreeTable.get(neighbour) == 0){
                    queue.add(neighbour);
                }
            }
        }

        return result;
    }

    public static void run(){
        DirectedGraph graph = new DirectedGraph( new DirectedGraph.Edge[]
                {
                        new DirectedGraph.Edge("5","0",1),
                        new DirectedGraph.Edge("5","2",1),
                        new DirectedGraph.Edge("4","0",1),
                        new DirectedGraph.Edge("4","1",1),
                        new DirectedGraph.Edge("2","3",1),
                        new DirectedGraph.Edge("3","1",1),

                        // Not DAG graph test
//                        new DirectedGraph.Edge("1","2",1),
//                        new DirectedGraph.Edge("2","3",1),
//                        new DirectedGraph.Edge("3","1",1),

                }
        );

        TopoSort topoSort = new TopoSort(graph);
        System.out.print(topoSort.sort().toString());
    }
}
