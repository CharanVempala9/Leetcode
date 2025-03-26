class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        int[] arr=new int[n*m];
        int idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[idx]=grid[i][j];
                idx++;
            }
        }
        Arrays.sort(arr);
        int median=arr[(n*m)/2];
        int res=0;
        for(int i=0; i<n*m; i++){
            if((Math.abs(median-arr[i])%x)==0){
                res+=(Math.abs(median-arr[i]))/x;
            }
            else{
                return -1;
            }
        }
        return res;
    }
}