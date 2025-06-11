class Solution {
    private static final int MOD = (int) 1e8;
    private int maxDfromAtoB(int a, int b, int k, int n, int[][] freq) {
        int cnt = Integer.MIN_VALUE;
        int[][] minFreq = { {MOD, MOD}, {MOD, MOD} };
        int freqA = 0, freqB = 0;
        int prevA = 0, prevB = 0;
        int l = 0;
        for (int r = k - 1; r < n; r++) {
            freqA = freq[a][r + 1];
            freqB = freq[b][r + 1];
            while (r - l + 1 >= k && freqB - prevB >= 2) {
                minFreq[prevA & 1][prevB & 1] = Math.min(minFreq[prevA & 1][prevB & 1], prevA - prevB);
                prevA = freq[a][l + 1];
                prevB = freq[b][l + 1];
                l++;
            }
            cnt = Math.max(cnt, freqA - freqB - minFreq[1 - (freqA & 1)][freqB & 1]);
        }
        return cnt;
    }

    public int maxDifference(String s, int k) {
        int n = s.length();
        int[][] freq = new int[5][n + 1];
        for (int i = 0; i < n; i++) {
            for (int d = 0; d < 5; d++) {
                freq[d][i + 1] = freq[d][i];
            }
            freq[s.charAt(i) - '0'][i + 1]++;
        }
        int ans = Integer.MIN_VALUE;
        for (int a = 0; a < 5; a++) {
            if (freq[a][n] == 0)
                continue;
            for (int b = 0; b < 5; b++) {
                if (a == b || freq[b][n] == 0)
                    continue;
                ans = Math.max(ans, maxDfromAtoB(a, b, k, n, freq));
            }
        }
        return ans;
    }
}