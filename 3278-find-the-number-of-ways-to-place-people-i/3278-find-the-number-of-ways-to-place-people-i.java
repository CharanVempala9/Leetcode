class Solution {
    public int numberOfPairs(int[][] points) {
        int n=points.length;
       Arrays.sort(points, (a, b) -> {
    if (a[0] == b[0]) {
        return Integer.compare(b[1], a[1]); 
    }
    return Integer.compare(a[0], b[0]); 
});

        // int =0;
        // int r=n-1;
        // while(l<r){
        //     int lftx=points[l][0];
        //     int lfty=points[l][1];
        //     int rgtx=points[r][0];
        //     int rgty=points[r][1];
        // }
        int ans=0;
        for(int i=0; i<n; i++){
            int lftx=points[i][0];
            int lfty=points[i][1]; 
            int min=Integer.MIN_VALUE;
            for(int j=i+1; j<n; j++){
                int rgtx=points[j][0];
                int rgty=points[j][1];
                if(min<rgty && rgty<=lfty){
                    ans++;
                    min=rgty;
                }
                if(rgty==lfty){
                    break;
                }
            }
        }
        return ans;
    }
}