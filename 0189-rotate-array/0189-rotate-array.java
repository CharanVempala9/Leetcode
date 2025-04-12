class Solution {
    public int[] reverse(int[] nums, int st, int end){
        while(st<=end){
            int temp=nums[end];
            nums[end]=nums[st];
            nums[st]=temp;
            st++;
            end--;
        }
        return nums;
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k = k % n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
}