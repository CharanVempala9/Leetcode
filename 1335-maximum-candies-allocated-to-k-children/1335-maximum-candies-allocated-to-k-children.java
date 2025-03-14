class Solution {
    public boolean ispossible(int[] candies, long k,int mid){
        long cnt = 0;
        for (int candy : candies) {
            cnt += (candy / mid); 
            if (cnt >= k) {
                return true; 
            }
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        long sum=0;
        int max=0;
        for(int i=0; i<n; i++){
            sum+=candies[i];
            max=Math.max(max,candies[i]);
        }
        if(sum<k)
        return 0;
        int l=1;
        int ans=0;
        int h=max;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(ispossible(candies,k,mid)){
                ans=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return ans;
    }
}