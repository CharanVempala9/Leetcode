class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] leftsum=new int[n+1];
        int[] rightsum=new int[n+1];
        leftsum[0]=0;
        rightsum[n]=0;
        int left=0;
        int right=0;
        for(int i=0; i<n; i++){
            left+=nums[i];
            leftsum[i+1]=left;
        }
        for(int i=n-1; i>=0; i--){
            right+=nums[i];
            rightsum[i]=right;
        }
        for(int i=0; i<n; i++){
            if(rightsum[i]==leftsum[i+1])
            return i;
        }
        return -1;
    }
}