class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return Integer.compare(b[0], a[0]);   
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }

        List<int[]> topK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topK.add(pq.poll());
        }

        topK.sort((a, b) -> Integer.compare(a[1], b[1]));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK.get(i)[0];
        }
        return res;
    }
}
