class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        long ans=0;
        int n=nums1.length;
        int last=nums2[n];
        long min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(last>=Math.min(nums1[i],nums2[i]) && last<=Math.max(nums1[i],nums2[i])){
                min=0;
            }
            ans+=Math.abs(nums1[i]-nums2[i]);
            min=Math.min(min,Math.abs(nums1[i]-last));
            min=Math.min(min,Math.abs(nums2[i]-last));
        }
        return ans+min+1;
    }
}