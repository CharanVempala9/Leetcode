class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long l = q[0], r = q[1];
            long total = prefixSum(r) - prefixSum(l - 1); 
            ans += (total + 1) / 2; 
        }
        return ans;
    }
    private long prefixSum(long N) {
        if (N <= 0) return 0;
        long sum = 0;
        long k = 1;     
        long start = 1;  
        while (start <= N) {
            long nextStart = start * 4;            
            long end = Math.min(N, nextStart - 1);
            long cnt = end - start + 1;       
            sum += k * cnt;
            start = nextStart;
            k++;
        }
        return sum;
    }
}
