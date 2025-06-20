class Solution {
    public int minPartitions(String n) {
        int s=n.length();
        int max=0;
        for(int i=0; i<s; i++){
            int val=n.charAt(i)-'0';
            max=Math.max(val,max);
        }
        return max;
    }
}