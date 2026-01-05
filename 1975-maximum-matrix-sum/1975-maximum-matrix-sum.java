class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans=0;
        int cnt=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]<0){
                    cnt++;
                }
                ans+=Math.abs(matrix[i][j]);
                min=Math.min(min,Math.abs(matrix[i][j]));
            }
        }
        if(cnt%2==0){
            return ans;
        }
        return ans-min-min;
    }
}