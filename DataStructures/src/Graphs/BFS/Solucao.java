package Graphs.BFS;

 import java.util.LinkedList; 
 import java.util.Queue; 
  
 public class Solucao { 
     private static final int BRANCO = -1; 
     private static final int CINZA = 0; 
     private static final int PRETO = 1; 
  
     private LinkedList<LinkedList<Integer>> grafo; 
     public int[] cor; 
     public int[] distancia; 
     public int[] ante; 
  
     public Solucao(LinkedList<LinkedList<Integer>> grafo) { 
         this.grafo = grafo; 
         int n = grafo.size(); 
         this.cor = new int[n]; 
         this.distancia = new int[n]; 
         this.ante = new int[n]; 
  
         for (int j = 0; j < n; j++) { 
             cor[j] = BRANCO; 
             ante[j] = -1; 
             distancia[j] = Integer.MAX_VALUE; 
         } 
     } 
  
     public void BFS(int s) { 
         cor[s] = CINZA; 
   //      distancia[s] = 0; 
         Queue<Integer> fila = new LinkedList<>(); 
         fila.add(s); 
  
         while (!fila.isEmpty()) { 
             int u = fila.poll(); 
  
             for (int v : grafo.get(u)) { 
                 if (cor[v] == BRANCO) { 
                     cor[v] = CINZA; 
                     distancia[v] = distancia[u] + 1; 
                     ante[v] = u; 
                     fila.add(v); 
                 } 
             } 
  
           cor[u] = PRETO; 
         } 
     }

     public void caminhoMin(int inicio, int fim){

        Integer []caminhoMin = new Integer[grafo.size()];
        int cont = 0;
        int contArray = 1;
        int u;
        caminhoMin[0] = inicio;
        

        do{
           
            u = ante[caminhoMin[cont]];
            caminhoMin[contArray] = u;
            cont++;
            contArray++;


        }while(u != fim);

        for(int i = 0; i < caminhoMin.length; i++){
            System.out.println(caminhoMin[i]);
        }

    } 
 }