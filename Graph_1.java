
import java.util.Scanner;

public class Graph_1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Vertices: ");
        int vertices = scanner.nextInt();
        int[][] adjMatrix = new int[vertices][vertices];
       
        System.out.print("Enter number of Edges: ");
        int edges = scanner.nextInt();
        System.out.println("Enter each edge as two space-separated node indices (e.g., 0 1):");
        for(int i =0;i<edges; i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;
        }
        scanner.close();
        System.out.println("\n--- Adjacency Matrix Representation ---");

        System.out.print(" ");
        for(int i =0;i<vertices;i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 0;i<vertices;i++){
            System.out.print(i+" ");
            for(int j =0;j<vertices;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}