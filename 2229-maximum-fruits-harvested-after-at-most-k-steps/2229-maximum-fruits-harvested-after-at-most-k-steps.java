class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int max = 0;
        int sum = 0;

        int l = 0;

        for (int r = 0; r < n; r++) {
            sum += fruits[r][1];

            
            while (l <= r && minSteps(fruits[l][0], fruits[r][0], startPos) > k) {
                sum -= fruits[l][1];
                l++;
            }

            max = Math.max(max, sum);
        }

        return max;
    }

    private int minSteps(int left, int right, int startPos) {
        if (startPos <= left) {
            return right - startPos;
        } else if (startPos >= right) {
            return startPos - left;
        } else {
            return Math.min(
                2 * (startPos - left) + (right - startPos),
                2 * (right - startPos) + (startPos - left)
            );
        }
    }
}
