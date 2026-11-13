package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CycDet_With_Kahn {

    public static boolean isCyclicBFS(int v,List<List<Integer>> adj){
        int[] inDegree = new int[v];
        for(int u=0;u<v;u++){
            for(int j: adj.get(u)){
                inDegree[j]++;

            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for(int neighbour:adj.get(curr)){
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0){
                    q.add(neighbour);
                }
            }

            
        }
        return count !=v;


    }
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Creating a graph with a cycle: 0 -> 1 -> 2 -> 3, and 3 -> 1
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // Back edge creating a cycle

        System.out.println("Cycle Present (BFS): " + isCyclicBFS(V, adj)); // Output: true
    }
}