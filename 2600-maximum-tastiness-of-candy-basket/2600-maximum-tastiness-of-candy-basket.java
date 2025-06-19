class Solution {
    public boolean isposs(int[] price,int mid,int k){
        int cnt=1;
        int n=price.length;
        int taken=price[0];
        for(int i=1; i<n; i++){
            if(price[i]-taken>=mid){
                cnt++;
                taken=price[i];
            }
        }
        return cnt>=k;
    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int h=-1;
        for(int p:price){
            h=Math.max(p,h);
        }
        int l=0;
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isposs(price,mid,k)){
                l=mid+1;
                ans=mid;
            }
            else{
                h=mid-1;
            }
        }
        return ans;
    }
}