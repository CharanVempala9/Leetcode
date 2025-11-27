class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long[] pfx=new long[n+1];
        for(int i=0; i<n; i++){
            pfx[i+1]=pfx[i]+nums[i];
        }
        long max=Long.MIN_VALUE;
        for(int i=0; i<k; i++){
            //right pass
            long csum=0;
            for(int j=i; j+k-1<n; j+=k){
                int r=j+k-1;
                long tmp=pfx[r+1]-pfx[j];
                csum+=tmp;
                max=Math.max(csum,max);
                if(csum<0){
                    csum=0;
                }
            }
        }
        return max;
    }
}

/*  prefix sum..? if i know sum there 
    1 3
      
    -1 -3 -6 -10 -15  

    -5 -4 -2 -5 -1


    9 -11  15
    9  -2  13
    


*/