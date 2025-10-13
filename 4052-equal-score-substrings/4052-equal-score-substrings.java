class Solution {
    public boolean scoreBalance(String s) {
        int[] pre = new int[s.length()];
        int sum = 0;
        pre[0] = s.charAt(0) - 'a' +1;
        sum = pre[0];
        //System.out.println(sum);
        for (int i = 1; i < s.length(); i++) {
            sum += s.charAt(i) - 'a'+1;
            pre[i] = pre[i - 1] + s.charAt(i) - 'a'+1;
        }
        System.out.println(sum);
        if(sum%2!=0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (sum%2==0 && (sum / 2 == pre[i])) {
                return true;
            }
        }
        return false;
    }
}