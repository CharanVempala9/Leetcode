class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int ans : answers) {
            hm.put(ans, hm.getOrDefault(ans, 0) + 1);
        }

        int ans = 0;
        for (int x : hm.keySet()) {
            int cnt = hm.get(x);
            int temp = x + 1;
            int groups = (cnt + x) / temp; 
            ans += groups * temp;
        }

        return ans;
    }
}
