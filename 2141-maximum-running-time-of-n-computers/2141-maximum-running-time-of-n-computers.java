class Solution {
    public boolean isposs(long a,int n,int[] bat){
        long cnt=0;
        for(int i=0; i<bat.length; i++){
            cnt+=Math.min(a,bat[i]);
        }
        if(cnt>=a*n)return true;
        return false;
    }
    public long maxRunTime(int n, int[] bat) {
        long ans=0;
        long l=0;
        long h=0;
        for(int a:bat){
            h+=a;
        }
        h=h/n;
        Arrays.sort(bat);
        while(l<=h){
            long mid=l+(h-l)/2;
            if(isposs(mid,n,bat)){
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