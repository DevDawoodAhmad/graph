package bfs;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class CycleDetection {
    static class NodePair{
        int node;
        int parent;
        NodePair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }

    public static boolean isCycleBFS(int v,List<List<Integer>> adj){
        boolean[] visited = new boolean[v];
        for(int i =0;i<v;i++){
            if(!visited[i]){
                if(bfsCheck(i, adj, visited)){
                    return true;
                }

            }
        }
        return false;

    }

    private static boolean bfsCheck(int startNode,List<List<Integer>> adj,boolean[] visited){
        Queue<NodePair> queue = new LinkedList<>();
        visited[startNode] = true;
        queue.add(new NodePair(startNode, -1));
        while (!queue.isEmpty()) {
            NodePair current = queue.poll();
            int node = current.node;
            int parent = current.parent;
            for(int neighbour: adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(new NodePair(neighbour,node));
                }
                else if(neighbour!=parent){
                    return true;
                }
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

        
        // Test BFS Approach
        boolean bfsResult = isCycleBFS(V, adj);
        System.out.println("Cycle detected using BFS? " + bfsResult);
    }
    
}
