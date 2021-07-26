package com.zeros.algo.collections;

import java.util.*;

public class DirectedGraph {

    private Map<String,Vertex> graph;

    public static class Edge{
        private String source;
        private String destination;
        private int distance;

        public Edge(String source, String destination, int distance){
            this.source =source;
            this.destination =destination;
            this.distance = distance;
        }
    }

    public class Vertex implements Comparable<Vertex>{
        public String name;
        public Vertex parent = null;
        public int shortestDist = Integer.MAX_VALUE;
        public Map<Vertex,Integer> neighbours = new HashMap<>();

        public Vertex(String name){
            this.name = name;
        }

        @Override
        public int compareTo(Vertex other) {
            if(shortestDist == other.shortestDist){
                return name.compareTo(other.name);
            }
            return Integer.compare(shortestDist,other.shortestDist);
        }

        public void printPath(){
            if(parent == null){
                System.out.print(name);
            }else{
                parent.printPath();
                System.out.print(" -> ");
                System.out.print(name);
            }
        }
    }


    public DirectedGraph(Edge[] edges){
        graph = new HashMap<>(edges.length);

        for(Edge edge : edges){
            if(!graph.containsKey(edge.source)){
                graph.put(edge.source, new Vertex(edge.source));
            }
            if(!graph.containsKey(edge.destination)){
                graph.put(edge.destination, new Vertex(edge.destination));
            }

            graph.get(edge.source).neighbours.put(graph.get(edge.destination),edge.distance);
        }
    }

    public void dijkstra(String start, String end){
        if(!graph.containsKey(start) || !graph.containsKey(end)){
            System.out.println("Invalid start or end vertex");
            return;
        }

        NavigableSet<Vertex> unVisited = new TreeSet<>(); //HashSet with sorted order
        Set<Vertex> visited = new HashSet<>();

        Vertex source = graph.get(start);
        source.shortestDist = 0;

        unVisited.add(source);

        while (!unVisited.isEmpty()){

            Vertex current = unVisited.pollFirst();
            if(current.name == end){
                break;
            }

            for(Map.Entry<Vertex,Integer> neighbour : current.neighbours.entrySet()){
                if(current.shortestDist + neighbour.getValue() < neighbour.getKey().shortestDist){
                    neighbour.getKey().shortestDist = current.shortestDist + neighbour.getValue();
                    neighbour.getKey().parent = current;
                    if(!visited.contains(neighbour.getKey())){
                        unVisited.add(neighbour.getKey());
                    }
                }
            }
            unVisited.remove(current);
            visited.add(current);
        }


        System.out.println(graph.get(end).shortestDist);
        graph.get(end).printPath();
    }


    public static void run(){
        DirectedGraph graph = new DirectedGraph( new Edge[]
                {
                        new Edge("a","b",2),
                        new Edge("a","c",2),
                        new Edge("b","c",2),
                        new Edge("c","d",2),
                        new Edge("c","e",2),
                        new Edge("d","e",2),
                        new Edge("d","b",2),

                }
        );

        graph.dijkstra("a","e");
    }
}
