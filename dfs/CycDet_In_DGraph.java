import java.util.ArrayList;
import java.util.List;

public class CycDet_In_DGraph {
    private static boolean dfsCheck(int node,List<List<Integer>> adj,boolean[] visited,boolean[] pathVisited){
        visited[node] = true;
        pathVisited[node] = true;
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                if(dfsCheck(neighbour, adj, visited, pathVisited)){
                    return true;
                }
            }
            else if(pathVisited[neighbour]){
                return true;
            }
        }
        pathVisited[node] = false;
        return false;

    }
    public static boolean isCyclicDFS(int v,List<List<Integer>> adj){
        boolean[] visited = new boolean[v];
        boolean[] pathVisited = new boolean[v];
        for(int i =0;i<v;i++){
            if(!visited[i]){
                if(dfsCheck(i, adj, visited, pathVisited)){
                    return true;
                };
            }
        }
        return false;


    }
    public static void main(String[] args){
        int v = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);

        System.out.println("Cycle Present (DFS): " + isCyclicDFS(v, adj));

    }

    
}
