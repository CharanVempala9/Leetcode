class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n=dimensions.length;
        double max=0;
        int ans=0;
        for(int i=0; i<n; i++){
            int p1=dimensions[i][0];
            int p2=dimensions[i][1];
            double val=Math.sqrt(p1*p1+p2*p2);
            if(val>max){
                max=val;
                ans=p1*p2;
            }
            else if(max==val){
                ans=Math.max(ans,p1*p2);
            }
        }
        return ans;
    }
}