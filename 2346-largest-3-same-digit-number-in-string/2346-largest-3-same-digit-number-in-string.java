class Solution {
    public String largestGoodInteger(String num) {
        int max = -1;
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i - 1) == num.charAt(i - 2)) {
                int digit = num.charAt(i) - '0'; 
                max = Math.max(max, digit);
            }
        }
        if(max==-1) return "";
        StringBuilder res=new StringBuilder();
        res.append(max);
        res.append(max);
        res.append(max);
        return res.toString();
    }
}