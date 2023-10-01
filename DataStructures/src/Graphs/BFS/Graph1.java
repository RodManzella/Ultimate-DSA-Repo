package Graphs.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Graph1 {
    private int V; // Número de vértices
    private LinkedList<LinkedList<Integer>> adjList; // Lista de adjacências
    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;
    public Integer[] ante;
    public int[]cor;
    public int d[];

    public Graph1(int V) {
        this.V = V;
        adjList = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new LinkedList<>());
        }
        ante = new Integer[this.V];
        d = new int[this.V];
        cor = new int[this.V];
    }

    public void addEdge(int v, int u) {
        adjList.get(v).add(u);
    }

    public void bfs(int s){
        boolean[]visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);

        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.println(u + " ");

            for(int v: adjList.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }
    public void bfs2(int s){
        
        for(int i = 0; i < this.V; i++){
            cor[i] = BRANCO;
            d[i] = -1;
            this.ante[i] = null;
        }
        cor[s] = CINZA;
        d[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.println(u + " ");

            for(int v: adjList.get(u)){
                if(cor[v] == BRANCO){ // se for for branca
                    cor[v] = CINZA; // cor cinza (visitando)
                    d[v] = d[u] + 1;
                    ante[v] = u;
                    queue.offer(v);
                }
            }
            cor[u] = PRETO;  // fica preto depois que todos os adjacentes forem visitados
        }
    }

    
    public static void main(String[] args){
        Graph1 g = new Graph1(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.bfs(0);
    }


}
