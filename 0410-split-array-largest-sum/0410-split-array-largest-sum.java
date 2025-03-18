class Solution {
    public static boolean ispossible(int[] nums, int k, int mid) {
        int sum = 0;
        k-=1;
        for(int i=0; i<nums.length; i++){
            int val=nums[i];
            if(val>mid){
                return false;
            }
            if(sum+val>mid){
                k-=1;
                sum=0;
            }
            sum+=nums[i];
            if(k<0)
            return false;
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int l = 0, h = (int)Math.pow(10,9);

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (ispossible(nums, k, mid)) {
                h = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }
        return l;
    }
}
