class Solution {
    public int robber(int[] nums){
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
    
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
    
        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length==1)
        return nums[0];
        int n=nums.length;
        int[] temp1=new int[n-1];
        int[] temp2=new int[n-1];
        for(int i=0; i<n-1; i++){
            temp1[i]=nums[i];
        }
        for(int i=0; i<n-1; i++){
            temp2[i]=nums[i+1];
        }
        int f=robber(temp1);
        int s=robber(temp2);
        return Math.max(f,s);
    }
}