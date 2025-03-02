import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int p1 = 0;
        int p2 = 0;
        List<int[]> mergedList = new ArrayList<>();
        
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1][0] > nums2[p2][0]) {
                mergedList.add(new int[]{nums2[p2][0], nums2[p2][1]});
                p2++;
            } else if (nums1[p1][0] < nums2[p2][0]) {
                mergedList.add(new int[]{nums1[p1][0], nums1[p1][1]});
                p1++;
            } else {
                mergedList.add(new int[]{nums1[p1][0], nums1[p1][1] + nums2[p2][1]});
                p1++;
                p2++;
            }
        }
        
        while (p1 < nums1.length) {
            mergedList.add(new int[]{nums1[p1][0], nums1[p1][1]});
            p1++;
        }
        
        while (p2 < nums2.length) {
            mergedList.add(new int[]{nums2[p2][0], nums2[p2][1]});
            p2++;
        }
        
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
