import java.util.HashMap;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(arr[i], i);
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i];
                int b = arr[j];
                int length = 2;
                while (hm.containsKey(a + b)) {
                    int c = a + b;
                    a = b;
                    b = c;
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        if(max>2) 
        return max;
        else
        return 0;
    }
}
