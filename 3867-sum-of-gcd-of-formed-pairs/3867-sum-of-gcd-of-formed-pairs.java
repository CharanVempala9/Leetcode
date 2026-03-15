class Solution {
    public int gcd(int a, int b) {
    if (b == 0) 
        return a;
        return gcd(b, a % b);
    }
    public long gcdSum(int[] nums) {
        long ans=0;
        int n=nums.length;
        int[] pfx=new int[n];
        int max=0;
        for(int i=0; i<n; i++){
            max=Math.max(max,nums[i]);
            pfx[i]=gcd(nums[i],max);
        }
        Arrays.sort(pfx);
        int l=0;
        int r=n-1;
        while(l<r){
            int val=gcd(pfx[l],pfx[r]);
            l++;
            r--;
            ans+=val;
        }
        return ans;
    }
}