class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int div=n/3;
        int[][] res=new int[div][3];
        int idx=0;
        for(int i=0; i<div; i++){
            for(int j=0; j<3; j++){
                res[i][j]=nums[idx];
                idx++;
            }
            if((Math.abs(res[i][0]-res[i][1])>k) || (Math.abs(res[i][0]-res[i][2])>k) || (Math.abs(res[i][1]-res[i][2])>k)){
                return new int[0][0];
            }
        }
        return res;
    }
}