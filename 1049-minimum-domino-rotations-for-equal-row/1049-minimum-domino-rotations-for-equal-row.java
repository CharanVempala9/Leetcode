class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n=tops.length;
        int[] top = new int[7];
        int[] bt = new int[7];
        int max1 = 0, max2 = 0;
        int val1 = 0, val2 = 0;

        for(int i = 0; i < n; i++) {
            top[tops[i]]++;
            if(top[tops[i]] > max1) {
                max1 = top[tops[i]];
                val1 = tops[i];
            }

            bt[bottoms[i]]++;
            if(bt[bottoms[i]] > max2) {
                max2 = bt[bottoms[i]];
                val2 = bottoms[i];
            }
        }   
        System.out.println(val1);
        System.out.println(val2);
        System.out.print(Arrays.toString(bt));
        int max=Math.max(val1,val2);
        int cnt=0;
        for(int i=0; i<n; i++){
            if(tops[i]!=max && bottoms[i]!=max)
            return -1;
            if(tops[i]!=max && bottoms[i]==max)
            cnt++;
        }
        int cnt1=0;
        for(int i=0; i<n; i++){
            if(tops[i]==max && bottoms[i]!=max)
            cnt1++;
        }
        return Math.min(cnt,cnt1);
    }
}