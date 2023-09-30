package Graphs.AdjacencyMatrix;

public class AdjacencyMatrix{
    private int v;  //number of vertices in Graph
    private int e; // Number of edges in Graph
    private int [][] AdjMatrix;

    public AdjacencyMatrix(int nodes){
        this.v = nodes;
        this.e = 0;
        this.AdjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v){
        this.AdjMatrix[u][v] = 1;
        this.AdjMatrix[v][u] = 1;
        e++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(v + " vertices, "+ e + " edges "+ "\n");
        for(int v = 0; v < this.v; v++){
            sb.append(v +": ");
            for(int w: AdjMatrix[v]){
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjacencyMatrix g = new AdjacencyMatrix(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println(g);
    }
}