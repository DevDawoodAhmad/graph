package adj_list;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ud_Uw_Graph {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of Edges: ");
        int e = sc.nextInt();
        List<List<Integer>> adjList = new ArrayList();
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        System.out.println("Enter the edges (u,v):");
        for(int i = 0;i<e;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        sc.close();

        System.out.println("\n --- Adjacency List ---");
        for(int i = 0;i<n;i++){
            System.out.print(i+" ");
            for(int j = 0;j<adjList.get(i).size();j++){
                System.out.print(" --> "+adjList.get(i).get(j));

            }
            System.out.println();
        }

    }


    
}
