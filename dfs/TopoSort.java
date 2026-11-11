import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSort {

    static void dfs(int node,List<List<Integer>> adj,boolean[] visited,Stack<Integer> stack){
        visited[node] = true;
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited, stack);
            }
        }
        System.out.println("function ended for node: "+node);
        stack.push(node);
    }
    static List<Integer> topoSort(int v,List<List<Integer>> adj){
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for(int i =0;i<v;i++){
            if(!visited[i]){
                dfs(i, adj, visited, stack);
                
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
            
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
        System.out.println(topoSort(v, adj));

    }
    
}
