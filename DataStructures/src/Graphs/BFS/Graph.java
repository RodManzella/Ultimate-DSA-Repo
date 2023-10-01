package Graphs.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private LinkedList<Integer>[]adj;  // declarando array de LinkedLists
    private int v;  //Number of vertices
    private int e; // Number of edges

    public Graph(int nodes){
        this.v = nodes;
        this.e = 0;
        this.adj = new LinkedList[nodes]; // inicializando array de LinkedLists do tamanho de nodes

        for(int v= 0; v < this.v; v++){
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
        this.e++;
    }


    public void bfs(int s){
        boolean[]visited = new boolean[this.v];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);

        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.println(u + " ");

            for(int v: adj[u]){
                if(!visited[v]){
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.v + " vertices, "+ this.e+ " edges "+"\n");
        for(int v = 0; v < this.v; v++){
            sb.append(v + ": ");
            for(int w : adj[v]){
                sb.append(w+ " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public void bfs2(int s){
        int[]cor = new int[this.v]; // cor dos vértices (-1 = B, 0 = C, 1 = P)
        int[]d = new int[this.v];
        int[]ante = new int[this.v];
        for(int i = 0; i < this.adj.length; i++){
            cor[i] = -1;
            d[i] = -1;
        }
        cor[s] = 0;
        d[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.println(u + " ");

            for(int v: adj[u]){
                if(cor[v] == -1){ // se for for branca
                    cor[v] = 0; // cor cinza (visitando)
                    d[v] = d[u] + 1;
                    ante[v] = u;
                    queue.offer(v);
                }
            }
            cor[u] = 1;
        }
    }
    

    public static void main(String[] args){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.bfs(0);
        System.out.println("===============");
        g.bfs2(0);
       
    }
}
