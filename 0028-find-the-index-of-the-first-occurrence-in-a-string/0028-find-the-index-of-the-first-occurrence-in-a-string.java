class Solution {
    public int strStr(String haystack, String needle) {
        int n1=haystack.length();
        int n2=needle.length();
        int p1=0;
        int p2=0;
        int ans=0;
        while(p1<n1 && p2<n2){
            if(haystack.charAt(p1)==needle.charAt(p2)){
                if(p2==0)
                ans=p1;
                p1++;
                p2++;
            }
            else{
                p1=p1-p2+1;
                p2=0;
            }
        }
        if(p2!=n2){
            return -1;
        }
        return ans;
    }
}