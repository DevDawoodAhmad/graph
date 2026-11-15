import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BPG_Check {
    public static boolean check_BPG_DFS(int node,List<List<Integer>> adj,int[] color){

        for(int neighbour:adj.get(node)){
            if(color[neighbour]==-1){
                color[neighbour] = (color[node]+1)%2 ;
                if(!check_BPG_DFS(neighbour, adj, color)){
                    return false;

                }

            }
            else{
                if(color[neighbour]==color[node]){
                    return false;
                }
            }
            
        }
        return true;
    }
    public static boolean dfs_Traverse(int v,List<List<Integer>> adj){
        int[] color = new int[v];
        Arrays.fill(color, -1);
        
        for(int i =0;i<v;i++){
            if(color[i]==-1){
                color[i] = 0;
                if(!check_BPG_DFS(i, adj, color)){
                return false;
            }
            }
        }
        return true;
    }
    public static void main(String[] args){

        int v = 5;
        List<List<Integer>> adj = new ArrayList<>();
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

        boolean result = dfs_Traverse(v,adj);
        
        System.out.println("Is PBG: "+result);
        



    }
    
}
