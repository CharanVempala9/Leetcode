class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int p1=0;
        int p2=0;
        int idx=0;
        int max=Math.max(nums1.length,nums2.length);
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0; i<max; i++){
            if(i<nums1.length)
            hs.add(nums1[i][0]);
            if(i<nums2.length)
            hs.add(nums2[i][0]);
        }
        int[][] merged=new int[hs.size()][2];
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1][0]>nums2[p2][0]){
                merged[idx][0]=nums2[p2][0];
                merged[idx][1]=nums2[p2][1];
                p2++;
                idx++;
            }
            else if(nums1[p1][0]<nums2[p2][0]){
                merged[idx][0]=nums1[p1][0];
                merged[idx][1]=nums1[p1][1];
                p1++;
                idx++;
            }
            else{
                int val=nums1[p1][1]+nums2[p2][1];
                merged[idx][0]=nums1[p1][0];
                merged[idx][1]=val;
                p1++;
                p2++;
                idx++;
            }
        }
        while(p1<nums1.length){
            merged[idx][0]=nums1[p1][0];
            merged[idx][1]=nums1[p1][1];
            idx++;
            p1++;
        }
        while(p2<nums2.length){
            merged[idx][0]=nums2[p2][0];
            merged[idx][1]=nums2[p2][1];
            idx++;
            p2++;
        }
        return merged;
    }
}