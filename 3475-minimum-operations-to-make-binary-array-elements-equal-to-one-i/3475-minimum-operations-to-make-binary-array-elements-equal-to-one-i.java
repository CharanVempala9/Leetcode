class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0; i<n-2; i++){
            if(nums[i]==0){
                flip(nums,i);
                cnt++;
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i]!=1)
            return -1;
        }
        return cnt;
    }
    public void flip(int[] nums,int idx){
        for(int i=idx; i<idx+3; i++){
            if(nums[i]==0)
            nums[i]=1;
            else
            nums[i]=0;
        }
    }
}