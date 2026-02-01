class Solution {
    public int minimumCost(int[] nums) {
        int cost=nums[0];
        int n=nums.length;
        int min=nums[1];
        int smin=Integer.MAX_VALUE;
        for(int i=2; i<n; i++){
            if(nums[i]<min){
                smin=min;
                min=nums[i];
            }
            else if(nums[i]>=min && nums[i]<smin){
                smin=nums[i];
            }
        }
        //System.out.println(cost+" "+min+" "+smin);
        return cost+min+smin;
    }
}