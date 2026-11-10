import java.util.ArrayList;
import java.util.List;

public class CycleDetection {
    private static boolean dfsCheck(int node,int parent,List<List<Integer>> adj,boolean[] visited){
        visited[node] = true;
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                if(dfsCheck(neighbour, node, adj, visited)){
                    return true;
                }
            }
            else if(neighbour !=parent){
                return true;
            }
        }
        return false;

    }
    public static boolean depthFirstSearch(int v,List<List<Integer>> adj){
        boolean[] visited = new boolean[v];
       
        for(int i = 0;i<v;i++){
            if(!visited[i]){
                if(dfsCheck(i, -1, adj, visited))
                    return true;

            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Constructing a graph with a cycle: 0 - 1 - 2 - 0
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(0); adj.get(0).add(2);
        
        // Extra edges
        adj.get(2).add(3); adj.get(3).add(2);

        // Test DFS Approach
        boolean dfsResult = depthFirstSearch(V, adj);
        System.out.println("Cycle detected using DFS? " + dfsResult);

        // Test BFS Approach
        
    }
}
