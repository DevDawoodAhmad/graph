import java.util.ArrayList;
import java.util.List;

public class DFS_Graph{
    private static void dfs(int node,List<List<Integer>> adj , boolean[] visited,List<Integer> result){
        visited[node] = true;
        result.add(node);
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited, result);
            }
        }
    }

    public static List<Integer> depthFirstSearch(int v,List<List<Integer>> adj){
        boolean[] visited = new boolean[v];
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<v;i++){
            if(!visited[i]){
                dfs(i, adj, visited, result);

            }
        }
        return result;

    }
    public static void main(String [] args){
        int V = 6; // Number of vertices (0 to 5)
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Building an undirected graph example
        // 0 connected to 1, 2
        adj.get(0).add(1);
        adj.get(0).add(2);
        // 1 connected to 0, 3, 4
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);
        // 2 connected to 0, 5
        adj.get(2).add(0);
        adj.get(2).add(5);
        // 3 connected to 1
        adj.get(3).add(1);
        // 4 connected to 1
        adj.get(4).add(1);
        // 5 connected to 2
        adj.get(5).add(2);

        List<Integer> traversalResult = depthFirstSearch(V, adj);
        System.out.println("DFS Traversal Order: " + traversalResult);
    }
}