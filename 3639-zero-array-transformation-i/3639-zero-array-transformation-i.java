class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] diff=new int[n+1];
        for(int i=0; i<queries.length; i++){
            int l=queries[i][0];
            int r=queries[i][1];

            diff[l]+=1;
            if(r+1<n)
            diff[r+1]--;
        }
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=diff[i];
            if(nums[i]>sum){
                return false;
            }
        }
        return true;
    }
}