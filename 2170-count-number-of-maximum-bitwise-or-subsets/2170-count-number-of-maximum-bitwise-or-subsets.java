class Solution {
    public int cnt(int idx,int cnt,int target,int[] nums){
        if(idx==0){
            int Take= ((cnt | nums[0] )== target ) ? 1: 0;
            int notTake= (cnt ==  target) ? 1: 0;
            return notTake+Take;
        }
        int Nottake=cnt(idx-1, cnt, target, nums);
        int Take=cnt(idx-1, cnt | nums[idx], target, nums);

        return Nottake + Take;
    }
    public int countMaxOrSubsets(int[] nums) {
        int max =0;
        int n=nums.length;
        for(int i=0; i<n; i++){
            max |= nums[i];
        }
        return cnt(n-1,0,max,nums);
    }
}