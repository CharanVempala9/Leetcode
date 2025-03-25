class Solution {
    public int maxVowels(String s, int k) {
        int l=0;
        int max=0;
        int cnt=0;
        int n=s.length(); 
        for(int r=0; r<n; r++){
            char ch=s.charAt(r);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ){
                cnt++;
            }
            if(r-l+1==k){
                max=Math.max(max,cnt);
                char c=s.charAt(l);
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                    cnt--;
                }
                l++;
            }
        }
        return max;
    }
}