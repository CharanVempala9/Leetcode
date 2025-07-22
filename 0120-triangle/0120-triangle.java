import java.util.*;

class Solution {
    public int gen(int i, int j, int n, List<List<Integer>> triangle, int[][] dp) {
        if (i == n) {
            return triangle.get(i).get(j);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int val = triangle.get(i).get(j);
        int down = gen(i + 1, j, n, triangle, dp);
        int diag = gen(i + 1, j + 1, n, triangle, dp);

        return dp[i][j] = val + Math.min(down, diag);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        //base case
        for(int j=0; j<n; j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int val=triangle.get(i).get(j);
                int down= dp[i+1][j] + val;
                int diag= dp[i+1][j+1] + val;  

                dp[i][j]=Math.min(down,diag);
            }
        }
        return dp[0][0];
    }
}
