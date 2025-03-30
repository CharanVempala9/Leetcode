class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int sum=0;
        int n=gain.length;
        for(int i=0; i<n; i++){
            sum+=gain[i];
            max=Math.max(sum,max);
        }
        return max;
    }
}