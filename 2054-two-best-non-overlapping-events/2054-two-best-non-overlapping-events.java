class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        int n = events.length;
        int res = 0;
        int maxPrev = 0;
        int[][] byEnd = events.clone();
        Arrays.sort(byEnd, (a, b) -> Integer.compare(a[1], b[1]));
        int j = 0;
        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int val = events[i][2];
            while (j < n && byEnd[j][1] < start) {
                maxPrev = Math.max(maxPrev, byEnd[j][2]);
                j++;
            }
            res = Math.max(res, maxPrev + val);
        }
        return res;
    }
}
