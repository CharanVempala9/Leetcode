class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int max=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]=='1'){
                    int id1=i;
                    int minw=Integer.MAX_VALUE;
                    while(id1<n && matrix[id1][j]=='1'){
                        int id2=j;
                        while(id2<m && matrix[id1][id2]=='1'){
                            id2++;
                        }
                        minw=Math.min(minw,id2-j);
                        int h=id1-i+1;
                        int area=h*minw;
                        max=Math.max(area,max);
                        id1++;
                    }
                }
            }
        }
        return max;
    }
}

/*  2*(l+b) --> 


*/