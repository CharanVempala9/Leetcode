class Solution {
    public int rec(int idx, int[] days, int[] costs, int[] dp){
        if(idx>=days.length){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int cost=0;
        int cost1 = costs[0] + rec(idx+1, days, costs,dp);

        int i=idx;
        while(i<days.length &&  days[i]<days[idx]+ 7)  i++;
        int cost2 =  costs[1] + rec(i, days, costs,dp);

        i=idx;
        while(i<days.length && days[i] <days[idx] + 30) i++;
        int cost3= costs[2] + rec(i, days, costs,dp);

        dp[idx]=Math.min(cost1, Math.min(cost2, cost3));
        return dp[idx];
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        // int[][] dp=new int[n][3];
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return rec(0, days, costs,dp);
    }
}