class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tsum=0;
        int sum=0;
        int ans=0;
        int n=gas.length;
        for(int i=0; i<n; i++){
            tsum+=gas[i]-cost[i];
            sum+=gas[i]-cost[i];
            if(sum<0){
                sum=0;
                ans=i+1;
            }
        }
        return (tsum<0) ? -1 : ans; 
    }
}