class Solution {
    public long maximumTripletValue(int[] n) {
       
        int len=n.length;
          long ans=0;
          int[] prefixsum= new int[len];
          prefixsum[0]=n[0];
        for (int i = 1; i < len; i++) {
            prefixsum[i]=Math.max(n[i],prefixsum[i-1 ]);
        }
        int[] suffixsum= new int[len];
        suffixsum[len-1]=n[len-1];
        for (int i = len-2; i >=0; i--) {

            suffixsum[i]=Math.max(n[i],suffixsum[i+1]);
        }
        for (int j = 1; j < len-1; j++) {
            long tripple=(long)(prefixsum[j - 1] - n[j]) * suffixsum[j + 1];
            ans =Math.max(ans,tripple);
        }
          return ans;
    }
}