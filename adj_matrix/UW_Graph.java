import java.util.Scanner;

class UW_Graph{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Vertices: ");
        int vertices = scanner.nextInt();
        int[][] adjMatrix = new int[vertices][vertices];
        System.out.print("Enter the number of Edges: ");
        int edges = scanner.nextInt();
        System.out.println("Enter each edge as two space-separated node indices and weight (e.g., 0 1 W):");

        int u,v,weight;
        for(int i = 0 ;i<edges; i++){
            u = scanner.nextInt();
            v= scanner.nextInt();
            weight = scanner.nextInt();
            adjMatrix[u][v] = weight;
            adjMatrix[v][u] = weight;
        }
        scanner.close();
        System.out.println("<-------- Adjacency Matrix representation ------>");

        System.out.print(" ");
        for(int i = 0;i<vertices;i++){
            System.out.print(i+ " ");
        }

        System.out.println();
        for(int i = 0; i<vertices;i++){
            System.out.print(i+ " ");
            for(int j = 0;j<vertices;j++){
                System.out.print(adjMatrix[i][j]+ " ");
            }
            System.out.println();

        }
    }
}