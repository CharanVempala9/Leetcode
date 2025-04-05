class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0; i<n; i++){
            boolean ans=false;
            int temp=0;
            for(int j=1; j<n; j++){
                if(nums[(i+j)%n]>nums[i]){
                    ans=true;
                    temp=(i+j)%n;
                    break;
                }
            }
            if(ans)
            res[i]=nums[temp];
            else
            res[i]=-1;
        }
        return res;
    }
}