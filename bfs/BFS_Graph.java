package bfs;
import java.util.*;


public class BFS_Graph {
    public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            bfsTraversal.add(currentNode);
            for(int neighbour: adj.get(currentNode)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
            
        }
        return bfsTraversal;

    }
    public static void main(String[] args){

        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(4);
        
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        
        adj.get(2).add(1);
        
        adj.get(3).add(1);
        adj.get(3).add(4);
        
        adj.get(4).add(0);
        adj.get(4).add(3);

        ArrayList<Integer> result = bfsOfGraph(v, adj);
        
        System.out.println("BFS Traversal starting from node 0:");
        for (int node : result) {
            System.out.print(node + " ");
        }



    }
    
}
