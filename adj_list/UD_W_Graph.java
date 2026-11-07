package adj_list;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UD_W_Graph {
    static class Pair {
        int node;
        int weight;
        Pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter the number of edges: ");;
        int edges = sc.nextInt();
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0;i<vertices;i++){
            adjList.add(new ArrayList<>());
        }
        System.out.println("Enter the edges in the format U V Weight");
        for(int i = 0;i<edges;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            adjList.get(u).add(new Pair(v,weight));
            adjList.get(v).add(new Pair(u,weight));

        }
        sc.close();

        System.out.println("\n --- Adjacency List of Weighted Graph ---");
        for(int i=0;i<vertices;i++){
            System.out.print("vertex "+i+" --> ");
            for(int j = 0;j<adjList.get(i).size();j++){
                Pair p = adjList.get(i).get(j);
                System.out.print("(Neighbour: "+p.node+", Weight: "+p.weight+") ");
            }
            System.out.println();
        }
    }
    
}
