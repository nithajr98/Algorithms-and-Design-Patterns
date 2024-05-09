package Algorithms;

import java.util.LinkedList;

public class DFS {
    Integer v;
    LinkedList<Integer>[] adj;
    DFS(int v){
        this.v=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }

    void DFSmain(int start){
        boolean[] visited = new boolean[v];

        DFSUtil(start,visited);
    }

    void DFSUtil(int v,boolean[] visited){
        visited[v]=true;
        System.out.print(v + " ");

        for(Integer i : adj[v]){
            if(!visited[i]){
                DFSUtil(i,visited);
            }
        }


    }
    void addEdge(int u,int v){
        adj[u].add(v);
    }
    public static void main(String[] args) {
        int vertices =5;

        DFS graph = new DFS(vertices);

        graph.addEdge(0, 1);    //         1   --  3
        graph.addEdge(0, 2);    //       /   \
        graph.addEdge(1, 3);    //     0       4
        graph.addEdge(1, 4);    //       \   /
        graph.addEdge(2, 4);    //         2
        graph.addEdge(1, 0);
        graph.addEdge(2, 0);
        graph.addEdge(3, 1);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);

        System.out.print(
                "Breadth First Traversal starting from vertex 0: ");
        graph.DFSmain(1);
    }

}
