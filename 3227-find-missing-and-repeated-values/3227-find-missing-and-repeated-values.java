class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int sum=0;
        int[] res=new int[2];
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sum+=grid[i][j];
                if(!hs.contains(grid[i][j]))
                hs.add(grid[i][j]);
                else
                res[0]=grid[i][j];
            }
        }
        int t=n*m;
        res[1]=t*(t+1)/2-(sum-res[0]);
        return res;
    }
}