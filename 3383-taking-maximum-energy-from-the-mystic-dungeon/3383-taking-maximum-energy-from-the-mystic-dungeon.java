class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n=energy.length;
        int[] pre=new int[n];
        pre[0]=energy[0];
        for(int i=0; i<n-k; i++){
            pre[i]=energy[i]+energy[i+k];
            energy[i+k]=Math.max(pre[i],energy[i+k]);
        }
        for(int i=n-k; i<n; i++){
            pre[i]=energy[i];
        }
        int max=Integer.MIN_VALUE;
        for(int i=n-k; i<n; i++){
            max=Math.max(pre[i],max);
        }
        return max;
    }
}