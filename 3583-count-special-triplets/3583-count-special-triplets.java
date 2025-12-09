class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int mod = 1000000007;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], new ArrayList<>());
            }
            hm.get(nums[i]).add(i);
        }
        long ans = 0;
        for (int i = 1; i < n - 1; i++) {
            long val = 2L * nums[i];
            if (val > Integer.MAX_VALUE) continue;
            int target = (int) val;
            if (hm.containsKey(target)) {
                List<Integer> list = hm.get(target);
                int lcnt = lowerBound(list, i);
                int acnt = list.size() - upperBound(list, i);
                if (lcnt > 0 && acnt > 0) {
                    ans = (ans + (long) lcnt * acnt) % mod;
                }
            }
        }
        return (int) ans;
    }
    private int lowerBound(List<Integer> list, int key) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    private int upperBound(List<Integer> list, int key) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
