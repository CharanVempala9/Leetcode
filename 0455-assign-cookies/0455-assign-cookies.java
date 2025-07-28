class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n1=g.length;
        int n2=s.length;
        int i1=0;
        int i2=0;
        int ans=0;
        while(i1< n1 && i2< n2){
            if(g[i1]<= s[i2]){
                ans++;
                i1++;
                i2++;
            }
            else{
                i2++;
            }
        }
        return ans;
    }
}