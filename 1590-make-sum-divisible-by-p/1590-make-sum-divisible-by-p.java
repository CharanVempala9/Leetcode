class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;
        int rem = (int)(total % p);
        if (rem == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 
        int prefix = 0;
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int need = (prefix - rem + p) % p;
            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }
            map.put(prefix, i);
        }
        return ans == nums.length ? -1 : ans;
    }
}

/*  i need to find the min length of subarray of that remainder... how...>

    sliding window..? 
    3 4 8 10   how can i get this one..? not by slidind window

 */