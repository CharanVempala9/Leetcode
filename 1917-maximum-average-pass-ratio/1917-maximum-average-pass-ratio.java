import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] c : classes) {
            int p = c[0], t = c[1];
            double gain = ((double)(p + 1) / (t + 1)) - ((double)p / t);
            pq.offer(new double[]{gain, p, t});
        }
        while (extraStudents-- > 0) {
            double[] top = pq.poll(); 
            int p = (int) top[1];
            int t = (int) top[2];
            p++;
            t++;
            double gain = ((double)(p + 1) / (t + 1)) - ((double)p / t);
            pq.offer(new double[]{gain, p, t});
        }
        double ans = 0.0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            int p = (int) top[1];
            int t = (int) top[2];
            ans += (double) p / t;
        }
        return ans / n;
    }
}
