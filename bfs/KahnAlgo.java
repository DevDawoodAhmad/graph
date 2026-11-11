package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnAlgo {
    static List<Integer> kahn(int v , List<List<Integer>> adj){
        int[] indegree = new int[v];
        for(int u =0;u<v; u++){
            for(int j : adj.get(u)){
                indegree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<v;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for(int nxt: adj.get(node)){
                indegree[nxt]--;
                if(indegree[nxt]==0){
                    queue.add(nxt);
                }
            }
            
        }
        return result;

    }
    public static void main(String [] args){
        int v = 4;
        int[][] edges = {{0,1},{0,2},{1,3},{2,3}};
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
        }
        System.out.println(kahn(v, adj));

    }
    
}
