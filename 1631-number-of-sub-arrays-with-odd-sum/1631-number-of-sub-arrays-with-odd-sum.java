class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddCount = 0, evenCount = 1;
        int sum = 0, cnt = 0;
        int MOD = 1000000007;
        
        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                cnt = (cnt + oddCount) % MOD;
                evenCount++;
            } else {
                cnt = (cnt + evenCount) % MOD;
                oddCount++;
            }
        }
        
        return cnt;
    }
}
