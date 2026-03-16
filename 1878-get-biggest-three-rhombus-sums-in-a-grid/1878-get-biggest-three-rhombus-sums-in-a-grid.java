class Solution {
    public void can(int i,int j,int inc,int[][] grid,PriorityQueue<Integer>pq){
        if(i+2*inc>=grid.length || j-inc<0 || inc+j>=grid[0].length){
            return;
        }
        int sum = 0;
        for (int k = 0; k < inc; k++) sum += grid[i + k][j + k];
        for (int k = 0; k < inc; k++) sum += grid[i + inc + k][j + inc - k];
        for (int k = 0; k < inc; k++) sum += grid[i + 2 * inc - k][j - k];
        for (int k = 0; k < inc; k++) sum += grid[i + inc - k][j - inc + k];
        pq.add(sum);
        can(i,j,inc+1,grid,pq);
    }
    public int[] getBiggestThree(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                pq.add(grid[i][j]);
                can(i,j,1,grid,pq);
            }
        }
        TreeSet<Integer>ls=new TreeSet<>();
        while(!pq.isEmpty() && ls.size()<3){
            int val=pq.remove();
            ls.add(val);
        }
        int size=ls.size();
        int[] res=new int[size];
        int idx=size-1;
        for (int sum : ls) {
            res[idx--] = sum;
        }
        return res;
    }
}