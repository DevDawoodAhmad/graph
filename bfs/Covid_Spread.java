import java.util.LinkedList;
import java.util.Queue;

/**
 * Covid_Spread
 */
public class Covid_Spread {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    private final int[] row = {-1,1,0,0};
    private final int[] col = {0,0,-1,1};
    private int r;
    private int c;
    private boolean valid(int i,int j){
        return i>=0 && i<r && j>=0 && j<c;
    }
    public int checkSpread(int[][] hospital){
        r = hospital.length;
        c = hospital[0].length;
        Queue<Pair> q = new LinkedList<>();

        for(int i =0;i<r;i++){
            for(int j =0;j<c;j++){
                if(hospital[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        int timer = 0;
        while (!q.isEmpty()) {
            timer++;
            int currPatient = q.size();
            while(currPatient-- > 0){
                Pair curr = q.poll();
                int i = curr.first;
                int j = curr.second;
                for(int k = 0;k<4;k++){
                    int newRow = i + row[k];
                    int newCol = j + col[k];
                    if(valid(newRow, newCol)&& hospital[newRow][newCol]==1){
                        hospital[newRow][newCol]= 2;
                        q.add(new Pair(newRow, newCol));

                    }
                }
            }
            
        }
        for(int i =0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(hospital[i][j]==1){
                    return -1;
                }
            }

        }
        return timer == 0 ? 0: timer -1;
    }
    public static void main(String[] args) {
        Covid_Spread solver = new Covid_Spread();

        // Test Case 1: Standard spread (Expected: 2)
        int[][] hospital1 = {
            {2, 1, 0, 2, 1},
            {1, 0, 1, 2, 1},
            {1, 0, 0, 2, 1}
        };
        System.out.println("Test 1 (Standard Spread): " + solver.checkSpread(hospital1));

        // Test Case 2: Isolated patient blocked by 0s (Expected: -1)
        int[][] hospital2 = {
            {2, 1, 0, 2, 1},
            {0, 0, 1, 2, 1},
            {1, 0, 0, 2, 1} // Bottom-left '1' at (2,0) is completely trapped
        };
        System.out.println("Test 2 (Isolated Patient): " + solver.checkSpread(hospital2));

        // Test Case 3: Everyone is already infected (Expected: 0)
        int[][] hospital3 = {
            {2, 2},
            {2, 0}
        };
        System.out.println("Test 3 (Already Infected): " + solver.checkSpread(hospital3));

        // Test Case 4: Empty hospital with only 0s (Expected: 0)
        int[][] hospital4 = {
            {0, 0},
            {0, 0}
        };
        System.out.println("Test 4 (Empty Hospital): " + solver.checkSpread(hospital4));

        // Test Case 5: Healthy patients exist, but zero COVID patients (Expected: -1)
        int[][] hospital5 = {
            {1, 1},
            {0, 1}
        };
        System.out.println("Test 5 (No Initial 2s): " + solver.checkSpread(hospital5));
    }
}