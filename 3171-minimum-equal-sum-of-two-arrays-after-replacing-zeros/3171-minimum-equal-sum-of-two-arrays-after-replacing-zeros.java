class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        long sum1 = 0;
        long sum2 = 0;
        int n1zcnt = 0;
        int n2zcnt = 0;

        for (int i = 0; i < n1; i++) {
            if (nums1[i] == 0)
                n1zcnt++;
            sum1 += nums1[i];
        }

        for (int i = 0; i < n2; i++) {
            if (nums2[i] == 0)
                n2zcnt++;
            sum2 += nums2[i];
        }

        sum1 += n1zcnt;  
        sum2 += n2zcnt;

        if (n1zcnt == 0 && sum1 < sum2) return -1;
        if (n2zcnt == 0 && sum2 < sum1) return -1;

        return Math.max(sum1, sum2);
    }
}
