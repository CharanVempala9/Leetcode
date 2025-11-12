class Solution {
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int minOperations(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int n=nums.length;
        int cnt=0;
        boolean fnd=false;
        for(int i=0; i<n; i++){
            if(nums[i]==1){
                cnt++;
            }
        }
        if(cnt>0) return n-cnt;
        for(int i=0;i<n; i++){
            int val=nums[i];
            for(int j=i+1; j<n; j++){
                val=gcd(val,nums[j]);
                if(val==1){
                    ans=Math.min(ans,(j-i)+(n-1));
                    break;
                }
            }
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}