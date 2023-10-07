package Graphs.BFSMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solucao{

    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;

    public int[] cor;
    public int[] distancia;
    public Integer[] ante;
    public Queue<Integer> fila;

    public boolean[][] grafo;
    
     public Solucao(boolean[][]grafo) { 
         this.grafo = grafo;
         int size = grafo.length;

         this.cor = new int[size]; 
         this.distancia = new int[size]; 
         this.ante = new Integer[size]; 
         fila = new LinkedList<>();
  
    }

    public void BFS(int s){
       try{
        for (int i = 0; i < grafo.length; i++) { 
            cor[i] = BRANCO; 
            ante[i] = null; 
            distancia[i] = -1; 
        } 

        cor[s] = CINZA; 
        fila.offer(s);
        distancia[s] = 0;
  
         while (!fila.isEmpty()) { 
             int u = fila.poll(); 
            
             for(int v = 0; v < grafo[u].length; v++){
                if (grafo[u][v] == true && cor[v] == BRANCO) {
                    cor[v] = CINZA; 
                    fila.offer(v);
                    ante[v] = u;
                    distancia[v] = distancia[u]+1;  
                }
            }
            cor[u] = PRETO; 
        }
       }catch(Exception e){
            System.out.println("Falhou!");
       }

        
    }
 }


