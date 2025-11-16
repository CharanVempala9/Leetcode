class Solution {
    public int numSub(String s) {
        int n=s.length();
        long cnt=0;
        long ans=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1'){
                cnt++;
            }
            else{
                ans+=((cnt*(cnt+1))/2)%(long)1000000007;  
                cnt=0;
            }
        }
        ans+=((cnt*(cnt+1))/2)%(long)1000000007;  
        return (int)ans;
    }
}