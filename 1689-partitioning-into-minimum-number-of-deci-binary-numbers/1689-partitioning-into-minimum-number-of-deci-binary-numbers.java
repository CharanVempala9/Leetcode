class Solution {
    public int minPartitions(String n) {
        int size=n.length();
        int max=0;
        for(int i=0; i<size; i++){
            max=Math.max(max,n.charAt(i)-'0');
        }
        return max;
    }
}