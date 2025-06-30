class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int ridx=0;
        while(ridx<n){
            int l=0;
            int h=matrix[0].length-1;
            while(l<=h){
                int mid=l+(h-l)/2;
                if(matrix[ridx][mid]==target){
                    return true;
                }
                if(matrix[ridx][mid]<target){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }
            ridx++;
        }
        return false;
    }
}