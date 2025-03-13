class Solution {
    public boolean ispossible(int[] nums,int[][] queries, int mid){
        int[] diff=new int[nums.length+1];
        for(int i=0; i<mid; i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int val=queries[i][2];
            diff[l]+=val;
            if(r+1<nums.length)
            diff[r+1]-=val;
        }
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=diff[i];
            if(nums[i]>sum)
            return false;
        }
        return true;

    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int low=0;
        int res=-1;
        int high=queries.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(ispossible(nums,queries,mid)==true){
            res=mid;
            high=mid-1;
            }
            else
            low=mid+1;
        }
        return res;
    }
}