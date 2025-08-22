class Solution {
    public int rec(int r, int c, int[][] dungeon,int[][] dp) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        if (r >= n || c >= m) return (int) 1e9;
        if (r == n - 1 && c == m - 1) {
            return dungeon[r][c] <= 0 ? -dungeon[r][c] + 1 : 1;
        }
        if(dp[r][c]!=-1) return dp[r][c];
        int right = rec(r, c + 1, dungeon,dp);
        int down = rec(r + 1, c, dungeon,dp);

        int need = Math.min(right, down) - dungeon[r][c];
        dp[r][c] = need <= 0 ? 1 : need;
        return dp[r][c];
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int[][] dp=new int[n+1][m+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(0, 0, dungeon,dp);
    }
}
