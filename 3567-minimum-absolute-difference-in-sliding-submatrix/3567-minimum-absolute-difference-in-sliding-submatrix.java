class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        if(k==1) return new int[n-k+1][m-k+1];
        int[][] res=new int[n-k+1][m-k+1];
        for(int i=0; i<n-k+1; i++){
            for(int j=0; j<m-k+1; j++){
                //now submatrice of length k
                HashSet<Integer>hs=new HashSet<>();
                for(int l=i; l<i+k && l<n; l++){
                    for(int r=j; r<j+k && r<m ; r++){
                        hs.add(grid[l][r]);
                    }
                }
                ArrayList<Integer>ls=new ArrayList<>(hs);
                Collections.sort(ls);
                int min=Integer.MAX_VALUE;
                for(int l=1; l<ls.size(); l++){
                    min=Math.min(min,Math.abs(ls.get(l-1)-ls.get(l)));
                }
                if(min!=Integer.MAX_VALUE)
                res[i][j]=min;
            }
        }
        return res;
    }
}


/*      0   1
    0   1   8
    1   3   -2

       -2 3 3 5


*/