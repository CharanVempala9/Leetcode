class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int t = 0;
        
        Deque<Integer> dq = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            while (!dq.isEmpty() && dq.peekFirst() <= r - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }
            dq.offerLast(r);
            if (r >= k - 1) {
                res[t++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
