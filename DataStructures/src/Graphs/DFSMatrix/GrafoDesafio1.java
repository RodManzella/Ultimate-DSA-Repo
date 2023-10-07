package Graphs.DFSMatrix;

import java.util.LinkedList;

public class GrafoDesafio1 {
    
    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;
    
    public int[] ante;
    public int[] i;
    public int[] f;
    public int[] cor;
    public int tempo;
    public int sum = 0;
    private boolean [][] grafo;

    public GrafoDesafio1(int vertices){
        this.grafo = new boolean[vertices][vertices];
    }

    public void addEdge(int u, int v){
        this.grafo[u][v] = true;
        this.grafo[v][u] = true;
    }

    public void dfs_start(int s){

        this.ante = new int[grafo.length];
        this.i = new int[grafo.length];
        this.f = new int[grafo.length];
        this.cor = new int[grafo.length];

        for(int j = 0; j < grafo.length; j++){

            cor[j] = BRANCO;
            i[j] = -2;
            f[j] = -2;
            ante[j] = -2;
        }

        tempo = -1;
        dfs_visit(s);


    }

    public void dfs_visit(int u){
        
          // tempo = 0
        i[u] = tempo;  // i[o] = 0  sendo 0 o vértice inicial
        cor[u] = CINZA;  // cor[0] = CINZA

        LinkedList<Integer> adj = new LinkedList<Integer>();
        // cria linkedlist

        for(int i = 0; i < grafo.length; i++){

            if(grafo[u][i] == true){
                adj.add(i);
            }

        }

        for(int v : adj){

            if(cor[v] == BRANCO){
                ante[v] = u;
                dfs_visit(v);
            }

        }

        tempo++;
        f[u] = tempo;
        cor[u] = PRETO;
        sum += u;
    }

   




    public static void main(String[] args){
        GrafoDesafio1 grafo = new GrafoDesafio1(16);
        
        grafo.addEdge(10, 15);
        grafo.addEdge(10, 5);
        grafo.addEdge(15, 1);
        grafo.dfs_start(10);
    }

}


