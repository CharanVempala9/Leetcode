class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int l=0;
        int cnt=0;
        int ans=Integer.MAX_VALUE;
        for(int r=0; r<n; r++){
            if(blocks.charAt(r)=='W')
            cnt+=0;
            else
            cnt+=1;
            if(r-l+1==k){
                int temp=Math.abs(k-cnt);
                ans=Math.min(ans,temp);
                if(blocks.charAt(l)=='B'){
                    cnt--;
                }
                l++;
            }
        }
        return ans;
    }
}