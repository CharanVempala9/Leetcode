class Solution {
    public int countMonobit(int n) {
        int ans=1;
        for(int i=1; i<=n; i++){
            int sq=(int)Math.pow(2,i)-1;
            if(sq<=n){
                ans++;
            }
        }
        return ans;
    }
}