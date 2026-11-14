package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BPG_Check {
    public  static boolean check_BPG(int v,List<List<Integer>> adj){
        int[] color = new int[v];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(color, -1);
        for(int i =0;i<v;i++){
            if(color[i]==-1){
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for(int neighbour: adj.get(curr)){
                        if(color[neighbour]== -1){
                            color[neighbour]= (color[curr]+1)%2;
                            q.add(neighbour);
                        }
                        else{
                            if(color[neighbour]==color[curr]){
                                return false;
                            }
                        }

                    }
                    
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

        boolean result = check_BPG(v,adj);
        
        System.out.println("Is PBG: "+result);
        



    }
    
}
