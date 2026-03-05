class Solution {
    public int minOperations(String s) {
        char curr0 = '0', curr1 = '1';
        int result1 = 0, result2 = 0;

        for (char ch : s.toCharArray()) {
            if (curr0 != ch) result1++;
            if (curr1 != ch) result2++;
            curr0 = (curr0 == '0') ? '1' : '0';
            curr1 = (curr1 == '0') ? '1' : '0';
        }

        return Math.min(result1, result2);
    }
}