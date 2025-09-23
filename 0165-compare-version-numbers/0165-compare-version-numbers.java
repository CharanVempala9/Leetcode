class Solution {
    public int compareVersion(String s1, String s2) {
        int l1 = 0, l2 = 0;
        int n1 = s1.length(), n2 = s2.length();

        while (l1 < n1 || l2 < n2) {
            int num1 = 0;
            while (l1 < n1 && s1.charAt(l1) != '.') {
                num1 = num1 * 10 + (s1.charAt(l1) - '0');
                l1++;
            }

            int num2 = 0;
            while (l2 < n2 && s2.charAt(l2) != '.') {
                num2 = num2 * 10 + (s2.charAt(l2) - '0');
                l2++;
            }

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;

            l1++;
            l2++;
        }

        return 0;
    }
}
