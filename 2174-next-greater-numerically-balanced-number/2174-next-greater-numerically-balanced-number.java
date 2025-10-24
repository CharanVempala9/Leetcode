class Solution {
    public boolean isposs(int n){
        int[] cnt=new int[10];
        while(n>0){
            int rem=n%10;
            cnt[rem]++;
            n/=10;
        }
        for(int i=0; i<10; i++){
            if(cnt[i]>0 && cnt[i]!=i)return false;
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        for(int i=n+1; ; i++){
            if(isposs(i)){
                return i;
            }
        }
    }
}