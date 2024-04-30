package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {


    static class Graph{
        int vertices;
        LinkedList<Integer>[] adjList;

        public Graph(int vertices){
            this.vertices= vertices;
            adjList = new LinkedList[vertices];
            for(int i=0;i<vertices;i++){
                adjList[i] = new LinkedList<>();
            }


        }
        void addEdge(int u,int v){
            adjList[u].add(v);
        }

        void bfs(int startNode){
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[vertices];


            queue.add(startNode);
            visited[startNode]=true;
            while(!queue.isEmpty()){
                int currNode = queue.poll();
                System.out.println(currNode+" ");
                for(int connNode:adjList[currNode]){
                    if(!visited[connNode]){
                        queue.add(connNode);
                        visited[connNode]=true;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int vertices =5;

        Graph graph = new Graph(vertices);

        ArrayList<ArrayList<Integer>> adj;

        graph.addEdge(0, 1);    //         1   --  3
        graph.addEdge(0, 2);    //       /   \
        graph.addEdge(1, 3);    //     0       4
        graph.addEdge(1, 4);    //       \   /
        graph.addEdge(2, 4);    //         2

        System.out.print(
                "Breadth First Traversal starting from vertex 0: ");
        graph.bfs(0);
    }
}


