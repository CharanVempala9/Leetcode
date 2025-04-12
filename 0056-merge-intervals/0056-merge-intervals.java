class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        ArrayList<int[]> ls = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]); 
            } else {
                ls.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ls.add(new int[]{start, end});

        int[][] res = new int[ls.size()][2];
        for (int i = 0; i < ls.size(); i++) {
            res[i][0] = ls.get(i)[0]; 
            res[i][1] = ls.get(i)[1];
        }

        return res;
    }
}
