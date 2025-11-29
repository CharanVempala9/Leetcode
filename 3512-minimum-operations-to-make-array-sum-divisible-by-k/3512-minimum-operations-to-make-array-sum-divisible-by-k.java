class Solution {
    public int minOperations(int[] nums, int k) {
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        return sum%k;
    }
}