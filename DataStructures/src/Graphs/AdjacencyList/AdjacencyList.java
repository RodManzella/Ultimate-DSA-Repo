package Graphs.AdjacencyList;

import java.util.LinkedList;

public class AdjacencyList {
    private LinkedList<Integer>[]adj;  // declarando array de LinkedLists
    private int v;  //Number of vertices
    private int e; // Number of edges

    public AdjacencyList(int nodes){
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

    public static void main(String[] args){
        AdjacencyList g = new AdjacencyList(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println(g);
    }
}
