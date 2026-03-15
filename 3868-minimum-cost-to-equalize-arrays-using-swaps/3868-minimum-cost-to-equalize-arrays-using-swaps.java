import java.util.*;

class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hash1 = new HashMap<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int num : nums1){
            hash1.put(num, hash1.getOrDefault(num,0) + 1);
            hash.put(num, hash.getOrDefault(num,0) + 1);
        }
        for(int num : nums2){
            hash1.put(num, hash1.getOrDefault(num,0) - 1);
            hash.put(num, hash.getOrDefault(num,0) + 1);
        }
        for(int val : hash.values()){
            if(val % 2 != 0) return -1;
        }
        int ans = 0;
        for(int val : hash1.values()){
            ans += Math.abs(val) / 2;
        }
        return ans / 2;
    }
}