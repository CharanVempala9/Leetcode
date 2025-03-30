class Solution {
    public int[] minCosts(int[] cost) {
        int min=Integer.MAX_VALUE;
        int[] res=new int[cost.length];
        for(int i=0; i<cost.length; i++){
            min=Math.min(min,cost[i]);
            res[i]=min;
        } 
        return res;
    }
}