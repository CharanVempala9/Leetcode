import java.util.*;

class Solution {
    public int can(int l, int r, int[] arr, int x) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                list.add(new int[]{arr[i], i}); 
            }
        }
        list.sort((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        int sum = 0;
        for (int i = 0; i < Math.min(x, list.size()); i++) {
            sum += list.get(i)[0] * list.get(i)[1];
        }
        return sum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] freq = new int[51]; 
        int l = 0, idx = 0;
        for (int r = 0; r < n; r++) {
            freq[nums[r]]++;
            if (r - l + 1 > k) {
                freq[nums[l]]--;
                l++;
            }
            if (r - l + 1 == k) {
                res[idx++] = can(l, r, freq, x);
            }
        }
        return res;
    }
}
